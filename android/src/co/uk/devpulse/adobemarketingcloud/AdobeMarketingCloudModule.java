/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
 // Adobe Analytics Docs: https://marketing.adobe.com/resources/help/en_US/mobile/android/methods.html
 // Adobe Heartbeat Docs: https://marketing.adobe.com/resources/help/en_US/sc/appmeasurement/hbvideo/android_2.0/t_vhl_set-up-vid-track-feat_android.html

 // If you get an "titanium ProxyFactory: Failed to find class for x" log when running the app/module, delete your build folder and try again. Also make sure,
 // all your classes which Ti can access have the prefix "AdobeMarketingCloud"!
package co.uk.devpulse.adobemarketingcloud;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import com.adobe.mobile.*;
import android.app.Activity;
import org.appcelerator.kroll.KrollDict;
import java.util.HashMap;
import com.adobe.primetime.va.simple.*;
import org.appcelerator.titanium.util.TiConvert;
import java.io.InputStream;
import java.io.IOException;
import org.appcelerator.kroll.*;


@Kroll.module(name="AdobeMarketingCloud", id="co.uk.devpulse.adobemarketingcloud")
public class AdobeMarketingCloudModule extends KrollModule
{
	// Standard Debugging variables
	private static final String LCAT = "AdobeMarketingCloudModule";
	private static final boolean DBG = TiConfig.LOGD;

	// for some reason, this line of code doesn't seem to work in Ti. keys == undefined.
	// using the getKeys() method below instead as a workaround on Android
	//@Kroll.constant public static final AdobeMarketingCloudEnumHelperProxy keys = new AdobeMarketingCloudEnumHelperProxy();

	@Kroll.getProperty @Kroll.method
	public AdobeMarketingCloudEnumHelperProxy getKeys() {
		return new AdobeMarketingCloudEnumHelperProxy();
	}

	public AdobeMarketingCloudModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(LCAT, "inside onAppCreate");
	}

	// Methods
	@Kroll.method
	public void initialise(KrollDict args) {
		TiApplication appContext = TiApplication.getInstance();
		Activity activity = appContext.getCurrentActivity();

		Boolean isDebug = TiConvert.toBoolean(args.get("debugMode"));
		Config.setContext(activity.getApplicationContext()); // changed from this.getApp... to activity.getApp...

		try {
		    InputStream configInput = activity.getAssets().open("ADBMobileConfig.json");
		    Config.overrideConfigStream(configInput);

		} catch (IOException ex) {
		    Log.e(LCAT, "Unable to find config file");
		}

		if (isDebug) {
			Log.d(LCAT, "Debug mode enabled. You should see more logs from the Adobe SDK now.");
			Config.setDebugLogging(true);
		}

		Config.collectLifecycleData(activity);

		Log.d(LCAT, "Should have initialised everything now.");
	}

	@Override
	public void onResume(Activity activity) {
		super.onResume(activity);
		Log.d(LCAT, "inside onResume");

		Config.collectLifecycleData(activity);
	}

	@Override
	public void onPause(Activity activity) {
		super.onPause(activity);
		Log.d(LCAT, "inside onPause");

		Config.pauseCollectingLifecycleData();
	}

	@Kroll.method
	public void trackState(KrollDict args) {
		Log.d(LCAT, "trackState called");

		String name = TiConvert.toString(args.get("name"));
		Object data = args.get("data");
		HashMap<String, Object> dataDict = null;

		if (data != null) {
			dataDict = (HashMap<String, Object>)data;
		}

		Log.d(LCAT, "Inside trackState with data: " + args);
		Analytics.trackState(name, dataDict);
	}

	@Kroll.method
	public void trackAction(KrollDict args) {
		Log.d(LCAT, "trackAction called");

		String name = TiConvert.toString(args.get("name"));
		Object data = args.get("data");
		HashMap<String, Object> dataDict = null;

		if (data != null) {
			dataDict = (HashMap<String, Object>)data;
		}

		Log.d(LCAT, "Inside trackAction with data: " + args);
		Analytics.trackAction(name, dataDict);
	}

	@Kroll.method
	public AdobeMarketingCloudMediaHeartbeatProxy createMediaHeartbeatObject(KrollDict args) {
		Log.d(LCAT, "createMediaHeartbeatObject called");

		String trackingServer = TiConvert.toString(args.get("trackingServer"));
	    String channel = TiConvert.toString(args.get("channel"));
	    String appVersion = TiConvert.toString(args.get("appVersion"));
	    String ovp = TiConvert.toString(args.get("ovp"));
	    String playerName = TiConvert.toString(args.get("playerName"));
	    Boolean ssl = TiConvert.toBoolean(args.get("ssl"));
	    Boolean debugLogging = TiConvert.toBoolean(args.get("debugLogging"));
	    KrollFunction playbackTimeCallback = (KrollFunction)args.get("playbackTimeCallback");

		MediaHeartbeatConfig config = new MediaHeartbeatConfig();
        config.trackingServer = trackingServer;
        config.channel = channel;
        config.appVersion = appVersion;
        config.ovp = ovp;
        config.playerName = playerName;
        config.ssl = ssl;
        config.debugLogging = debugLogging;

		AdobeMarketingCloudVideoAnalyticsProvider videoAnalytics = new AdobeMarketingCloudVideoAnalyticsProvider();
		videoAnalytics.playbackCallback = playbackTimeCallback;

        MediaHeartbeat heartbeat = new MediaHeartbeat(videoAnalytics, config);

		AdobeMarketingCloudMediaHeartbeatProxy proxy = new AdobeMarketingCloudMediaHeartbeatProxy();
		proxy.mediaHeartbeat = heartbeat;

		return proxy;
	}
}
