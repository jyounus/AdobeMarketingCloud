//
//  CoUkDevpulseAdobemarketingcloudMediaHeartbeatProxy.m
//  AdobeMarketingCloud
//
//  Created by Junaid Younus on 03/05/2017.
//
//

#import "CoUkDevpulseAdobemarketingcloudMediaHeartbeatProxy.h"

@implementation CoUkDevpulseAdobemarketingcloudMediaHeartbeatProxy

-(void)log:(NSString *)text {
    NSLog(@"%@ %@", self, text);
}

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

-(void)onAdStart:(id)args {
    [self log:@"Inside onAdStart"];
    
    ENSURE_SINGLE_ARG(args, NSMutableDictionary)
    
    id basic = [args objectForKey:@"basic"];
    id metadata = [args objectForKey:@"metadata"];
    id custom = [args objectForKey:@"custom"];
    
    ENSURE_DICT(basic)
    ENSURE_TYPE_OR_NIL(metadata, NSDictionary)
    ENSURE_TYPE_OR_NIL(custom, NSDictionary)
    
    id name = [basic objectForKey:@"name"];
    id adId = [basic objectForKey:@"id"];
    id position = [basic objectForKey:@"position"];
    id time = [basic objectForKey:@"time"];
    
    ENSURE_TYPE(name, NSString)
    ENSURE_TYPE(adId, NSString)
    
    id adBreakObject = [ADBMediaHeartbeat createAdBreakObjectWithName:name
                                                             position:[position doubleValue]
                                                            startTime:[time doubleValue]];
    
    id adObject = [ADBMediaHeartbeat createAdObjectWithName:name
                                                       adId:adId
                                                   position:[position doubleValue]
                                                     length:[time doubleValue]];
    
    if (metadata != nil) {
        [adObject setValue:metadata forKey:ADBMediaObjectKeyStandardAdMetadata];
    }
    
    [_mediaHeartbeat trackEvent:ADBMediaHeartbeatEventAdBreakStart mediaObject:adBreakObject data:nil];
    [_mediaHeartbeat trackEvent:ADBMediaHeartbeatEventAdStart mediaObject:adObject data:custom];
}

-(void)onAdComplete:(id)args {
    [self log:@"Inside onAdComplete"];
    [_mediaHeartbeat trackEvent:ADBMediaHeartbeatEventAdComplete mediaObject:nil data:nil];
    [_mediaHeartbeat trackEvent:ADBMediaHeartbeatEventAdBreakComplete mediaObject:nil data:nil];
}

-(void)onError:(id)args {
    [self log:@"Inside onError"];
    ENSURE_SINGLE_ARG(args, NSString)
    
    [_mediaHeartbeat trackError:args];
}

@end
