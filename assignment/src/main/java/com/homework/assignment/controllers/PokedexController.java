package com.homework.assignment.controllers;

import com.homework.assignment.entities.Pokemon;
import com.homework.assignment.persistence.PokemonDAO;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gibran
 */
@RestController
public class PokedexController {

    @Autowired
    PokemonDAO pokemonDAO;

    @GetMapping(value="/{id}")
    Pokemon getPokemon(@PathVariable Long id) throws IOException {
        return pokemonDAO.get(id).get();
    }
}
