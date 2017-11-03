$.win.open();


// http://docs.appcelerator.com/platform/latest/#!/guide/iOS_Module_Quick_Start
// 1. Created a new module project in the CLI: appc new --name AdobeMarketingCloud --id co.uk.devpulse.adobemarketingcloud
// 2. In the CLI: ti build -p ios --build-only
// 3. Step 2 should fail, enter the path to the /iphone/ folder for the module project. It should now build and create the module as a .zip file.

// 4. Download and add third party lib files into the /iphone/platform/ folder



// http://docs.appcelerator.com/platform/latest/#!/guide/Android_Module_Quick_Start
// Android (wasted a lot of time to get it setup and building the sample project, but this is what worked for me in the end):
// java version "1.8.0_91"
// node version : v4.4.7
// Apache Ant(TM) version 1.9.4
// android ndk : android-ndk-r10e
// then in terminal, use the "ant" command to simply build the module to the dist/ folder.


var AMC = require("co.uk.devpulse.adobemarketingcloud");


/*AMC.initialise({
    debugMode: true
});*/

AMC.trackAction({
    name: "Test action has taken place"
});

AMC.trackAction({
    name: "Test action has taken place",
    data: {
        test1: "test property 1"
    }});

AMC.trackState({
    name: "State name"
});

AMC.trackState({
    name: "State name",
    data: {
        test1: "test property 1"
    }
});

/*
var mediaHeartbeat = AMC.createMediaHeartbeatObject({
    trackingServer: "uktvltd.hb.omtrdc.net",
    channel: "TAL",
    appVersion: "heartbeat 2.0.1",
    ovp: "unknown",
    playerName: "UKTV TAL player",
    ssl: false,
    debugLogging: true,
    playbackTimeCallback: getPlaybackTime
});

function getPlaybackTime() {
    Ti.API.info("Inside getPlaybackTime()");

    return 15.0;
}

setTimeout(function() {
    Ti.API.info("Calling .onPlay");
    mediaHeartbeat.onPlay();
    Ti.API.info("Done calling .onPlay");

}, 2000);*/
