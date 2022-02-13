package com.gestionnairetache.controller;


import com.gestionnairetache.dto.TacheDTO;
import com.gestionnairetache.service.TacheService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taches")
public class TacheController {

    @Autowired
    private TacheService tacheService;

    @ApiOperation(value = "Get toutes les tadches", response = Iterable.class, tags = "tache")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succes"),
            @ApiResponse(responseCode = "404", description = "not found") })
    @GetMapping()
    public  ResponseEntity<List<TacheDTO>> findAll() {
        return  new ResponseEntity<>(tacheService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get tache par son ID ", response = Iterable.class, tags = "tache")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succes"),
            @ApiResponse(responseCode = "404", description = "not found") })
    @GetMapping(value = "/{id}")
    public ResponseEntity<TacheDTO> findById(@PathVariable("id") String id) {
        return new ResponseEntity<>(tacheService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Get toutes les taches completés", response = Iterable.class, tags = "tache")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succes"),
            @ApiResponse(responseCode = "404", description = "not found") })
    @GetMapping(value= "/completed")
    public ResponseEntity<List<TacheDTO>> findAllCompleted() {
        return new ResponseEntity<>(tacheService.findAllCompleted(), HttpStatus.OK);
    }

    @ApiOperation(value = "Post une nouvelle tache", response = Iterable.class, tags = "tache")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succes"),
            @ApiResponse(responseCode = "404", description = "not found") })
    @PostMapping("")
    public ResponseEntity<TacheDTO> newTache(@RequestBody TacheDTO tacheDTO) {
        return new ResponseEntity<>(tacheService.save(tacheDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Modifie le status d'une tache", response = Iterable.class, tags = "tache")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succes"),
            @ApiResponse(responseCode = "404", description = "not found") })
   @PutMapping(value = "/{id}")
    public ResponseEntity<TacheDTO> tacheStatus(@PathVariable("id") String id, @RequestParam boolean status) {
        return new ResponseEntity<>(tacheService.completed(id, status), HttpStatus.OK);
    }
}
