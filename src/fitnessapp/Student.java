package fitnessapp;

import java.util.Arrays;

public class Student {

    private int studentID;
    private String studentName;
    private String studentSurname;
    private String birthDate;
    private int studentMembership;
    private String StudentGender;
    private int trainerID;
    private int programID;
    private int measurementID;

    public Student(int studentID, String studentName, String studentSurname, String birthDate, int studentMembership, String StudentGender, int trainerID, int programID) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.birthDate = birthDate;
        this.studentMembership = studentMembership;
        this.StudentGender = StudentGender;
        this.trainerID = trainerID;
        this.programID = programID;
        this.measurementID = 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", birthDate=" + birthDate +
                ", studentMembership=" + studentMembership +
                ", StudentGender='" + StudentGender + '\'' +
                ", trainer=" + trainerID +
                ", program=" + programID +
                ", measurements=" + measurementID +
                '}';
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getStudentMembership() {
        return studentMembership;
    }

    public void setStudentMembership(int studentMembership) {
        this.studentMembership = studentMembership;
    }

    public String getStudentGender() {
        return StudentGender;
    }

    public void setStudentGender(String studentGender) {
        this.StudentGender = studentGender;
    }

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgram(Program program) {
        this.programID = programID;
    }

    public int getMeasurementID() {
        return measurementID;
    }

    public void setMeasurementID(int measurementID) {
        this.measurementID = measurementID;
    }
}
