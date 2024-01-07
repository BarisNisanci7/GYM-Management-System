package fitnessapp;

public class Exercise {

    private int exerciseID;
    private String exerciseName;
    private String exerciseType;
    private int sets;
    private int reps;

    public Exercise(int exerciseID, String exerciseName, String exerciseType, int sets, int reps) {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
        this.sets = sets;
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "exerciseID=" + exerciseID +
                ", exerciseName='" + exerciseName + '\'' +
                ", exerciseType='" + exerciseType + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                '}';
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
