//
//  CoUkDevpulseAdobemarketingcloudMediaHeartbeatProxy.m
//  AdobeMarketingCloud
//
//  Created by Junaid Younus on 03/05/2017.
//
//

#import "CoUkDevpulseAdobemarketingcloudMediaHeartbeatProxy.h"
#import "TiUtils.h"


@interface CoUkDevpulseAdobemarketingcloudMediaHeartbeatProxy() <ADBMediaHeartbeatDelegate>
@property (nonatomic, strong) ADBMediaHeartbeat* mediaHeartbeat;
@end


@implementation CoUkDevpulseAdobemarketingcloudMediaHeartbeatProxy


-(void)_initWithProperties:(NSDictionary *)args {
    [self log:@"Inside _initWithProperties"];
    
    id trackingServer = [args objectForKey:@"trackingServer"];
    id channel = [args objectForKey:@"channel"];
    id appVersion = [args objectForKey:@"appVersion"];
    id ovp = [args objectForKey:@"ovp"];
    id playerName = [args objectForKey:@"playerName"];
    id ssl = [args objectForKey:@"ssl"];
    id debugLogging = [args objectForKey:@"debugLogging"];
    
    ENSURE_STRING(trackingServer)
    ENSURE_STRING(channel)
    ENSURE_STRING(appVersion)
    ENSURE_STRING(ovp)
    ENSURE_STRING(playerName)
    ENSURE_TYPE(ssl, NSNumber)
    ENSURE_TYPE(debugLogging, NSNumber)
    
    ADBMediaHeartbeatConfig *config = [[ADBMediaHeartbeatConfig alloc] init];
    config.trackingServer = trackingServer;
    config.channel = channel;
    config.appVersion = appVersion;
    config.ovp = ovp;
    config.playerName = playerName;
    config.ssl = [TiUtils boolValue:ssl];
    config.debugLogging = YES;//[TiUtils boolValue:debugLogging];
    
    _mediaHeartbeat = [[ADBMediaHeartbeat alloc] initWithDelegate:self config:config];
}


#pragma mark ADBMediaHeartbeatDelegate

-(ADBMediaObject *)getQoSObject {
    return nil;
}

-(NSTimeInterval)getCurrentPlaybackTime {
    NSNumber *progress = [self valueForUndefinedKey:@"videoProgress"];
    [self log:[NSString stringWithFormat:@"progress: %f", [progress doubleValue]]];
    return [progress doubleValue];
}


#pragma mark Private methods

-(void)log:(NSString *)text {
    NSLog(@"%@ %@", self, text);
}


#pragma mark Public API

-(void)trackSessionStart:(id)args {
    [self log:@"Inside trackSessionStart"];
    ENSURE_SINGLE_ARG(args, NSMutableDictionary)
    
    id basic = [args objectForKey:@"basic"];
    id metadata = [args objectForKey:@"metadata"];
    id custom = [args objectForKey:@"custom"];
    
    ENSURE_DICT(basic)
    ENSURE_DICT(metadata)
    ENSURE_TYPE_OR_NIL(custom, NSDictionary)
    
    id name = [basic objectForKey:@"name"];
    id mediaId = [basic objectForKey:@"mediaId"];
    id length = [basic objectForKey:@"length"];
    
    ENSURE_TYPE(name, NSString)
    ENSURE_TYPE(mediaId, NSString)
    
    ADBMediaObject *mediaObject = [ADBMediaHeartbeat
                                   createMediaObjectWithName: name
                                   mediaId: mediaId
                                   length: [length doubleValue]
                                   streamType:ADBMediaHeartbeatStreamTypeVOD];
    
    
    [mediaObject setValue:metadata forKey:ADBMediaObjectKeyStandardVideoMetadata];
    [_mediaHeartbeat trackSessionStart:mediaObject data:custom];
    
    [self log:@"Finished calling trackSessionStart"];
}

-(void)trackSessionEnd:(id)args {
    [self log:@"Inside trackSessionEnd"];
    [_mediaHeartbeat trackSessionEnd];
}

