package org.panos.engine;

import java.util.Calendar;

/**
 * Engine data.
 * 
 * @author panos
 */
public class EngineData {

	// Instructions data
	private String entity;
	private String command;
	private Double agreedFx;
	private String currency;
	private Calendar instructionDate;
	private Calendar settlementDate;
	private Integer units;
	private Double pricePerUnit;
	
	// Extra engine data
	private Calendar newSettlementDate;
	private Double usdAmount;
	private Integer ranking;
	
	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}
	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}
	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}
	/**
	 * @param command the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}
	/**
	 * @return the agreedFx
	 */
	public Double getAgreedFx() {
		return agreedFx;
	}
	/**
	 * @param agreedFx the agreedFx to set
	 */
	public void setAgreedFx(Double agreedFx) {
		this.agreedFx = agreedFx;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the instructionDate
	 */
	public Calendar getInstructionDate() {
		return instructionDate;
	}
	/**
	 * @param instructionDate the instructionDate to set
	 */
	public void setInstructionDate(Calendar instructionDate) {
		this.instructionDate = instructionDate;
	}
	/**
	 * @return the settlementDate
	 */
	public Calendar getSettlementDate() {
		return settlementDate;
	}
	/**
	 * @param settlementDate the settlementDate to set
	 */
	public void setSettlementDate(Calendar settlementDate) {
		this.settlementDate = settlementDate;
	}
	/**
	 * @return the units
	 */
	public Integer getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(Integer units) {
		this.units = units;
	}
	/**
	 * @return the pricePerUnit
	 */
	public Double getPricePerUnit() {
		return pricePerUnit;
	}
	/**
	 * @param pricePerUnit the pricePerUnit to set
	 */
	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	/**
	 * @return the newSettlementDate
	 */
	public Calendar getNewSettlementDate() {
		return newSettlementDate;
	}
	/**
	 * @param newSettlementDate the newSettlementDate to set
	 */
	public void setNewSettlementDate(Calendar newSettlementDate) {
		this.newSettlementDate = newSettlementDate;
	}
	/**
	 * @return the usdAmount
	 */
	public Double getUsdAmount() {
		return usdAmount;
	}
	/**
	 * @param usdAmount the usdAmount to set
	 */
	public void setUsdAmount(Double usdAmount) {
		this.usdAmount = usdAmount;
	}
	/**
	 * @return the ranking
	 */
	public Integer getRanking() {
		return ranking;
	}
	/**
	 * @param ranking the ranking to set
	 */
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
}
