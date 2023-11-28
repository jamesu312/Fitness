package com.example.fitness3;

public class ExerciseData3 {
    private String exerciseName1;
    private String additionalText1;
    private int repetitions1;

    public ExerciseData3 (String exerciseName, String additionalText, int repetitions) {
        this.exerciseName1 = exerciseName;
        this.additionalText1 = additionalText;
        this.repetitions1 = repetitions;
    }

    public String getExerciseName3() {return exerciseName1;}

    public void setExerciseName3(String exerciseName) {
        this.exerciseName1 = exerciseName;
    }

    public String getAdditionalText3() {
        return additionalText1;
    }

    public void setAdditionalText3(String additionalText) {this.additionalText1     = additionalText;
    }

    public int getRepetitions3() {
        return repetitions1;
    }

    public void setRepetitions3(int repetitions) {
        this.repetitions1 = repetitions;
    }

}
