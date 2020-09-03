package com.homework.assignment;

import com.homework.assignment.entities.Pokemon;
import com.homework.assignment.mapping.CustomMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    private static final String SAMPLE_CSV_FILE_PATH = "./pokemon.csv";

    public void runTest() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CustomMappingStrategy<Pokemon> mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(Pokemon.class);

            CsvToBean<Pokemon> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Pokemon.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .build();

            List<Pokemon> pokemonList = new ArrayList<>();
            pokemonList = csvToBean.parse();

            Writer writer  = new FileWriter(SAMPLE_CSV_FILE_PATH);

            System.out.println(pokemonList.get(0).getName());

            StatefulBeanToCsv sbc = new StatefulBeanToCsvBuilder(writer)
                    .withMappingStrategy(mappingStrategy)
                    .withApplyQuotesToAll(false)
                    .build();

            Pokemon pk = new Pokemon();
            pk.setId(6969690);
            pk.setName("boo");
            pokemonList.add(pk);

            sbc.write(pokemonList);
            writer.close();
        }
}
