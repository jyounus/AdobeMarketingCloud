//
//  VideoAnalyticsProvider.m
//  AdobeMarketingCloud
//
//  Created by Junaid Younus on 03/05/2017.
//
//

#import "VideoAnalyticsProvider.h"

@implementation VideoAnalyticsProvider
-(ADBMediaObject *)getQoSObject {
    return nil;
}

-(NSTimeInterval)getCurrentPlaybackTime {
    id playbackTime = [[self callback] call:@[] thisObject:self];
    return [playbackTime doubleValue];
}

@end
