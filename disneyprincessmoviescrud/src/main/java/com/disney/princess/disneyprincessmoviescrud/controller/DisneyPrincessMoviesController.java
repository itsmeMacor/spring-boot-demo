/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disney.princess.disneyprincessmoviescrud.controller;

import com.disney.princess.disneyprincessmoviescrud.model.DisneyPrincessMovies;
import com.disney.princess.disneyprincessmoviescrud.repository.IDisneyPrincessMoviesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Macor
 */
@RestController
public class DisneyPrincessMoviesController {
    
    @Autowired
    IDisneyPrincessMoviesRepository reposotry;
    
    @RequestMapping(value = "/princess/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DisneyPrincessMovies> createPrincess(@RequestBody DisneyPrincessMovies princess){
        try {
            reposotry.save(princess);
            return new ResponseEntity<>(princess, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/readAllRecord", method = RequestMethod.GET, produces = "application/json")
    public List<DisneyPrincessMovies> listAllPrincess(){
        return (List<DisneyPrincessMovies>)reposotry.findAll();
    }
    
    @RequestMapping(value = "/readRecordByID/id/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getPrincessByid(@PathVariable int id){
        DisneyPrincessMovies princessbyid = reposotry.getPrincessByid(id);
        if(princessbyid == null){
            return new ResponseEntity("No record found",HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(princessbyid, HttpStatus.ACCEPTED);
        
    }
    
    @RequestMapping(value = "/princess/delete/{id}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity deletePrincessById(@PathVariable int id){
        DisneyPrincessMovies princessbyid = reposotry.getPrincessByid(id);
        if(princessbyid == null){
            return new ResponseEntity("No record found ",HttpStatus.NOT_FOUND);
        }
            reposotry.delete(id);
            return new ResponseEntity<>(princessbyid, HttpStatus.GONE);
    }
    
    @RequestMapping(value = "/princess/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity updatePrincessById(@RequestBody DisneyPrincessMovies princess){
        DisneyPrincessMovies princessbyid = reposotry.getPrincessByid(princess.getId());
        if(princessbyid == null){
            return new ResponseEntity("princess not found ",HttpStatus.NOT_FOUND);
        }
            reposotry.save(princess);
            return new ResponseEntity<>(princess, HttpStatus.OK);
    }
    
   
}