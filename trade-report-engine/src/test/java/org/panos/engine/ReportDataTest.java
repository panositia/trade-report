package org.panos.engine;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;
import java.util.SortedMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.panos.engine.common.Constants;
import org.panos.engine.mapper.EngineDataMapper;
import org.panos.tradereport.data.InstructionData;
import org.panos.tradereport.library.SettlementDateResolver;
import org.panos.tradereport.library.impl.SpecialSettlementDateResolver;

public class ReportDataTest {

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
	public void testAddEngineData() {
		ReportData repData=new ReportData();
		Calendar testInstrDate=Calendar.getInstance();
		testInstrDate.clear();
		Calendar testSettleDate=Calendar.getInstance();
		testSettleDate.clear();
		SettlementDateResolver settleDateRes=new SpecialSettlementDateResolver("EUR");
		InstructionData instrData=new InstructionData();

		instrData.setEntity("Engine Data 1");
		instrData.setCommand(Constants.OUTGOING_COMMAND);
		instrData.setAgreedFx(0.5);
		instrData.setCurrency("EUR");
		testInstrDate.set(2018, 7, 10);
		instrData.setInstructionDate(testInstrDate);
		testSettleDate.set(2018, 7, 11);
		instrData.setSettlementDate(testSettleDate);
		instrData.setUnits(100);	
		instrData.setPricePerUnit(1.50);
		settleDateRes.setCurrencyType(instrData.getCurrency());
		EngineData engData1=EngineDataMapper.INSTANCE.toEngineData(instrData);
		engData1.setNewSettlementDate(settleDateRes.getNewSettlementDate(engData1.getSettlementDate()));
		repData.addEngineData(engData1);
		
		instrData.setEntity("Engine Data 2");
		instrData.setCommand(Constants.INCOMING_COMMAND);
		instrData.setAgreedFx(0.9);
		instrData.setCurrency("AED");
		testInstrDate.set(2018, 7, 2);
		instrData.setInstructionDate(testInstrDate);
		testSettleDate.set(2018, 7, 3);
		instrData.setSettlementDate(testSettleDate);
		instrData.setUnits(200);
		instrData.setPricePerUnit(2.50);
		settleDateRes.setCurrencyType(instrData.getCurrency());
		EngineData engData2=EngineDataMapper.INSTANCE.toEngineData(instrData);
		engData2.setNewSettlementDate(settleDateRes.getNewSettlementDate(engData2.getSettlementDate()));
		repData.addEngineData(engData2);
		
		instrData.setEntity("Engine Data 3");
		instrData.setCommand(Constants.INCOMING_COMMAND);
		instrData.setAgreedFx(0.7);
		instrData.setCurrency("SAR");
		testInstrDate.set(2018, 7, 3);
		instrData.setInstructionDate(testInstrDate);
		testSettleDate.set(2018, 7, 4);
		instrData.setSettlementDate(testSettleDate);
		instrData.setUnits(100);
		instrData.setPricePerUnit(3.50);
		settleDateRes.setCurrencyType(instrData.getCurrency());
		EngineData engData3=EngineDataMapper.INSTANCE.toEngineData(instrData);
		engData3.setNewSettlementDate(settleDateRes.getNewSettlementDate(engData3.getSettlementDate()));
		repData.addEngineData(engData3);

		instrData.setEntity("Engine Data 4");
		instrData.setCommand(Constants.OUTGOING_COMMAND);
		instrData.setAgreedFx(1.1);
		instrData.setCurrency("EUR");
		testInstrDate.set(2018, 7, 8);
		instrData.setInstructionDate(testInstrDate);
		testSettleDate.set(2018, 7, 12);
		instrData.setSettlementDate(testSettleDate);
		instrData.setUnits(150);
		instrData.setPricePerUnit(2.00);
		settleDateRes.setCurrencyType(instrData.getCurrency());
		EngineData engData4=EngineDataMapper.INSTANCE.toEngineData(instrData);
		engData4.setNewSettlementDate(settleDateRes.getNewSettlementDate(engData4.getSettlementDate()));
		repData.addEngineData(engData4);

		instrData.setEntity("Engine Data 5");
		instrData.setCommand(Constants.OUTGOING_COMMAND);
		instrData.setAgreedFx(1.2);
		instrData.setCurrency("AED");
		testInstrDate.set(2018, 7, 10);
		instrData.setInstructionDate(testInstrDate);
		testSettleDate.set(2018, 7, 13);
		instrData.setSettlementDate(testSettleDate);
		instrData.setUnits(300);
		instrData.setPricePerUnit(0.50);
		settleDateRes.setCurrencyType(instrData.getCurrency());
		EngineData engData5=EngineDataMapper.INSTANCE.toEngineData(instrData);
		engData5.setNewSettlementDate(settleDateRes.getNewSettlementDate(engData5.getSettlementDate()));
		repData.addEngineData(engData5);
		
		SortedMap<String, List<EngineData>> dailyInRepData=repData.getDailyIncomingReportData();
		SortedMap<String, List<EngineData>> dailyOutRepData=repData.getDailyOutgoingReportData();
		SortedMap<String, Double> dailyInSum=repData.getDailyIncomingSum();
		SortedMap<String, Double> dailyOutSum=repData.getDailyOutgoingSum();
		
		List<EngineData> dailyRepDataList=dailyInRepData.get("2018-08-05");
		
		assertEquals(2, dailyRepDataList.size());
		assertEquals(engData2, dailyRepDataList.get(0));
		assertEquals(engData3, dailyRepDataList.get(1));
		assertEquals(new Double(695.0), dailyInSum.get("2018-08-05"));
		
		dailyRepDataList=dailyOutRepData.get("2018-08-13");
		
		assertEquals(3, dailyRepDataList.size());
		assertEquals(engData4, dailyRepDataList.get(0));
		assertEquals(engData5, dailyRepDataList.get(1));
		assertEquals(engData1, dailyRepDataList.get(2));
		assertEquals(new Double(585.0), dailyOutSum.get("2018-08-13"));
	}

}
