package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class ReadCSV {
    private ArrayList<Patient> patientList = new ArrayList<>();

    public void readCSV(File file) throws IOException {
        var path = Paths.get(file.getAbsolutePath());
        Stream<String> lines = Files.lines(path);
        lines.skip(1).forEach(line -> createPatient(line));
    }

    private void createPatient(String line) {
        HashMap<String, String> newPatient = new HashMap<>();
        String[] columns = line.split(",");

        newPatient.put("ID", columns[0]);
        newPatient.put("BIRTHDATE", columns[1]);
        newPatient.put("DEATHDATE", columns[2]);
        newPatient.put("SSN", columns[3]);
        newPatient.put("DRIVERS", columns[4]);
        newPatient.put("PASSPORT", columns[5]);
        newPatient.put("PREFIX", columns[6]);
        newPatient.put("FIRST", columns[7]);
        newPatient.put("LAST", columns[8]);
        newPatient.put("SUFFIX", columns[9]);
        newPatient.put("MAIDEN",columns[10]);
        newPatient.put("MARITAL", columns[11]);
        newPatient.put("RACE",columns[12]);
        newPatient.put("ETHNICITY", columns[13]);
        newPatient.put("GENDER", columns[14]);
        newPatient.put("BIRTHPLACE",columns[15]);
        newPatient.put("ADDRESS",columns[16]);
        newPatient.put("CITY",columns[17]);
        newPatient.put("STATE",columns[18]);
        if(columns.length == 20){
            newPatient.put("ZIP",columns[19]);
        }
        else{
            newPatient.put("ZIP","");
        }

        Patient patient = new Patient(newPatient);
        patientList.add(patient);
    }

    public List<Patient> getPatientList(){
        return patientList;
    }
}