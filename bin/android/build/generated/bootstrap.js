/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 * Warning: This file is GENERATED, and should not be modified
 */
var bootstrap = kroll.NativeModule.require("bootstrap"),
	invoker = kroll.NativeModule.require("invoker"),
	Titanium = kroll.binding("Titanium").Titanium;

function moduleBootstrap(moduleBinding) {
	function lazyGet(object, binding, name, namespace) {
		return bootstrap.lazyGet(object, binding,
			name, namespace, moduleBinding.getBinding);
	}

	var module = moduleBinding.getBinding("co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudModule")["AdobeMarketingCloud"];
	var invocationAPIs = module.invocationAPIs = [];
	module.apiName = "AdobeMarketingCloud";

	function addInvocationAPI(module, moduleNamespace, namespace, api) {
		invocationAPIs.push({ namespace: namespace, api: api });
	}

		addInvocationAPI(module, "AdobeMarketingCloud", "AdobeMarketingCloud", "createAdobeMarketingCloudEnumHelper");
	addInvocationAPI(module, "AdobeMarketingCloud", "AdobeMarketingCloud", "createAdobeMarketingCloudMediaHeartbeat");
	addInvocationAPI(module, "AdobeMarketingCloud", "AdobeMarketingCloud", "createAdobeMarketingCloudVideoAnalyticsProvider");
	addInvocationAPI(module, "AdobeMarketingCloud", "AdobeMarketingCloud", "createExample");

			if (!("__propertiesDefined__" in module)) {		
		Object.defineProperties(module, {
			"AdobeMarketingCloudEnumHelper": {
				get: function() {
					var AdobeMarketingCloudEnumHelper = lazyGet(this, "co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudEnumHelperProxy", "AdobeMarketingCloudEnumHelper", "AdobeMarketingCloudEnumHelper");
					return AdobeMarketingCloudEnumHelper;
				},
				configurable: true
			},
			"AdobeMarketingCloudVideoAnalyticsProvider": {
				get: function() {
					var AdobeMarketingCloudVideoAnalyticsProvider = lazyGet(this, "co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudVideoAnalyticsProvider", "AdobeMarketingCloudVideoAnalyticsProvider", "AdobeMarketingCloudVideoAnalyticsProvider");
					return AdobeMarketingCloudVideoAnalyticsProvider;
				},
				configurable: true
			},
			"AdobeMarketingCloudMediaHeartbeat": {
				get: function() {
					var AdobeMarketingCloudMediaHeartbeat = lazyGet(this, "co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudMediaHeartbeatProxy", "AdobeMarketingCloudMediaHeartbeat", "AdobeMarketingCloudMediaHeartbeat");
					return AdobeMarketingCloudMediaHeartbeat;
				},
				configurable: true
			},
			"Example": {
				get: function() {
					var Example = lazyGet(this, "co.uk.devpulse.adobemarketingcloud.ExampleProxy", "Example", "Example");
					return Example;
				},
				configurable: true
			},
		
		});
		module.constructor.prototype.createAdobeMarketingCloudEnumHelper = function() {
			return new module.AdobeMarketingCloudEnumHelper(arguments);
		}
		module.constructor.prototype.createAdobeMarketingCloudMediaHeartbeat = function() {
			return new module.AdobeMarketingCloudMediaHeartbeat(arguments);
		}
		module.constructor.prototype.createAdobeMarketingCloudVideoAnalyticsProvider = function() {
			return new module.AdobeMarketingCloudVideoAnalyticsProvider(arguments);
		}
		module.constructor.prototype.createExample = function() {
			return new module.Example(arguments);
		}
		}
		module.__propertiesDefined__ = true;
		return module;

}
exports.bootstrap = moduleBootstrap;
