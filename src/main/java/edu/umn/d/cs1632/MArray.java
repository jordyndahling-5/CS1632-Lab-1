package edu.umn.d.cs1632;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class MArray {
    // ArrayList<Feature> featureList;
    // ArrayList<ArrayList<DataItem>> data;
    private MArray() {}

    public MArray(String fileName) {
        try {
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();

            data = new Value[allData.size()][allData.get(0).length];

            Value value;


            for (int r = 0; r < allData.size(); r++) {
                String[] row = allData.get(r);

                for (int c = 0; c < row.length; c++) {
                    String cell = row[c];

                    if (cell == null) {
                        System.out.print(cell + "(null)" + " ");
                        continue;
                    }
                    try {
                        value = new IntValue(cell);
                    } catch (NumberFormatException e) {
                        try {
                            value = new DoubleValue(cell);
                        } catch (NumberFormatException e2) {
                            value = new StringValue(cell);
                        }
                    }
                    data[r][c] = value;


                    if (value instanceof IntValue) {
                        System.out.print(cell + "(I) ");
                    } else if (value instanceof DoubleValue) {
                        System.out.print(cell + "(D) ");
                    } else {
                        System.out.print(cell + "(S) ");
                    }
                }
                System.out.println();
            }


        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (CsvException ex) {
            throw new RuntimeException(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Value[][] data;



    public String getType(int row, int col) {

        Value value = data[row][col];


        if (value instanceof IntValue) {
            return "Int";
        } else if (value instanceof DoubleValue) {
            return "Double";
        } else {
            return "String";
        }

    }

}
