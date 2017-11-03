package co.uk.devpulse.adobemarketingcloud;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import android.app.Activity;
import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;

import com.adobe.primetime.va.simple.*;


@Kroll.proxy(creatableInModule=AdobeMarketingCloudModule.class)
public class AdobeMarketingCloudEnumHelperProxy extends KrollProxy
{
	@Kroll.constant public static final String SHOW = MediaHeartbeat.VideoMetadataKeys.SHOW;
    @Kroll.constant public static final String SERIES = MediaHeartbeat.VideoMetadataKeys.SEASON;
    @Kroll.constant public static final String EPISODE = MediaHeartbeat.VideoMetadataKeys.EPISODE;
    @Kroll.constant public static final String ASSET_ID = MediaHeartbeat.VideoMetadataKeys.ASSET_ID;
    @Kroll.constant public static final String GENRE = MediaHeartbeat.VideoMetadataKeys.GENRE;
    @Kroll.constant public static final String NETWORK = MediaHeartbeat.VideoMetadataKeys.NETWORK;
}
