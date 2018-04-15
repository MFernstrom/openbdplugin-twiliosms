# openbdplugin-twiliosms
OpenBD plugin for sending SMS with Twilio

You also need the "Jar with dependencies" from here http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.twilio.sdk%22%20AND%20a%3A%22twilio%22

Drop both jars into your WEB-INF/lib directory, restart the OpenBD server, and you're good to go.

## Sending SMS

```
<cfscript>
  sid = sendsms(
  account_token = 'your twilio account token',
  auth_token = 'your twilio auth token',
  to='your cellphone number',
  from='your Twilio number',
  body='Test message');
  writedump(sid);
</cfscript>
```

## Why?
I created this as a way to demonstrate how to create plugins for OpenBD and at the same time create something useful.

https://www.linkedin.com/pulse/send-text-messages-openbd-andtwilio-marcus-fernstr%C3%B6m/
