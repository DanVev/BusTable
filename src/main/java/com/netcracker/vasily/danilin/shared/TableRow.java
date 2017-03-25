package com.netcracker.vasily.danilin.shared;

import com.google.gwt.view.client.ProvidesKey;

/**
 * Created by Vasily Danilin on 24.03.2017.
 */
public class TableRow {
    public static final ProvidesKey<TableRow> KEY_PROVIDER = new ProvidesKey<TableRow>() {
        @Override
        public Object getKey(TableRow item) {
            return item == null ? null : item.getId();
        }
    };
    private static int nextId = 0;
    private int id;
    private String route;
    private String start;
    private String destination;
    private String time;

    public TableRow(String route, String start, String destination, String time) {
        this.route = route;
        this.start = start;
        this.destination = destination;
        this.time = time;
        id = nextId;
        nextId++;
    }

    public TableRow() {
        id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TableRow{" +
                "route='" + route + '\'' +
                ", start='" + start + '\'' +
                ", destination='" + destination + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
