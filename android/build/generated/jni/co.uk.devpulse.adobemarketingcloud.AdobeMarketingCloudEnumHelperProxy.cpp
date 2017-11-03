/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2016 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

/** This code is generated, do not edit by hand. **/

#include "co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudEnumHelperProxy.h"

#include "AndroidUtil.h"
#include "EventEmitter.h"
#include "JNIUtil.h"
#include "JSException.h"
#include "Proxy.h"
#include "ProxyFactory.h"
#include "TypeConverter.h"
#include "V8Util.h"


#include "org.appcelerator.kroll.KrollProxy.h"

#define TAG "AdobeMarketingCloudEnumHelperProxy"

using namespace v8;

namespace co {
namespace uk {
namespace devpulse {
namespace adobemarketingcloud {
	namespace adobemarketingcloud {


Persistent<FunctionTemplate> AdobeMarketingCloudEnumHelperProxy::proxyTemplate;
jclass AdobeMarketingCloudEnumHelperProxy::javaClass = NULL;

AdobeMarketingCloudEnumHelperProxy::AdobeMarketingCloudEnumHelperProxy(jobject javaObject) : titanium::Proxy(javaObject)
{
}

void AdobeMarketingCloudEnumHelperProxy::bindProxy(Local<Object> exports, Local<Context> context)
{
	Isolate* isolate = context->GetIsolate();

	Local<FunctionTemplate> pt = getProxyTemplate(isolate);
	Local<Function> proxyConstructor = pt->GetFunction(context).ToLocalChecked();
	Local<String> nameSymbol = NEW_SYMBOL(isolate, "AdobeMarketingCloudEnumHelper"); // use symbol over string for efficiency
	exports->Set(nameSymbol, proxyConstructor);
}

void AdobeMarketingCloudEnumHelperProxy::dispose(Isolate* isolate)
{
	LOGD(TAG, "dispose()");
	if (!proxyTemplate.IsEmpty()) {
		proxyTemplate.Reset();
	}

	titanium::KrollProxy::dispose(isolate);
}

Local<FunctionTemplate> AdobeMarketingCloudEnumHelperProxy::getProxyTemplate(Isolate* isolate)
{
	if (!proxyTemplate.IsEmpty()) {
		return proxyTemplate.Get(isolate);
	}

	LOGD(TAG, "GetProxyTemplate");

	javaClass = titanium::JNIUtil::findClass("co/uk/devpulse/adobemarketingcloud/AdobeMarketingCloudEnumHelperProxy");
	EscapableHandleScope scope(isolate);

	// use symbol over string for efficiency
	Local<String> nameSymbol = NEW_SYMBOL(isolate, "AdobeMarketingCloudEnumHelper");

	Local<FunctionTemplate> t = titanium::Proxy::inheritProxyTemplate(isolate,
		titanium::KrollProxy::getProxyTemplate(isolate)
, javaClass, nameSymbol);

	proxyTemplate.Reset(isolate, t);
	t->Set(titanium::Proxy::inheritSymbol.Get(isolate),
		FunctionTemplate::New(isolate, titanium::Proxy::inherit<AdobeMarketingCloudEnumHelperProxy>)->GetFunction());

	titanium::ProxyFactory::registerProxyPair(javaClass, *t);

	// Method bindings --------------------------------------------------------

	Local<ObjectTemplate> prototypeTemplate = t->PrototypeTemplate();
	Local<ObjectTemplate> instanceTemplate = t->InstanceTemplate();

	// Delegate indexed property get and set to the Java proxy.
	instanceTemplate->SetIndexedPropertyHandler(titanium::Proxy::getIndexedProperty,
		titanium::Proxy::setIndexedProperty);

	// Constants --------------------------------------------------------------
	JNIEnv *env = titanium::JNIScope::getEnv();
	if (!env) {
		LOGE(TAG, "Failed to get environment in AdobeMarketingCloudEnumHelperProxy");
		//return;
	}


		DEFINE_STRING_CONSTANT(isolate, prototypeTemplate, "NETWORK", "a.media.network");

		DEFINE_STRING_CONSTANT(isolate, prototypeTemplate, "SERIES", "a.media.season");

		DEFINE_STRING_CONSTANT(isolate, prototypeTemplate, "EPISODE", "a.media.episode");

		DEFINE_STRING_CONSTANT(isolate, prototypeTemplate, "GENRE", "a.media.genre");

		DEFINE_STRING_CONSTANT(isolate, prototypeTemplate, "SHOW", "a.media.show");

		DEFINE_STRING_CONSTANT(isolate, prototypeTemplate, "ASSET_ID", "a.media.asset");


	// Dynamic properties -----------------------------------------------------

	// Accessors --------------------------------------------------------------

	return scope.Escape(t);
}

// Methods --------------------------------------------------------------------

// Dynamic property accessors -------------------------------------------------


	} // namespace adobemarketingcloud
} // adobemarketingcloud
} // devpulse
} // uk
} // co
