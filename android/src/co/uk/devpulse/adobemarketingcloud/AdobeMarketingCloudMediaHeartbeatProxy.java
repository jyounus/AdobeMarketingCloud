package co.uk.devpulse.adobemarketingcloud;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import android.app.Activity;
import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;

import com.adobe.primetime.va.simple.MediaHeartbeat;
import com.adobe.primetime.va.simple.MediaHeartbeat.MediaHeartbeatDelegate;
import com.adobe.primetime.va.simple.MediaHeartbeatConfig;
import com.adobe.primetime.va.simple.MediaObject;
import org.appcelerator.kroll.*;
import java.util.HashMap;
import org.appcelerator.titanium.util.TiConvert;

@Kroll.proxy(creatableInModule=AdobeMarketingCloudModule.class)
public class AdobeMarketingCloudMediaHeartbeatProxy extends KrollProxy
{
    public MediaHeartbeat mediaHeartbeat = null;

    private void log(String text) {
        Log.d("AdobeMarketingCloudModule", text);
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
        mediaHeartbeat.trackSessionStart(mediaInfo, metadata); // TODO: we're not doing anything with the 'custom' HashMap, is this correct?
    }

    @Kroll.method
    public void trackSessionEnd() { // had to remove the KrollDict args param, UNLIKE on iOS!!! if you keep the args, you MUST make sure on Ti you pass an object as well.
        log("Inside trackSessionEnd");
        mediaHeartbeat.trackSessionEnd();
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
    public void onAdStart(KrollDict args) {
        log("Inside onAdStart");
        HashMap<String, Object> basic = toHashMap(args.get("basic"));
        HashMap<String, String> metadata = toStringHashMap(args.get("metadata"));
        HashMap<String, String> custom = toStringHashMap(args.get("custom"));

        String name = TiConvert.toString(basic.get("name"));
        String adId = TiConvert.toString(basic.get("id"));
        Double time = TiConvert.toDouble(basic.get("time"));
        Double position = TiConvert.toDouble(basic.get("position"));

        MediaObject adBreakObject = MediaHeartbeat.createAdBreakObject(name, position.longValue(), time);
        MediaObject adInfo = MediaHeartbeat.createAdObject(name, adId, position.longValue(), time);

        mediaHeartbeat.trackEvent(MediaHeartbeat.Event.AdBreakStart, adBreakObject, null);
        mediaHeartbeat.trackEvent(MediaHeartbeat.Event.AdStart, adInfo, metadata); // TODO: again not using 'custom' HashMap, is this correct?
    }

    @Kroll.method
    public void onAdComplete() {
        log("Inside onAdComplete");
        mediaHeartbeat.trackEvent(MediaHeartbeat.Event.AdComplete, null, null);
        mediaHeartbeat.trackEvent(MediaHeartbeat.Event.AdBreakComplete, null, null);
    }

    @Kroll.method
    public void onError(String args) {
        log("Inside onError");
        mediaHeartbeat.trackError(args);
    }
}
