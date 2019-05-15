package uk.ac.ucl.model;
import java.util.HashMap;

public class Patient
{
    private HashMap<String, String> patientMap;
    public Patient(HashMap<String, String> patientMap)
    {
        this.patientMap = patientMap;
    }

    public String getName(){return getFirst() + ", " + getLast(); }

    public String getID(){
        return patientMap.get("ID");
    }

    public String getFirst() { return patientMap.get("FIRST");}

    public String getBirthdate(){ return patientMap.get("BIRTHDATE");}

    public String getDeathdate(){ return patientMap.get("DEATHDATE");}

    public String getSSN(){return patientMap.get("SSN");}

    public String getDrivers(){ return  patientMap.get("DRIVERS");}

    public String getPassport(){ return  patientMap.get("PASSPORT");}

    public String getPrefix(){ return patientMap.get("PREFIX");}

    public String getLast(){ return patientMap.get("LAST");}

    public String getSuffix(){ return patientMap.get("SUFFIX");}

    public String getMaiden(){ return patientMap.get("MAIDEN");}

    public String getMarital(){ return patientMap.get("MARITAL");}

    public String getRace(){ return patientMap.get("RACE");}

    public String getEthnicity(){ return patientMap.get("ETHNICITY");}

    public String getGender(){ return patientMap.get("GENDER");}

    public String getBirthplace(){ return patientMap.get("BIRTHPLACE");}

    public String getAddress(){ return patientMap.get("ADDRESS");}

    public String getCity(){ return patientMap.get("CITY");}

    public String getState(){ return patientMap.get("STATE");}

    public String getZip(){ return  patientMap.get("ZIP");}

    public int getAge(){
        String date = getBirthdate();
        String deathdate = getDeathdate();
        String birthString = date.split("-")[0];
        int birthYear = Integer.parseInt(birthString);
        if(getDeathdate().compareTo("")!=0)
        {
            int deathYear = Integer.parseInt(deathdate.split("-")[0]);
            return deathYear - birthYear;
        }
        return 2019 - birthYear;
    }

    public void setID(String ID){
        patientMap.put("ID", ID);
    }

}
