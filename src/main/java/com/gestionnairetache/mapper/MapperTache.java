package com.gestionnairetache.mapper;

import com.gestionnairetache.dto.TacheDTO;
import com.gestionnairetache.model.TacheDAO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperTache {

    TacheDTO from(TacheDAO tacheDAO);

    TacheDAO from(TacheDTO tacheDTO);

    List<TacheDTO> from(List<TacheDAO> tachesDAO);
}
