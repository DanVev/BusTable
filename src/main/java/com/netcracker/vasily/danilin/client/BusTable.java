package com.netcracker.vasily.danilin.client;

import com.google.gwt.user.client.ui.*;
import com.netcracker.vasily.danilin.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BusTable implements EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final HorizontalPanel topPanel = new HorizontalPanel();
        RootPanel.get("topContainer").add(topPanel);

        final VerticalPanel buttonPanel = new VerticalPanel();
        buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        topPanel.add(buttonPanel);

        final Button adminButton = new Button("Admin Mode");
        buttonPanel.add(adminButton);
        //TODO: Add Sort and Filter Components

        //TODO: Create Admin Component

        final FlexTable table = new FlexTable();
        RootPanel.get("tableContainer").add(table);

        final VerticalPanel bottomPanel = new VerticalPanel();
        RootPanel.get("bottomContainer").add(bottomPanel);


    }
}
