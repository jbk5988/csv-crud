package com.homework.assignment.mapping;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

/**
 * @author Gibran
 */
public class CustomMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {

    private static final String[] HEADER = new String[]{
            "#","Name","Type 1","Type 2","Total","HP","Attack","Defense","Sp. Atk","Sp. Def","Speed","Generation","Legendary"
    };

    @Override
    public String[] generateHeader(T bean) throws CsvRequiredFieldEmptyException {
        super.generateHeader(bean);
        return HEADER;
    }
}