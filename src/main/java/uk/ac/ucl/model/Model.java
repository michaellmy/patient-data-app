package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model
{
  private ReadCSV reader = new ReadCSV();
  private List<Patient> patientList = new ArrayList<>();

  public List<Patient> getPatients(){
    return patientList;
  }

  public void readFile(File file)
  {
    try{
      patientList.clear();
      reader.readCSV(file);
      patientList = reader.getPatientList();
    } catch (IOException e){
      System.out.println("Unable to read file. File not found. Ensure that it is in the 'data' folder.");
    }
  }

  public String getFirst(Patient patient){
    return patient.getFirst();
  }

  public String getLast(Patient patient){ return patient.getLast();}

  private String getName(Patient patient){ return patient.getName(); }

  public String getID(Patient patient){return patient.getID();}

  private String getGender(Patient patient){ return patient.getGender();}

  private int getAge(Patient patient) { return patient.getAge();}

  private String getBirthdate(Patient patient) { return patient.getBirthdate();}

  private String getDeathdate(Patient patient){return patient.getDeathdate();}

  private String getSSN(Patient patient){return patient.getSSN();}

  private String getDrivers(Patient patient){return patient.getDrivers();}

  private String getPassport(Patient patient){return patient.getPassport();}

  private String getPrefix(Patient patient){return patient.getPrefix();}

  private String getSuffix(Patient patient){return patient.getSSN();}

  private String getMaiden(Patient patient){return patient.getMaiden();}

  private String getMarital(Patient patient){return patient.getMarital();}

  private String getRace(Patient patient){return patient.getRace();}

  private String getEthnicity(Patient patient){return patient.getEthnicity();}

  private String getBirthplace(Patient patient){return patient.getBirthplace();}

  private String getAddress(Patient patient){return patient.getAddress();}

  private String getCity(Patient patient) {return patient.getCity();}

  private String getState(Patient patient){return patient.getState();}

  private String getZip(Patient patient){return patient.getZip();}

  public List<String> getSingleInfo(String Id)
  {
    List<String> info = new ArrayList<>();
    for(Patient patient: patientList)
    {
      if(getID(patient).compareTo(Id) == 0)
      {
        info.add("ID: " + getID(patient));
        info.add("First Name: " + getFirst(patient).replaceAll("\\d", ""));
        info.add("Last Name: " + getLast(patient).replaceAll("\\d", ""));
        info.add("Birthdate: " + getBirthdate(patient));
        info.add("Deathdate: " + getDeathdate(patient));
        info.add("SSN:" + getSSN(patient));
        info.add("Drivers: " + getDrivers(patient));
        info.add("Passport: " + getPassport(patient));
        info.add("Prefix: " + getPrefix(patient));
        info.add("Suffix: " + getSuffix(patient));
        info.add("Maiden: " + getMaiden(patient));
        info.add("Marital: " + getMarital(patient));
        info.add("Race: " + getRace(patient));
        info.add("Ethnicity: " + getEthnicity(patient));
        info.add("Gender: " + getGender(patient));
        info.add("Birthplace: " + getBirthplace(patient));
        info.add("Address: " + getAddress(patient));
        info.add("City: " + getCity(patient));
        info.add("State: " + getState(patient));
        info.add("Zip: " + getZip(patient));
      }
    }
    return info;
  }

  public List<Patient> searchForAny(String keyword, String type) {
    List<Patient> patients = new ArrayList<>();
    if(keyword == null){ return patients;}
    if (keyword.compareTo("") != 0) {
      matchCategories(patients, type, keyword);
    }
    return patients;
  }

  public List<Patient> searchMultiple(String firsttype, String secondtype, String firstkey, String secondkey){
    List<Patient> finalList = new ArrayList<>();
    if(firstkey == null || secondkey == null){
      return finalList;
    }
    List<Patient> firstList = new ArrayList<>();
    List<Patient> secondList = new ArrayList<>();
    if (firstkey.compareTo("") != 0 && secondkey.compareTo("") != 0)
    {
      matchCategories(firstList, firsttype, firstkey);
      matchCategories(secondList, secondtype, secondkey);
    }
    for(Patient patient : firstList)
    {
      if(secondList.contains(patient))
      {
        finalList.add(patient);
      }
    }
    return finalList;
  }

  public List<Patient> searchForAge(String minimum, String maximum)
  {
    List<Patient> patients = new ArrayList<>();
    try {
      int minAge = Integer.parseInt(minimum);
      int maxAge = Integer.parseInt(maximum);
      for (Patient patient : patientList) {
        if (getAge(patient) >= minAge && getAge(patient) <= maxAge) {
          patients.add(patient);
        }
      }
    } catch (NumberFormatException e)
    {
      // Un-required as final list can be empty; just to catch poor input values.
    }
    return patients;
  }

  public List<Patient> searchForAlphabet(String firstAlph)
  {
    List<Patient> patients = new ArrayList<>();
    if(firstAlph == null){return patients;}
    for (Patient patient : patientList) {
      if (getName(patient).startsWith(firstAlph)) {
        patients.add(patient);
      }
    }
    return patients;
  }

  private void matchCategories(List<Patient> patients, String type, String keyword){
    for (Patient patient : patientList) {
      if (type.compareTo("id") == 0 && getID(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("birthdate") == 0 && getBirthdate(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("deathdate") == 0 && getDeathdate(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("ssn") == 0 && getSSN(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("drivers") == 0 && getDrivers(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("passport") == 0 && getPassport(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("prefix") == 0 &&
              (getPrefix(patient).replaceAll("\\.", "").toLowerCase()).compareTo(keyword.toLowerCase()) == 0) {
        patients.add(patient);
      }
      if (type.compareTo("name") == 0 && getName(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("suffix") == 0 && getSuffix(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("maiden") == 0 && getMaiden(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("marital") == 0 && getMarital(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("race") == 0 && getRace(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("ethnicity") == 0 && getEthnicity(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("gender") == 0 && getGender(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("birthplace") == 0 && getBirthplace(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("address") == 0 && getAddress(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("city") == 0 && getCity(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("state") == 0 && getState(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
      if (type.compareTo("zip") == 0 && getZip(patient).toLowerCase().contains(keyword.toLowerCase())) {
        patients.add(patient);
      }
    }
  }

  public String getAverageAge(List<Patient> patients)
  {
    if(patients.size() == 0 ){ return "0";}
    int count = 0;
    int totalAges = 0;
    for (Patient patient: patients)
    {
      totalAges += getAge(patient);
      count ++;
    }
    return Integer.toString(totalAges / count);
  }

  public String getYoungest(List<Patient> patients)
  {
    if(patients.size() == 0 ){ return "0";}
    int youngest;
    youngest = getAge(patients.get(0));
    for(Patient patient: patients) {
      if(getAge(patient)<youngest) {
        youngest = getAge(patient);
      }
    }
    return Integer.toString(youngest);
  }

  public String getOldest(List<Patient> patients)
  {
    if(patients.size() == 0 ){ return "0";}
    int oldest;
    oldest = getAge(patients.get(0));
    for(Patient patient: patients) {
      if(getAge(patient)> oldest) {
        oldest = getAge(patient);
      }
    }
    return Integer.toString(oldest);
  }

  public String getMales(List<Patient> patients)
  {
    int count = 0;
    for(Patient patient : patients){
      if(getGender(patient).compareTo("M") == 0){
        count++;
      }
    }
    return Integer.toString(count);
  }

  public String getFemales(List<Patient> patients)
  {
    int count = 0;
    for(Patient patient : patients){
      if(getGender(patient).compareTo("F") == 0){
        count++;
      }
    }
    return Integer.toString(count);
  }

  private String getChildren()
  {
    int count = 0;
    for(Patient patient : getPatients())
    {
      if(getAge(patient) < 21)
      {
        count++;
      }
    }
    return Integer.toString(count);
  }

  private String getMiddleAge()
  {
    int count = 0;
    for(Patient patient : getPatients())
    {
      if(getAge(patient) >= 21 && getAge(patient) <= 65)
      {
        count++;
      }
    }
    return Integer.toString(count);
  }

  private String getOldAge()
  {
    int count = 0;
    for(Patient patient : getPatients())
    {
      if(getAge(patient) > 65)
      {
        count++;
      }
    }
    return Integer.toString(count);
  }

  private String countDeath()
  {
    int count = 0;
    for(Patient patient: getPatients())
    {
      if(getDeathdate(patient).compareTo("") != 0)
      {
        count++;
      }
    }
    return Integer.toString(count);
  }

  private String countPatients(){ return Integer.toString(getPatients().size()); }

  public List<String> getAllStats()
  {
    List<String> statList = new ArrayList<>();
    statList.add("Total number of patients: " + countPatients());
    statList.add("Average Age of Patients: " + getAverageAge(getPatients()) + " years");
    statList.add("Number of male patients: " + getMales(getPatients()) + " patients");
    statList.add("Number of female patients: " + getFemales(getPatients()) + " patients");
    statList.add("Age range: " + getYoungest(getPatients()) + " - " + getOldest(getPatients()) + " Years Old");
    statList.add("Patients under 18 years: " + getChildren() + " patients");
    statList.add("Patients 18 to 65 years: " + getMiddleAge() + " patients");
    statList.add("Patients over 65 years: " + getOldAge() + " patients");
    statList.add("Number of deaths recorded: " + countDeath() + " patients");
    return statList;
  }
}
