package org.panos.tradereport.library;

import java.util.Calendar;

/**
 * The settlement date resolver interface.
 * 
 * @author panos
 */
public interface SettlementDateResolver {
	
	public Calendar getNewSettlementDate(Calendar oldSettlementDate);
	public String getCurrencyType();
	public void setCurrencyType(String currencyType);

	
}
