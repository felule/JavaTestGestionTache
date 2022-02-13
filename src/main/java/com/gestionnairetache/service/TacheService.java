package com.gestionnairetache.service;

import com.gestionnairetache.dto.TacheDTO;

import java.util.List;

public interface TacheService {
    public List<TacheDTO> findAll();

    public TacheDTO findById(String id);

    public  List<TacheDTO> findAllCompleted();

    public TacheDTO save(TacheDTO tacheDTO);

    public TacheDTO completed(String id, boolean status);

}
