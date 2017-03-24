package com.netcracker.vasily.danilin.server;

import com.netcracker.vasily.danilin.client.GreetingService;
import com.netcracker.vasily.danilin.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.netcracker.vasily.danilin.shared.TableRow;

import java.util.List;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {

  public List<TableRow> greetServer(String input) throws IllegalArgumentException {


    return XMLParser.getData();
  }

  /**
   * Escape an html string. Escaping data received from the client helps to
   * prevent cross-site script vulnerabilities.
   * 
   * @param html the html string to escape
   * @return the escaped string
   */
  private String escapeHtml(String html) {
    if (html == null) {
      return null;
    }
    return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
        ">", "&gt;");
  }
}
