package com.example.fitness1;

public class ExerciseData1 {
    private String exerciseName1;
    private String additionalText1;
    private int repetitions1;

    public ExerciseData1 (String exerciseName, String additionalText, int repetitions) {
        this.exerciseName1 = exerciseName;
        this.additionalText1 = additionalText;
        this.repetitions1 = repetitions;
    }

    public String getExerciseName1() {return exerciseName1;
    }

    public void setExerciseName1(String exerciseName) {
        this.exerciseName1 = exerciseName;
    }

    public String getAdditionalText1() {
        return additionalText1;
    }

    public void setAdditionalText1(String additionalText) {this.additionalText1     = additionalText;
    }

    public int getRepetitions1() {
        return repetitions1;
    }

    public void setRepetitions1(int repetitions) {
        this.repetitions1 = repetitions;
    }

}
