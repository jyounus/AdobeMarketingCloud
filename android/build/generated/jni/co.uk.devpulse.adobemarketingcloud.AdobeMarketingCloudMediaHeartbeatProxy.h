/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2016 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

/** This is generated, do not edit by hand. **/

#include <jni.h>

#include "Proxy.h"

namespace co {
namespace uk {
namespace devpulse {
namespace adobemarketingcloud {
	namespace adobemarketingcloud {

class AdobeMarketingCloudMediaHeartbeatProxy : public titanium::Proxy
{
public:
	explicit AdobeMarketingCloudMediaHeartbeatProxy(jobject javaObject);

	static void bindProxy(v8::Local<v8::Object>, v8::Local<v8::Context>);
	static v8::Local<v8::FunctionTemplate> getProxyTemplate(v8::Isolate*);
	static void dispose(v8::Isolate*);

	static jclass javaClass;

private:
	static v8::Persistent<v8::FunctionTemplate> proxyTemplate;

	// Methods -----------------------------------------------------------
	static void trackSessionStart(const v8::FunctionCallbackInfo<v8::Value>&);
	static void onError(const v8::FunctionCallbackInfo<v8::Value>&);
	static void onComplete(const v8::FunctionCallbackInfo<v8::Value>&);
	static void onAdComplete(const v8::FunctionCallbackInfo<v8::Value>&);
	static void onSeekStart(const v8::FunctionCallbackInfo<v8::Value>&);
	static void onPlay(const v8::FunctionCallbackInfo<v8::Value>&);
	static void onSeekComplete(const v8::FunctionCallbackInfo<v8::Value>&);
	static void trackSessionEnd(const v8::FunctionCallbackInfo<v8::Value>&);
	static void onStop(const v8::FunctionCallbackInfo<v8::Value>&);
	static void onAdStart(const v8::FunctionCallbackInfo<v8::Value>&);

	// Dynamic property accessors ----------------------------------------

};

	} // namespace adobemarketingcloud
} // adobemarketingcloud
} // devpulse
} // uk
} // co
