package com.homework.assignment.controllers;

import com.homework.assignment.entities.Pokemon;
import com.homework.assignment.persistence.PokemonDAO;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gibran
 */
@RestController
public class PokedexController {

    @Autowired
    PokemonDAO pokemonDAO;

    @PostMapping("/addpokemon")
    public String addPokemonm(@RequestBody Pokemon pokemon, BindingResult result)
            throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "/";
        }

        pokemonDAO.save(pokemon);
        return "Pokemon created";
    }


    @GetMapping(value="/pokemon/{id}")
    Pokemon getPokemon(@PathVariable Long id) throws IOException {
        return pokemonDAO.get(id).get();
    }

    @PostMapping("/updatepokemon")
    public String updatePokemon(@RequestBody Pokemon pokemon, BindingResult result)
            throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "/";
        }

        pokemonDAO.update(pokemon, null);
        return "Pokemon updated";
    }
}
