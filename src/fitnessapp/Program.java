package fitnessapp;
import fitnessapp.Exercise;

import java.util.Arrays;

public class Program {

    private int programPrivateID;
    private int programID;
    private String programName;
    private int programDuration;
    private int exerciseID;

    public Program(int programPrivateID, int programId, String programName, int programDuration, int exerciseID) {
        this.programPrivateID = programPrivateID;
        this.programID = programId;
        this.programName = programName;
        this.programDuration = programDuration;
        this.exerciseID = exerciseID;
    }

    @Override
    public String toString() {
        return "Program{" +
                "programPrivateID=" + programPrivateID +
                ", programID=" + programID +
                ", programName='" + programName + '\'' +
                ", programDuration=" + programDuration +
                ", exercises=" + exerciseID +
                '}';
    }

    public int getProgramPrivateID() {
        return programPrivateID;
    }

    public void setProgramPrivateID(int programPrivateID) {
        this.programPrivateID = programPrivateID;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getProgramDuration() {
        return programDuration;
    }

    public void setProgramDuration(int programDuration) {
        this.programDuration = programDuration;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExercises(int exerciseID) {
        this.exerciseID = exerciseID;
    }
}
