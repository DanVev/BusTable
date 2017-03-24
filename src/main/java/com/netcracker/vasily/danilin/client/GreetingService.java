package com.netcracker.vasily.danilin.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.netcracker.vasily.danilin.shared.TableRow;

import java.util.List;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
    List<TableRow> greetServer(String name) throws IllegalArgumentException;
}
