//
//  VideoAnalyticsProvider.h
//  AdobeMarketingCloud
//
//  Created by Junaid Younus on 03/05/2017.
//
//

#import "TiProxy.h"
#import "ADBMediaHeartbeat.h"
#import "ADBMediaHeartbeatConfig.h"

@interface VideoAnalyticsProvider : NSObject <ADBMediaHeartbeatDelegate>
@property (nonatomic, assign) KrollCallback *callback;
@end
