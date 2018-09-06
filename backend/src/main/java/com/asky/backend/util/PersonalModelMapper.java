package com.asky.backend.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;


public class PersonalModelMapper {

    private static ModelMapper modelMapper=new ModelMapper();



    public static<T,D> List<D> mapListEntityToListDtos(List<T> sourceList, Class<D> destinationClass){

        return sourceList.stream()
                .map(entity->

                        modelMapper.map(entity,destinationClass))
                .collect(Collectors.toList());

    }

}
