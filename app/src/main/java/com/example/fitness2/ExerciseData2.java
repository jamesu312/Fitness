package com.example.fitness2;

public class ExerciseData2 {
    private String exerciseName1;
    private String additionalText1;
    private int repetitions1;

    public ExerciseData2 (String exerciseName, String additionalText, int repetitions) {
        this.exerciseName1 = exerciseName;
        this.additionalText1 = additionalText;
        this.repetitions1 = repetitions;
    }

    public String getExerciseName2() {return exerciseName1;}

    public void setExerciseName2(String exerciseName) {
        this.exerciseName1 = exerciseName;
    }

    public String getAdditionalText2() {
        return additionalText1;
    }

    public void setAdditionalText2(String additionalText) {this.additionalText1     = additionalText;
    }

    public int getRepetitions2() {
        return repetitions1;
    }

    public void setRepetitions2(int repetitions) {
        this.repetitions1 = repetitions;
    }

}
