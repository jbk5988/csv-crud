package com.homework.assignment.persistence;

import com.homework.assignment.entities.Pokemon;
import com.homework.assignment.mutators.CSVMutator;
import com.homework.assignment.mutators.PokemonMutator;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Gibran
 */
@Repository
public class PokemonDAO implements DAO<Pokemon>{

    @Autowired
    PokemonMutator pokemonMutator;

    @Override
    public void save(Pokemon pokemon) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        pokemonMutator.addRow(pokemon);
    }

    @Override
    public Optional<Pokemon> get(long id) throws IOException {
        Optional<Pokemon> requestedPokemon = Optional.ofNullable(pokemonMutator.getRow(id));;
        return requestedPokemon;
    }

    @Override
    public List<Pokemon> getAll() {
        return null;
    }

    @Override
    public void update(Pokemon pokemon, String[] params) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        pokemonMutator.updateRow(pokemon);
    }

    @Override
    public void delete(Pokemon pokemon) {

    }
}