-(void)onPlay:(id)args {
    [self log:@"Inside onPlay"];
    NSLog(@"_mediaHeartbeat: %@", _mediaHeartbeat);
    [_mediaHeartbeat trackPlay];
    
    [self log:@"Finished calling onPlay"];
}

-(void)onStop:(id)args {
    [self log:@"Inside onStop"];
    [_mediaHeartbeat trackPause];
}

-(void)onSeekStart:(id)args {
    [self log:@"Inside onSeekStart"];
    [_mediaHeartbeat trackEvent:ADBMediaHeartbeatEventSeekStart mediaObject:nil data:nil];
}

-(void)onSeekComplete:(id)args {
    [self log:@"Inside onSeekComplete"];
    [_mediaHeartbeat trackEvent:ADBMediaHeartbeatEventSeekComplete mediaObject:nil data:nil];
}

-(void)onComplete:(id)args {
    [self log:@"Inside onComplete"];
    [_mediaHeartbeat trackComplete];
}


-(void)onAdBreakStart:(id)args {
    [self log:@"Inside onAdBreakStart"];
    ENSURE_SINGLE_ARG(args, NSDictionary)
    
    id type = [args objectForKey:@"name"]; // e.g. "preroll", "midroll", "postroll"
    id position = [args objectForKey:@"position"];
    id startTime = [args objectForKey:@"startTime"];
    
    ENSURE_TYPE(type, NSString)
    ENSURE_TYPE(position, NSNumber)
    ENSURE_TYPE(startTime, NSNumber)
    
    id adBreakObject = [ADBMediaHeartbeat createAdBreakObjectWithName:type
                                                             position:[position doubleValue]
                                                            startTime:[startTime doubleValue]];
    
    [_mediaHeartbeat trackEvent:ADBMediaHeartbeatEventAdBreakStart mediaObject:adBreakObject data:nil];
    
}


-(void)onAdBreakEnd:(id)args {
    [self log:@"Inside onAdBreakEnd"];
    [_mediaHeartbeat trackEvent:ADBMediaHeartbeatEventAdBreakComplete mediaObject:nil data:nil];
}

-(void)onAdStart:(id)args {
    [self log:@"Inside onAdStart"];
    
    ENSURE_SINGLE_ARG(args, NSDictionary)
    id name = [args objectForKey:@"name"];
    id adId = [args objectForKey:@"adId"];
    id position = [args objectForKey:@"position"];
    id length = [args objectForKey:@"length"];
    
    id metadata = [args objectForKey:@"metadata"];
    
    ENSURE_TYPE(name, NSString)
    ENSURE_TYPE(adId, NSString)
    ENSURE_TYPE(position, NSNumber)
    ENSURE_TYPE(length, NSNumber)
    ENSURE_TYPE_OR_NIL(metadata, NSDictionary)
    
    
    id adObject = [ADBMediaHeartbeat createAdObjectWithName:name
                                                       adId:adId
                                                   position:[position doubleValue]
                                                     length:[length doubleValue]];
    
    if (metadata != nil) {
        [adObject setValue:metadata forKey:ADBMediaObjectKeyStandardAdMetadata];
    }
    
    [_mediaHeartbeat trackEvent:ADBMediaHeartbeatEventAdStart mediaObject:adObject data:nil];
}

-(void)onAdComplete:(id)args {
    [self log:@"Inside onAdComplete"];
    [_mediaHeartbeat trackEvent:ADBMediaHeartbeatEventAdComplete mediaObject:nil data:nil];
}

-(void)onError:(id)args {
    [self log:@"Inside onError"];
    ENSURE_SINGLE_ARG(args, NSString)
    
    [_mediaHeartbeat trackError:args];
}


- (void)onBufferStart:(id)args {
    [_mediaHeartbeat trackEvent:ADBMediaHeartbeatEventBufferStart
                    mediaObject:nil
                           data:nil];
}


- (void)onBufferComplete:(id)args {
    [_mediaHeartbeat trackEvent:ADBMediaHeartbeatEventBufferComplete
                    mediaObject:nil
                           data:nil];
}
    

@end

