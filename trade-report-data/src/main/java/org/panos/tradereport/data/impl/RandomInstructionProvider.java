package org.panos.tradereport.data.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.panos.tradereport.data.InstructionData;
import org.panos.tradereport.data.InstructionProvider;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

/**
 * Random instruction provider.
 * 
 * @author panos
 */
public class RandomInstructionProvider implements InstructionProvider {

	private List<InstructionData> randomInstructions = new ArrayList<InstructionData>();
	private Integer numberOfInstructions = new Integer(10);
	private Random randNumber;
	private Lorem loremIpsum;
	private String[] commandList = { "B", "S" };
	private String[] currencyList = { "ASD", "SAR", "EUR", "SGP" };

	/**
	 * Constructor method.
	 */
	public RandomInstructionProvider() {
		randNumber = new Random(Calendar.getInstance().getTimeInMillis());
		loremIpsum = new LoremIpsum(randNumber.nextLong());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.panos.tradereport.data.InstructionProvider#getInstructions()
	 */
	public List<InstructionData> getInstructions() {

		List<InstructionData> instrDataList = new ArrayList<InstructionData>();

		for (int instructionNumber = 1; instructionNumber <= numberOfInstructions.intValue(); instructionNumber++) {
			InstructionData instrData = new InstructionData();
			instrData.setEntity(loremIpsum.getName());
			instrData.setCommand(commandList[randNumber.nextInt(commandList.length)]);
			instrData.setAgreedFx(randNumber.nextDouble() + 0.5);
			instrData.setCurrency(currencyList[randNumber.nextInt(currencyList.length)]);
			Calendar instrDate = Calendar.getInstance();
			instrDate.add(Calendar.DAY_OF_MONTH, -1 * randNumber.nextInt(30));
			instrData.setInstructionDate(instrDate);
			Calendar settleDate = (Calendar) instrDate.clone();
			settleDate.add(Calendar.DAY_OF_MONTH, randNumber.nextInt(2));
			instrData.setSettlementDate(settleDate);
			instrData.setUnits(randNumber.nextInt(1000));
			instrData.setPricePerUnit(randNumber.nextDouble() * 100);
			instrDataList.add(instrData);
		}

		return instrDataList;
	}

}
