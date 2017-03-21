package com.netcracker.vasily.danilin;

import com.netcracker.vasily.danilin.client.BusTableTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class BusTableSuite extends GWTTestSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("Tests for BusTable");
    suite.addTestSuite(BusTableTest.class);
    return suite;
  }
}
