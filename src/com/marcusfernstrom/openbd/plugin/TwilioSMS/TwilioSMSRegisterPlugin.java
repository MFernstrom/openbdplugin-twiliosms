package com.marcusfernstrom.openbd.plugin.TwilioSMS;

import com.bluedragon.plugin.Plugin;
import com.bluedragon.plugin.PluginManagerInterface;
import com.naryx.tagfusion.xmlConfig.xmlCFML;

public class TwilioSMSRegisterPlugin implements Plugin {

	public String getPluginDescription() {
		return "Twilio SMS functionality";
	}

	public String getPluginName() {
		return "TwilioSMS";
	}

	public String getPluginVersion() {
		return "1.0";
	}

	public void pluginStart(PluginManagerInterface manager, xmlCFML systemParameters) {
		System.out.println("Registering Twilio SMS functions");
		manager.registerFunction( "sendsms", "com.marcusfernstrom.openbd.plugin.TwilioSMS.SingleSMS" );
		manager.registerFunction( "sendbulksms", "com.marcusfernstrom.openbd.plugin.TwilioSMS.BulkSMS" );
	}

	public void pluginStop(PluginManagerInterface manager) {}
}