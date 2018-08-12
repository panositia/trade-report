package org.panos.tradereport.library.impl;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.panos.tradereport.library.SettlementDateResolver;

public class SpecialSettlementDateResolverTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNewSettlementDateEur() {

		SettlementDateResolver testSettleDateRes = new SpecialSettlementDateResolver("EUR");

		Calendar testDate = Calendar.getInstance();
		Calendar expectDate = Calendar.getInstance();
		
		// Monday 13/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 13, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 13, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));
		
		// Tuesday 14/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 14, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 14, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));
		
		// Wednesday 15/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 15, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 15, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));

		// Thursday 16/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 16, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 16, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));

		// Friday 17/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 17, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 17, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));

		// Saturday 18/08/2018 shifts to Monday 20/08/2018
		testDate.clear();
		testDate.set(2018, 7, 18, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 20, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));

		// Sunday 19/08/2018 shifts to Monday 20/08/2018
		testDate.clear();
		testDate.set(2018, 7, 19, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 20, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));
	}

	@Test
	public void testGetNewSettlementDateAed() {

		SettlementDateResolver testSettleDateRes = new SpecialSettlementDateResolver("AED");

		Calendar testDate = Calendar.getInstance();
		Calendar expectDate = Calendar.getInstance();
		
		// Monday 13/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 13, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 13, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));
		
		// Tuesday 14/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 14, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 14, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));
		
		// Wednesday 15/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 15, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 15, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));

		// Thursday 16/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 16, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 16, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));

		// Friday 17/08/2018 shifts to Sunday 19/08/2018
		testDate.clear();
		testDate.set(2018, 7, 17, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 19, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));

		// Saturday 18/08/2018 shifts to Sunday 19/08/2018
		testDate.clear();
		testDate.set(2018, 7, 18, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 19, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));

		// Sunday 19/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 19, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 19, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));
	}

	@Test
	public void testGetNewSettlementDateSar() {

		SettlementDateResolver testSettleDateRes = new SpecialSettlementDateResolver("SAR");

		Calendar testDate = Calendar.getInstance();
		Calendar expectDate = Calendar.getInstance();
		
		// Monday 13/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 13, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 13, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));
		
		// Tuesday 14/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 14, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 14, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));
		
		// Wednesday 15/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 15, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 15, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));

		// Thursday 16/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 16, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 16, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));

		// Friday 17/08/2018 shifts to Sunday 19/08/2018
		testDate.clear();
		testDate.set(2018, 7, 17, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 19, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));

		// Saturday 18/08/2018 shifts to Sunday 19/08/2018
		testDate.clear();
		testDate.set(2018, 7, 18, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 19, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));

		// Sunday 19/08/2018 remains the same
		testDate.clear();
		testDate.set(2018, 7, 19, 0, 0, 0);
		expectDate.clear();
		expectDate.set(2018, 7, 19, 0, 0, 0);
		assertEquals(expectDate, testSettleDateRes.getNewSettlementDate(testDate));
	}
}
