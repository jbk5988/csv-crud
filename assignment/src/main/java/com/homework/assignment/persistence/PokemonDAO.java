package com.homework.assignment.persistence;

import com.homework.assignment.entities.Pokemon;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * @author Gibran
 */
@Repository
public class PokemonDAO implements DAO<Pokemon>{

//    @Autowired
//    CSVMutator<Pokemon> csvMutator;

    @Override
    public void save(Pokemon pokemon) {
//        csvMutator.addRow(pokemon);
    }

    @Override
    public Optional<Pokemon> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Pokemon> getAll() {
        return null;
    }

    @Override
    public void update(Pokemon pokemon, String[] params) {

    }

    @Override
    public void delete(Pokemon pokemon) {

    }
}
