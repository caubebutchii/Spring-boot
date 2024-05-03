package com.namvu.projectfinal.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

public class MapperUtil {
    public static ModelMapper getInstance() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    public static <D> D mapObject(Object source, Class<D> destinationClass) {
        return getInstance().map(source, destinationClass);
    }
}
