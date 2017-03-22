package com.netcracker.vasily.danilin.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {


    void greetServer(String name, AsyncCallback<List<List<String>>> async);
}
