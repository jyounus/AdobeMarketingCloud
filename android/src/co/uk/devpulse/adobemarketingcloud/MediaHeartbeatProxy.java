package co.uk.devpulse.adobemarketingcloud;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import android.app.Activity;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollProxy;

import com.adobe.primetime.va.simple.MediaHeartbeat;
import com.adobe.primetime.va.simple.MediaHeartbeat.MediaHeartbeatDelegate;
import com.adobe.primetime.va.simple.MediaHeartbeatConfig;
import com.adobe.primetime.va.simple.MediaObject;

import org.appcelerator.kroll.*;

import java.util.HashMap;

import org.appcelerator.titanium.util.TiConvert;

@Kroll.proxy(creatableInModule=AdobeMarketingCloudModule.class)
public class MediaHeartbeatProxy extends KrollProxy implements MediaHeartbeatDelegate
{
    private MediaHeartbeat mediaHeartbeat = null;
    private Double videoProgress = 0.0; 
    
    
    private void log(String text) {
        Log.d("AdobeMarketingCloudMediaHeartbeatProxy", text);
    }

    private HashMap<String, Object> toHashMap(Object data) {
        if (data != null) {
            return (HashMap<String, Object>)data;
        }

        return null;
    }

    private HashMap<String, String> toStringHashMap(Object data) {
        if (data != null) {
            return (HashMap<String, String>)data;
        }
                
        return null;
    }

    @Override
    public void handleCreationDict(KrollDict props) {
    	log("createMediaHeartbeat called");
   
    	String trackingServer = TiConvert.toString(props.get("trackingServer"));
	    String channel = TiConvert.toString(props.get("channel"));
	    String appVersion = TiConvert.toString(props.get("appVersion"));
	    String ovp = TiConvert.toString(props.get("ovp"));
	    String playerName = TiConvert.toString(props.get("playerName"));
	    Boolean ssl = TiConvert.toBoolean(props.get("ssl"));
	    Boolean debugLogging = TiConvert.toBoolean(props.get("debugLogging"));

		MediaHeartbeatConfig config = new MediaHeartbeatConfig();
        config.trackingServer = trackingServer;
        config.channel = channel;
        config.appVersion = appVersion;
        config.ovp = ovp;
        config.playerName = playerName;
        config.ssl = ssl;
        config.debugLogging = debugLogging;

        mediaHeartbeat = new MediaHeartbeat(this, config);
        
    }
    
    
    @Kroll.method
    public void trackSessionStart(KrollDict args) {
        log("Inside trackSessionStart");
        HashMap<String, Object> basic = toHashMap(args.get("basic"));
        HashMap<String, String> metadata = toStringHashMap(args.get("metadata"));
        HashMap<String, String> custom = toStringHashMap(args.get("custom"));

        String name = TiConvert.toString(basic.get("name"));
        String mediaId = TiConvert.toString(basic.get("mediaId"));
        Double length = TiConvert.toDouble(basic.get("length"));

        MediaObject mediaInfo = MediaHeartbeat.createMediaObject(name, mediaId, length, MediaHeartbeat.StreamType.VOD);
        mediaInfo.setValue(MediaHeartbeat.MediaObjectKey.StandardVideoMetadata, metadata);
        mediaHeartbeat.trackSessionStart(mediaInfo, custom);
    }

    @Kroll.method
    public void trackSessionEnd() {
        log("Inside trackSessionEnd");
        mediaHeartbeat.trackSessionEnd();
        videoProgress = 0.0;
    }

    @Kroll.method
    public void onPlay() {
        log("Inside onPlay");
        mediaHeartbeat.trackPlay();
    }

    @Kroll.method
    public void onStop() {
        log("Inside onStop");
        mediaHeartbeat.trackPause();
    }

    @Kroll.method
    public void onSeekStart() {
        log("Inside onSeekStart");
        mediaHeartbeat.trackEvent(MediaHeartbeat.Event.SeekStart, null, null);
    }

    @Kroll.method
    public void onSeekComplete() {
        log("Inside onSeekComplete");
        mediaHeartbeat.trackEvent(MediaHeartbeat.Event.SeekComplete, null, null);
    }

    @Kroll.method
    public void onComplete() {
        log("Inside onComplete");
        mediaHeartbeat.trackComplete();
    }
    
    @Kroll.method
    public void onAdBreakStart(KrollDict args) {
        log("Inside onAdBreakStart");

        String name = TiConvert.toString(args.get("name"));	//ad type (e.g. "preroll", "midroll", etc.)
        Double startTime = TiConvert.toDouble(args.get("startTime"));
        Double position = TiConvert.toDouble(args.get("position"));

        MediaObject adBreakObject = MediaHeartbeat.createAdBreakObject(name, position.longValue(), startTime);
        
        mediaHeartbeat.trackEvent(MediaHeartbeat.Event.AdBreakStart, adBreakObject, null);
    }

    

    @Kroll.method
    public void onAdStart(KrollDict args) {
        log("Inside onAdStart");
        HashMap<String, String> metadata = toStringHashMap(args.get("metadata"));

        String name = TiConvert.toString(args.get("name")); 
        String adId = TiConvert.toString(args.get("adId"));
        Double length = TiConvert.toDouble(args.get("length"));
        Double position = TiConvert.toDouble(args.get("position"));

        MediaObject adInfo = MediaHeartbeat.createAdObject(name, adId, position.longValue(), length);
        adInfo.setValue(MediaHeartbeat.MediaObjectKey.StandardAdMetadata, metadata);
        mediaHeartbeat.trackEvent(MediaHeartbeat.Event.AdStart, adInfo, null);
    }

    
    @Kroll.method
    public void onAdComplete() {
        log("Inside onAdComplete");
        mediaHeartbeat.trackEvent(MediaHeartbeat.Event.AdComplete, null, null);
    }
    
    
    @Kroll.method
    public void onAdBreakComplete() {
        log("Inside onAdBreakComplete");
        mediaHeartbeat.trackEvent(MediaHeartbeat.Event.AdBreakComplete, null, null);
    }

    @Kroll.method
    public void onError(String args) {
        log("Inside onError");
        mediaHeartbeat.trackError(args);
    }
    
    @Kroll.method
    @Kroll.setProperty
    public void setVideoProgress(Double progress) {
    	videoProgress = (Double)progress;
    }
    
    
    //******* MediaHeartbeatDelegate ****
    
    @Override
    public MediaObject getQoSObject() {
        return null;
    }

    @Override
    public Double getCurrentPlaybackTime() {
    	
    	log(String.format("getCurrentPlaybackTime: %f", videoProgress));
    	
        return videoProgress;
    }
    
}
