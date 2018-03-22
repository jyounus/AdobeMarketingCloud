/**
 * AdobeMarketingCloud
 *
 * Created by Your Name
 * Copyright (c) 2017 Your Company. All rights reserved.
 */

// Documentation: https://marketing.adobe.com/resources/help/en_US/mobile/ios/states.html
// Lib: https://github.com/Adobe-Marketing-Cloud/mobile-services/tree/master/sdks/iOS
// Sample: https://github.com/Adobe-Marketing-Cloud/mobile-services/blob/master/samples/iOS/ADBMobileSamples/ADBMobileSamples/Controllers/SimpleTrackingController.m
// Appc guide to modules: http://docs.appcelerator.com/platform/latest/#!/guide/iOS_Module_Quick_Start

// Heartbeat lib documentation: https://marketing.adobe.com/resources/help/en_US/sc/appmeasurement/hbvideo/ios_2.0/t_vhl_track-core-playback_ios.html
// Heartbeat SDK: https://github.com/Adobe-Marketing-Cloud/video-heartbeat-v2


// A function which is called from Ti MUST have this format: -(void)onPlay:(id)args
// The important part is the :(id)args!!!!!

// When returning something, you MUST return like this: -(id)createMediaHeartbeatObject:(id)args
// Defining something like -(SomeClass *)createMedia... WONT WORK!!!

#import "CoUkDevpulseAdobemarketingcloudModule.h"
#import "TiBase.h"
#import "TiHost.h"
#import "TiUtils.h"
#import "ADBMobile.h"
#import "ADBMediaHeartbeat.h"
#import "ADBMediaHeartbeatConfig.h"
#import "CoUkDevpulseAdobemarketingcloudMediaHeartbeatProxy.h"

@implementation CoUkDevpulseAdobemarketingcloudModule

#pragma mark Internal

// this is generated for your module, please do not change it
-(id)moduleGUID
{
	return @"a90f8cd0-fc67-4521-9cbc-d91fe65d2937";
}

// this is generated for your module, please do not change it
-(NSString*)moduleId
{
	return @"co.uk.devpulse.adobemarketingcloud";
}

#pragma mark Lifecycle

-(void)startup
{
	// this method is called when the module is first loaded
	// you *must* call the superclass
	[super startup];
    
	NSLog(@"[INFO] %@ loaded",self);
}

-(void)shutdown:(id)sender
{
	// this method is called when the module is being unloaded
	// typically this is during shutdown. make sure you don't do too
	// much processing here or the app will be quit forceably

	// you *must* call the superclass
	[super shutdown:sender];
}



#pragma mark Internal Memory Management

-(void)didReceiveMemoryWarning:(NSNotification*)notification
{
	// optionally release any resources that can be dynamically
	// reloaded once memory is available - such as caches
	[super didReceiveMemoryWarning:notification];
}

#pragma mark Listener Notifications

-(void)_listenerAdded:(NSString *)type count:(int)count
{
	if (count == 1 && [type isEqualToString:@"my_event"])
	{
		// the first (of potentially many) listener is being added
		// for event named 'my_event'
	}
}

-(void)_listenerRemoved:(NSString *)type count:(int)count
{
	if (count == 0 && [type isEqualToString:@"my_event"])
	{
		// the last listener called for event named 'my_event' has
		// been removed, we can optionally clean up any resources
		// since no body is listening at this point for that event
	}
}

#pragma Public APIs



-(void)log:(NSString *)text {
    NSLog(@"%@ %@", self, text);
}


-(void)initialise:(id)args {
    ENSURE_SINGLE_ARG_OR_NIL(args, NSDictionary);
    id isDebug = [args objectForKey:@"debugMode"];
    
    // assumes that the config file will always be called "ADBMobileConfig.json"
    NSString *filePath = [[NSBundle mainBundle] pathForResource:@"ADBMobileConfig" ofType:@"json"];
    [ADBMobile overrideConfigPath:filePath];
    
    [self log:[NSString stringWithFormat:@"filePath: %@", filePath]];
    
    if (isDebug) {
        [self log:@"Debug mode enabled. You should see more logs from the Adobe SDK now."];
        [ADBMobile setDebugLogging:YES];
    }
    
    // this function should be called asap during the app start
    [ADBMobile collectLifecycleData];
    
    self.keys = [[EnumHelper alloc] init];
}

-(void)setUserIdentifier:(id)userId {
    ENSURE_SINGLE_ARG_OR_NIL(userId, NSString);
    [ADBMobile setUserIdentifier:userId];
}

-(NSString *)getUserIdentifier {
    return [ADBMobile userIdentifier];
}

-(void)trackState:(id)args {
    ENSURE_SINGLE_ARG(args, NSDictionary);
    
    id name = [args objectForKey:@"name"];
    id data = [args objectForKey:@"data"];
    
    ENSURE_TYPE(name, NSString);
    ENSURE_TYPE_OR_NIL(data, NSDictionary);
    
    NSLog(@"Inside trackState with data: %@", args);
    [ADBMobile trackState:name data:data];
}

-(void)trackAction:(id)args {
    ENSURE_SINGLE_ARG(args, NSDictionary);
    
    id name = [args objectForKey:@"name"];
    id data = [args objectForKey:@"data"];
    
    ENSURE_TYPE(name, NSString);
    ENSURE_TYPE_OR_NIL(data, NSDictionary);
    
    NSLog(@"Inside trackAction with args: %@", args);
    [ADBMobile trackAction:name data:data];
}



@end
