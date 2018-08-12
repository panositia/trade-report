package org.panos.tradereport.data.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.panos.tradereport.data.InstructionData;
import org.panos.tradereport.data.InstructionProvider;

public class RandomInstructionProviderTest {

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
	public void testRandomInstructionProvider() {
		InstructionProvider testInstrProvider = new RandomInstructionProvider();

		assertNotNull(testInstrProvider);
	}

	@Test
	public void testGetInstructions() {
		InstructionProvider testInstrProvider = new RandomInstructionProvider();

		List<InstructionData> testInstrDataList = testInstrProvider.getInstructions();

		assertNotNull(testInstrDataList);
		assertNotEquals(testInstrDataList.size(), 0);
	}
}
