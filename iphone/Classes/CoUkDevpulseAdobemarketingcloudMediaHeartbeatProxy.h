//
//  CoUkDevpulseAdobemarketingcloudMediaHeartbeatProxy.h
//  AdobeMarketingCloud
//
//  Created by Junaid Younus on 03/05/2017.
//
//

#import "TiProxy.h"
#import "ADBMediaHeartbeat.h"
#import "ADBMediaHeartbeatConfig.h"

@interface CoUkDevpulseAdobemarketingcloudMediaHeartbeatProxy : TiProxy

-(void)trackSessionStart:(id)args;
-(void)trackSessionEnd:(id)args;
-(void)onPlay:(id)args;
-(void)onStop:(id)args;
-(void)onSeekStart:(id)args;
-(void)onSeekComplete:(id)args;
-(void)onComplete:(id)args;
-(void)onAdStart:(id)args;
-(void)onAdComplete:(id)args;

@end
