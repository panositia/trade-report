package org.panos.tradereport.library.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.panos.tradereport.library.SettlementDateResolver;

/**
 * Settlement Date resolver to working dates according to the currency type.
 * 
 * @author panos
 */
public class SpecialSettlementDateResolver implements SettlementDateResolver {

	private String currencyType;
	private Map<Integer, Integer> nextWorkingDay = new HashMap<Integer, Integer>();
	private List<String> specialStartWeek = new ArrayList<String>();

	/**
	 * Constructor without currency type is not valid.
	 */
	private SpecialSettlementDateResolver() {

	}

	public SpecialSettlementDateResolver(String currencyType) {
		this.currencyType = currencyType;
		specialStartWeek.add("AED");
		specialStartWeek.add("SAR");

		nextWorkingDay.put(Calendar.MONDAY, 0);
		nextWorkingDay.put(Calendar.TUESDAY, 0);
		nextWorkingDay.put(Calendar.WEDNESDAY, 0);
		nextWorkingDay.put(Calendar.THURSDAY, 0);
		if (specialStartWeek.contains(currencyType)) {
			nextWorkingDay.put(Calendar.FRIDAY, 2);
		} else {
			nextWorkingDay.put(Calendar.FRIDAY, 0);
		}
		if (specialStartWeek.contains(currencyType)) {
			nextWorkingDay.put(Calendar.SATURDAY, 1);
		} else {
			nextWorkingDay.put(Calendar.SATURDAY, 2);
		}
		if (specialStartWeek.contains(currencyType)) {
			nextWorkingDay.put(Calendar.SUNDAY, 0);
		} else {
			nextWorkingDay.put(Calendar.SUNDAY, 1);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.panos.tradereport.library.SettlementDateResolver#getNewSettlementDate(
	 * java.util.Calendar)
	 */
	@Override
	public Calendar getNewSettlementDate(Calendar oldSettlementDate) {

		Calendar newSettlementDate = (Calendar) oldSettlementDate.clone();
		int dayOfTheWeek = oldSettlementDate.get(Calendar.DAY_OF_WEEK);
		newSettlementDate.add(Calendar.DAY_OF_MONTH, nextWorkingDay.get(dayOfTheWeek));

		return newSettlementDate;
	}

	/**
	 * @return the currencyType
	 */
	public String getCurrencyType() {
		return currencyType;
	}

	/**
	 * @param currencyType the currencyType to set
	 */
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;

		// The currency type has changed. Re-init the common days.
		if (specialStartWeek.contains(currencyType)) {
			nextWorkingDay.put(Calendar.FRIDAY, 2);
		} else {
			nextWorkingDay.put(Calendar.FRIDAY, 0);
		}
		if (specialStartWeek.contains(currencyType)) {
			nextWorkingDay.put(Calendar.SATURDAY, 1);
		} else {
			nextWorkingDay.put(Calendar.SATURDAY, 2);
		}
		if (specialStartWeek.contains(currencyType)) {
			nextWorkingDay.put(Calendar.SUNDAY, 0);
		} else {
			nextWorkingDay.put(Calendar.SUNDAY, 1);
		}
	}

}
