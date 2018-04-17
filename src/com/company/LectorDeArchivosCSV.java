
package com.company;


import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectorDeArchivosCSV {
    private List<Alumno> listaAlumnos;

    public LectorDeArchivosCSV() {
        listaAlumnos = new ArrayList<>();
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void leerCsv() {
        CSVReader csvReader = null;

        try {
            /**
             * Reading the CSV File
             * Delimiter is comma
             * Start reading from line 1
             */
            csvReader = new CSVReader(new FileReader("listadoDeAlumnos.csv"), ',', '"', 1);
            //alumnoDetails stores the values current line
            String[] alumnoDetails = null;
            //List for holding all the rows
            List<String[]> rows = new ArrayList<String[]>();
            rows = csvReader.readAll();
            //Read individual row from List of rows
            for (String[] row : rows) {

                Alumno unalu = new Alumno(row);
                listaAlumnos.add(unalu);


            }

        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                //closing the reader
                csvReader.close();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }

    }
}