package com.netcracker.vasily.danilin.client;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.netcracker.vasily.danilin.shared.TableRow;

import java.util.Comparator;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BusTable implements EntryPoint {

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
    @UiField(provided = true)
    private CellTable<TableRow> table;
    @UiField(provided = true)
    private SimplePager pager;
    private ListDataProvider<TableRow> dataProvider = new ListDataProvider<TableRow>();

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
        final Button sortButton = new Button("Sorting");
        final Button filterButton = new Button("Filter");
        buttonPanel.add(sortButton);
        buttonPanel.add(filterButton);

        //TODO: Create Admin Component
        table = new CellTable<TableRow>();
        table.setWidth("100%", true);
        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        //RootPanel.get("tableContainer").add(table);
        ColumnSortEvent.ListHandler<TableRow> sortHandler = new ColumnSortEvent.ListHandler<TableRow>(
                dataProvider.getList());
        table.addColumnSortHandler(sortHandler);
        initColumns(sortHandler);
        dataProvider.addDataDisplay(table);
        tableDataRequest();
        table.setRowCount(dataProvider.getList().size());

        table.setAutoHeaderRefreshDisabled(true);
        table.setAutoFooterRefreshDisabled(true);

        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
        pager.setDisplay(table);
        pager.setPageSize(10);

        final VerticalPanel bottomPanel = new VerticalPanel();
        bottomPanel.add(table);
        bottomPanel.add(pager);
        bottomPanel.setCellHorizontalAlignment(pager, HasHorizontalAlignment.ALIGN_CENTER);
        bottomPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        RootPanel.get("tableContainer").add(bottomPanel);

    }

    private void initColumns(ColumnSortEvent.ListHandler<TableRow> sortHandler) {
        //String[] tableColumnNames = new String[]{"Route №", "Start point", "Destination Point", "Arrival Time"};
        TextColumn<TableRow> routeColumn =
                new TextColumn<TableRow>() {
                    @Override
                    public String getValue(TableRow object) {
                        return (new Integer(object.getRoute())).toString();
                    }
                };
        routeColumn.setSortable(true);
        table.addColumn(routeColumn, "Route №");
        sortHandler.setComparator(routeColumn, new Comparator<TableRow>() {
            @Override
            public int compare(TableRow o1, TableRow o2) {
                return (new Integer(o1.getRoute())).compareTo(o2.getRoute());
            }
        });

        TextColumn<TableRow> startColumn =
                new TextColumn<TableRow>() {
                    @Override
                    public String getValue(TableRow object) {
                        return object.getStart();
                    }
                };
        startColumn.setSortable(true);
        table.addColumn(startColumn, "Start Point");
        sortHandler.setComparator(startColumn, new Comparator<TableRow>() {
            @Override
            public int compare(TableRow o1, TableRow o2) {
                return o1.getStart().compareTo(o2.getStart());
            }
        });

        TextColumn<TableRow> destinationColumn =
                new TextColumn<TableRow>() {
                    @Override
                    public String getValue(TableRow object) {
                        return object.getDestination();
                    }
                };
        destinationColumn.setSortable(true);
        table.addColumn(destinationColumn, "Destination Point");
        sortHandler.setComparator(destinationColumn, new Comparator<TableRow>() {
            @Override
            public int compare(TableRow o1, TableRow o2) {
                return o1.getDestination().compareTo(o2.getDestination());
            }
        });

        TextColumn<TableRow> timeColumn =
                new TextColumn<TableRow>() {
                    @Override
                    public String getValue(TableRow object) {
                        return object.getTime();
                    }
                };
        timeColumn.setSortable(true);
        table.addColumn(timeColumn, "Time");
        sortHandler.setComparator(timeColumn, new Comparator<TableRow>() {
            @Override
            public int compare(TableRow o1, TableRow o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });

    }

    private void tableDataRequest() {
        greetingService.greetServer("", new AsyncCallback<List<TableRow>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(List<TableRow> lists) {
                dataProvider.getList().addAll(lists);
                dataProvider.flush();
                dataProvider.refresh();
                table.redraw();


            }
        });
    }
}
