package com.homework.assignment.mutators;

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
import org.springframework.beans.factory.annotation.Value;

public class CSVMutator<T> implements Mutator<T> {

//    @Value("${csv.persistence.path}")
//    private String csvFilePath;
    private String csvFilePath = "./pokemon.csv";
    Class<T> clazz;
    List<T> entityList;
    Class<T> entityBeanType;
    CustomMappingStrategy<T> mappingStrategy;
    CsvToBean<T> csvToBean;
    StatefulBeanToCsv statefulBeanToCsv;

    public CSVMutator(Class<T> clazz) {
        this.clazz = clazz;
    }


    public void addRow(T rowObject) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
        ) {
            mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(clazz);

            csvToBean = new CsvToBeanBuilder(reader)
                    .withType(clazz)
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

    public void getRow() {
    }

    public void updateRow() {
    }

    public void deleteRow() {
    }
}
