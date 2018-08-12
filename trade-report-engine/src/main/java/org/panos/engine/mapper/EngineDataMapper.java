package org.panos.engine.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.panos.engine.EngineData;
import org.panos.tradereport.data.InstructionData;

/**
 * Engine data mapper
 * 
 * @author panos
 */
@Mapper
public interface EngineDataMapper {
	
	EngineDataMapper INSTANCE=Mappers.getMapper(EngineDataMapper.class);
	
	@Mapping(target="usdAmount", expression="java(instrData.getPricePerUnit() * instrData.getUnits() * instrData.getAgreedFx())")
	EngineData toEngineData(InstructionData instrData);
}
