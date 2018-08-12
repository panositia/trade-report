package org.panos.engine;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.panos.engine.common.Constants;

/**
 * Report data.
 * 
 * @author panos
 */
public class ReportData {

	private SortedMap<String, List<EngineData>> dailyIncomingReportData = new TreeMap<String, List<EngineData>>();
	private SortedMap<String, List<EngineData>> dailyOutgoingReportData = new TreeMap<String, List<EngineData>>();
	private SortedMap<String, Double> dailyIncomingSum = new TreeMap<String, Double>();
	private SortedMap<String, Double> dailyOutgoingSum = new TreeMap<String, Double>();
	private SimpleDateFormat isoDate = new SimpleDateFormat("yyyy-MM-dd");

	public ReportData() {

	}

	public void addEngineData(EngineData engData) {
		String dateKey = isoDate.format(engData.getNewSettlementDate().getTime());

		if (engData.getCommand().equals(Constants.INCOMING_COMMAND)) {
			updateDailyReportData(engData, dailyIncomingReportData, dailyIncomingSum);
		} else if (engData.getCommand().equals(Constants.OUTGOING_COMMAND)) {
			updateDailyReportData(engData, dailyOutgoingReportData, dailyOutgoingSum);
		} else {
			throw new RuntimeException("Unsupported command " + engData.getCommand() + " specified.");
		}
	}

	private void updateDailyReportData(EngineData repData, SortedMap<String, List<EngineData>> dailyReportData,
			SortedMap<String, Double> dailySum) {
		String dateKey = isoDate.format(repData.getNewSettlementDate().getTime());
		List<EngineData> dateValue = dailyReportData.get(dateKey);
		if (dateValue != null) {
			for (int i = 0; i < dateValue.size(); i++) {
				if (repData.getUsdAmount() > dateValue.get(i).getUsdAmount()) {
					dateValue.add(i, repData);
					break;
				} else if (i == dateValue.size() - 1) {
					// End of list detected and the item was still not inserted. Add it at the end.
					dateValue.add(repData);
					break;
				}
			}
		} else {
			dateValue = new ArrayList<EngineData>();
			dateValue.add(repData);
		}
		dailyReportData.put(dateKey, dateValue);
		if (dailySum.get(dateKey) != null) {
			dailySum.put(dateKey, dailySum.get(dateKey) + repData.getUsdAmount());
		} else {
			dailySum.put(dateKey, repData.getUsdAmount());
		}
	}

	/**
	 * @return the dailyIncomingReportData
	 */
	public SortedMap<String, List<EngineData>> getDailyIncomingReportData() {
		return dailyIncomingReportData;
	}

	/**
	 * @param dailyIncomingReportData the dailyIncomingReportData to set
	 */
	public void setDailyIncomingReportData(SortedMap<String, List<EngineData>> dailyIncomingReportData) {
		this.dailyIncomingReportData = dailyIncomingReportData;
	}

	/**
	 * @return the dailyOutgoingReportData
	 */
	public SortedMap<String, List<EngineData>> getDailyOutgoingReportData() {
		return dailyOutgoingReportData;
	}

	/**
	 * @param dailyOutgoingReportData the dailyOutgoingReportData to set
	 */
	public void setDailyOutgoingReportData(SortedMap<String, List<EngineData>> dailyOutgoingReportData) {
		this.dailyOutgoingReportData = dailyOutgoingReportData;
	}

	/**
	 * @return the dailyIncomingSum
	 */
	public SortedMap<String, Double> getDailyIncomingSum() {
		return dailyIncomingSum;
	}

	/**
	 * @param dailyIncomingSum the dailyIncomingSum to set
	 */
	public void setDailyIncomingSum(SortedMap<String, Double> dailyIncomingSum) {
		this.dailyIncomingSum = dailyIncomingSum;
	}

	/**
	 * @return the dailyOutgoingSum
	 */
	public SortedMap<String, Double> getDailyOutgoingSum() {
		return dailyOutgoingSum;
	}

	/**
	 * @param dailyOutgoingSum the dailyOutgoingSum to set
	 */
	public void setDailyOutgoingSum(SortedMap<String, Double> dailyOutgoingSum) {
		this.dailyOutgoingSum = dailyOutgoingSum;
	}
}
