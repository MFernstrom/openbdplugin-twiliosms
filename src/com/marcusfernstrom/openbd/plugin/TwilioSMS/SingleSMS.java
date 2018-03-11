/* 
 *  Copyright (C) 2018, Marcus Fernstrom
 *  
 *  License: GPL V3, full license on GitHub.
 *  
 *  This is the implementation of the sendsms function, used for
 *  sending a single SMS through Twilio. It returns the message SID
 *  or throws a cfml error.
 */

package com.marcusfernstrom.openbd.plugin.TwilioSMS;

import com.naryx.tagfusion.cfm.engine.cfArgStructData;
import com.naryx.tagfusion.cfm.engine.cfData;
import com.naryx.tagfusion.cfm.engine.cfSession;
import com.naryx.tagfusion.cfm.engine.cfStringData;
import com.naryx.tagfusion.cfm.engine.cfmRunTimeException;
import com.naryx.tagfusion.expression.function.functionBase;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SingleSMS extends functionBase {
	private static final long serialVersionUID = 1356978518018351427L;

	public SingleSMS() {
		min = max = 5;
		setNamedParams( new String[]{ "account_token", "auth_token", "to", "from", "body" } );
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public java.util.Map getInfo(){
		return makeInfo(
			"SMS", 
			"Sends a single SMS through Twilio and returns the message SID",
			ReturnType.STRING );
	}
	
	@Override
	public cfData execute( cfSession _session, cfArgStructData argStruct ) throws cfmRunTimeException {
		try {
			String account_token 	= getNamedStringParam( argStruct, "account_token" , "" );
			String auth_token 		= getNamedStringParam( argStruct, "auth_token" , "" );
			String to 				= getNamedStringParam( argStruct, "to" , "" );
			String from 				= getNamedStringParam( argStruct, "from" , "" );
			String body 				= getNamedStringParam( argStruct, "body" , "" );
			
			Twilio.init(account_token, auth_token);
	
		    Message message = Message.creator(
		    		new PhoneNumber(to),
		        new PhoneNumber(from),
		        body).create();

		    return new cfStringData( message.getSid() );
			
		} catch( Exception E ) {
			throwException( _session, E.getMessage() );
			
			return null;
		}
	}

}