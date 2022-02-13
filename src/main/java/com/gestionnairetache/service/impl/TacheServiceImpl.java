package com.gestionnairetache.service.impl;

import com.gestionnairetache.dto.TacheDTO;
import com.gestionnairetache.mapper.MapperTache;
import com.gestionnairetache.model.TacheDAO;
import com.gestionnairetache.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static FakeBDD.FakeBDD.taches;

@Service
public class TacheServiceImpl implements TacheService {

    private List<TacheDAO> bdd = taches;
    @Autowired
    private MapperTache mapperTache;
    @Override
    public List<TacheDTO> findAll() {
        return mapperTache.from(bdd);
    }

    @Override
    public TacheDTO findById(String id) {
        return mapperTache.from(bdd.stream().filter(tache -> tache.getId().equals(id)).findFirst().orElse(null));
    }

    @Override
    public List<TacheDTO> findAllCompleted() {
        return mapperTache.from(bdd.stream().filter(tache -> tache.isComplete() == true).collect(Collectors.toList()));
    }

    @Override
    public TacheDTO save(TacheDTO tacheDTO) {
        tacheDTO.setId(generateId());
        bdd.add(mapperTache.from(tacheDTO));
        return tacheDTO;
    }

    @Override
    public TacheDTO completed(String id, boolean status) {
        TacheDAO tache = bdd.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
        if(tache == null){
            return null;
        }

        tache.setComplete(status);
        return mapperTache.from(tache);
    }

    /**
     * Genère un ID non présent dans la fakeBDD static
     */
    private String generateId() {

        // Generation d'un id aleatoir en 1 et 100
        String id = String.valueOf((int)(Math.random()*(100-1+1)+1));
        boolean check = true;

        // Verifie si l'id n'est pas déja utiliser
        while(check){
            String finalId = id;
            check = bdd.stream().filter(tacheDAO -> tacheDAO.getId().equals(finalId)).collect(Collectors.toList()).size() != 0;
            id = String.valueOf((int)(Math.random()*(100-1+1)+1));
        }

        return id;
    }
}
