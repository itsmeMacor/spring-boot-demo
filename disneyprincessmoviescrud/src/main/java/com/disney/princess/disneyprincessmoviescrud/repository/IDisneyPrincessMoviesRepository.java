/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disney.princess.disneyprincessmoviescrud.repository;

import com.disney.princess.disneyprincessmoviescrud.model.DisneyPrincessMovies;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Macor
 */
public interface IDisneyPrincessMoviesRepository extends CrudRepository<DisneyPrincessMovies, Integer>{
	DisneyPrincessMovies getPrincessByid(int id);
}