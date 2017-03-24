package com.netcracker.vasily.danilin.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.netcracker.vasily.danilin.shared.TableRow;

import java.util.List;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {


    void greetServer(String name, AsyncCallback<List<TableRow>> async);
}
