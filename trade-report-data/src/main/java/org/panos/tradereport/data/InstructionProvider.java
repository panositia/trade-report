package org.panos.tradereport.data;

import java.util.List;

/**
 * The instruction provider interface
 * 
 * @author panos
 */
public interface InstructionProvider {
	
	/**
	 * Get all the available instructions.
	 * 
	 * @return A list of instruction data
	 */
	public List<InstructionData> getInstructions();
}
