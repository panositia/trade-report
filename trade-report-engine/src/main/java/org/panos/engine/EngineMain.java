package org.panos.engine;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;

import org.panos.engine.common.Util;
import org.panos.engine.mapper.EngineDataMapper;
import org.panos.tradereport.data.InstructionData;
import org.panos.tradereport.data.InstructionProvider;
import org.panos.tradereport.data.impl.RandomInstructionProvider;
import org.panos.tradereport.library.SettlementDateResolver;
import org.panos.tradereport.library.impl.SpecialSettlementDateResolver;

/**
 * The main Engine program.
 * 
 * @author panos
 */
public class EngineMain {
	//public static String ENGINE_VERSION = Util.getEngineVersion();
	public static String ENGINE_VERSION = "1.0.0";
	public static String EXECUTION_DATE = Calendar.getInstance().getTime().toString();
	private static SimpleDateFormat isoDate = new SimpleDateFormat("yyyy-MM-dd");
	private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
	private static DecimalFormat decimalFormat = new DecimalFormat("0.0000");

	public static void main(String[] args) {
		System.out.println("Starting Daily Trade Report Engine version " + ENGINE_VERSION + " on " + EXECUTION_DATE);

		System.out.println("Retrieving instructions...");

		InstructionProvider instrProvider = new RandomInstructionProvider();

		List<InstructionData> availableInstructions = instrProvider.getInstructions();

		SettlementDateResolver settleDateRes = new SpecialSettlementDateResolver("EUR");

		ReportData repData = new ReportData();

		System.out.println("\nEntity\t\t\t| Buy/Sell\t| AgreedFx\t| Currency\t| Instruction Date\t| Settlement Date\t| Units\t| Price Per Unit");

		for (InstructionData instrData : availableInstructions) {
			displayInstructionData(instrData);
			EngineData engData = EngineDataMapper.INSTANCE.toEngineData(instrData);
			settleDateRes.setCurrencyType(instrData.getCurrency());
			engData.setNewSettlementDate(settleDateRes.getNewSettlementDate(engData.getSettlementDate()));
			repData.addEngineData(engData);
		}

		System.out.println("\nDaily Incoming Amounts and Rankings:");
		displayReportData(repData.getDailyIncomingReportData(), repData.getDailyIncomingSum());

		System.out.println("\nDaily Outgoing Amounts and Rankings:");
		displayReportData(repData.getDailyOutgoingReportData(), repData.getDailyOutgoingSum());

		System.out.println("\nEnd of Report data.");
	}

	private static void displayInstructionData(InstructionData dispInstrData) {
		System.out.print(dispInstrData.getEntity() + "\t\t| ");
		System.out.print(dispInstrData.getCommand() + "\t\t| ");
		System.out.print(decimalFormat.format(dispInstrData.getAgreedFx()) + "\t| ");
		System.out.print(dispInstrData.getCurrency() + "\t\t| ");
		System.out.print(isoDate.format(dispInstrData.getInstructionDate().getTime()) + "\t\t| ");
		System.out.print(isoDate.format(dispInstrData.getSettlementDate().getTime()) + "\t\t| ");
		System.out.print(dispInstrData.getUnits() + "\t| ");
		System.out.println(currencyFormat.format(dispInstrData.getPricePerUnit()));
	}

	private static void displayReportData(SortedMap<String, List<EngineData>> dailyRepData, SortedMap<String, Double> dailySum) {
		for (String dateKey : dailyRepData.keySet()) {
			System.out.println("Amount in USD settled for " + dateKey + " is " + currencyFormat.format(dailySum.get(dateKey)));
			int ranking = 1;
			for (EngineData engData : dailyRepData.get(dateKey)) {
				System.out.println("Ranking " + ranking++ + " is entity " + engData.getEntity() + " with instruction amount "
						+ currencyFormat.format(engData.getUsdAmount()));
			}
		}
	}
}
