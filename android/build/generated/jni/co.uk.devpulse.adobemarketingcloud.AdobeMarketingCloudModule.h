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

class AdobeMarketingCloudModule : public titanium::Proxy
{
public:
	explicit AdobeMarketingCloudModule(jobject javaObject);

	static void bindProxy(v8::Local<v8::Object>, v8::Local<v8::Context>);
	static v8::Local<v8::FunctionTemplate> getProxyTemplate(v8::Isolate*);
	static void dispose(v8::Isolate*);

	static jclass javaClass;

private:
	static v8::Persistent<v8::FunctionTemplate> proxyTemplate;

	// Methods -----------------------------------------------------------
	static void createMediaHeartbeatObject(const v8::FunctionCallbackInfo<v8::Value>&);
	static void getKeys(const v8::FunctionCallbackInfo<v8::Value>&);
	static void initialise(const v8::FunctionCallbackInfo<v8::Value>&);
	static void trackAction(const v8::FunctionCallbackInfo<v8::Value>&);
	static void trackState(const v8::FunctionCallbackInfo<v8::Value>&);

	// Dynamic property accessors ----------------------------------------
	static void getter_keys(v8::Local<v8::Name> name, const v8::PropertyCallbackInfo<v8::Value>& info);

};

} // adobemarketingcloud
} // devpulse
} // uk
} // co
