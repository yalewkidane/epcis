package org.oliot.gcp.test;

import org.oliot.gcp.core.BinaryCodeParser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BinaryCodeParserTest extends TestCase {

	public BinaryCodeParserTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(BinaryCodeParserTest.class);
	}

	public void testSgtin96() {
		BinaryCodeParser bcp = new BinaryCodeParser();
		String epc = bcp.parse("3074257bf7194e4000001a85");
		assertTrue(epc.equals("urn:epc:id:sgtin:0614141.812345.6789"));
	}
}