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
public class AdobeMarketingCloudVideoAnalyticsProvider extends KrollProxy implements MediaHeartbeatDelegate
{
    public KrollFunction playbackCallback = null;

    @Override
    public MediaObject getQoSObject() {
        return null;
    }

    @Override
    public Double getCurrentPlaybackTime() {
        Object playbackTime = playbackCallback.call(getKrollObject(), new HashMap());
        return TiConvert.toDouble(playbackTime);
    }
}
