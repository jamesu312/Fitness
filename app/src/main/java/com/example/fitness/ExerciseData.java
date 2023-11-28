package com.example.fitness;

public class ExerciseData {
    private String exerciseName;
    private String additionalText;
    private int repetitions;

    public ExerciseData(String exerciseName, String additionalText, int repetitions) {
        this.exerciseName = exerciseName;
        this.additionalText = additionalText;
        this.repetitions = repetitions;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getAdditionalText() {
        return additionalText;
    }

    public void setAdditionalText(String additionalText) {
        this.additionalText = additionalText;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

}
