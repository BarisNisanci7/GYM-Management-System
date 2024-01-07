package fitnessapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private int trainerID;
    private String trainerName;
    private String trainerSurname;
    private String trainerGender;
    private String trainerExpertise;

    public Trainer(int trainerID, String trainerName, String trainerSurname, String trainerGender, String trainerExpertise) {
        this.trainerID = trainerID;
        this.trainerName = trainerName;
        this.trainerSurname = trainerSurname;
        this.trainerGender = trainerGender;
        this.trainerExpertise = trainerExpertise;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerID=" + trainerID +
                ", trainerName='" + trainerName + '\'' +
                ", trainerSurname='" + trainerSurname + '\'' +
                ", trainerGender='" + trainerGender + '\'' +
                ", trainerExpertise='" + trainerExpertise + '\'' +
                '}';
    }

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerSurname() {
        return trainerSurname;
    }

    public void setTrainerSurname(String trainerSurname) {
        this.trainerSurname = trainerSurname;
    }

    public String getTrainerGender() {
        return trainerGender;
    }

    public void setTrainerGender(String trainerGender) {
        this.trainerGender = trainerGender;
    }

    public String getTrainerExpertise() {
        return trainerExpertise;
    }

    public void setTrainerExpertise(String trainerExpertise) {
        this.trainerExpertise = trainerExpertise;
    }
    

}
