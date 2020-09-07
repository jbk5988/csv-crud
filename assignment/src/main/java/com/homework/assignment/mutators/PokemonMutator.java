package com.homework.assignment.mutators;

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
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PokemonMutator implements CSVMutator<Pokemon> {

//    @Value("${csv.persistence.path}")
//    private String csvFilePath;
    private String csvFilePath = "./pokemon.csv";
    List<Pokemon> entityList;
    CustomMappingStrategy<Pokemon> mappingStrategy;
    CsvToBean<Pokemon> csvToBean;
    StatefulBeanToCsv statefulBeanToCsv;


    public void addRow(Pokemon rowObject) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
        ) {
            mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(Pokemon.class);

            csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Pokemon.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .build();

            entityList = csvToBean.parse();
            entityList.add(rowObject);

            Writer writer  = new FileWriter(csvFilePath);

            statefulBeanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withMappingStrategy(mappingStrategy)
                    .withApplyQuotesToAll(false)
                    .build();

            statefulBeanToCsv.write(entityList);
            writer.close();
        }
    }

    public Pokemon getRow(long id) throws IOException {
        if (entityList == null) {
            try (
                    Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ) {
                mappingStrategy = new CustomMappingStrategy<>();
                mappingStrategy.setType(Pokemon.class);

                csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Pokemon.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withSkipLines(1)
                        .build();

                entityList = csvToBean.parse();
            }
        }
        Pokemon foundEntity = entityList.stream()
                .filter(pokemon -> id == pokemon.getId())
                .findAny()
                .orElse(null);

        return foundEntity;
    }

    public void updateRow(Pokemon rowObject) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        if (entityList == null) {
            try (
                    Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ) {
                mappingStrategy = new CustomMappingStrategy<>();
                mappingStrategy.setType(Pokemon.class);

                csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Pokemon.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withSkipLines(1)
                        .build();

                entityList = csvToBean.parse();
            }
        }

        Pokemon foundEntity = entityList.stream()
                .filter(pokemon -> rowObject.getId() == pokemon.getId())
                .findAny()
                .orElse(null);

        int rowPosition = entityList.indexOf(foundEntity);

        if(rowPosition != -1) {
            entityList.set(rowPosition, rowObject);

            try (
                    Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ) {
                mappingStrategy = new CustomMappingStrategy<>();
                mappingStrategy.setType(Pokemon.class);

                csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Pokemon.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withSkipLines(1)
                        .build();

                Writer writer  = new FileWriter(csvFilePath);

                statefulBeanToCsv = new StatefulBeanToCsvBuilder(writer)
                        .withMappingStrategy(mappingStrategy)
                        .withApplyQuotesToAll(false)
                        .build();

                statefulBeanToCsv.write(entityList);
                writer.close();
            }
        }
    }

    public void deleteRow() {
    }
}
