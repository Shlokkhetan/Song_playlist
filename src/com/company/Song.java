package com.company;

public class Song {
    private String Name;
    private Double Duration;

    public Song(String name, Double duration) {
        Name = name;
        Duration = duration;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getDuration() {
        return Duration;
    }

    public void setDuration(Double duration) {
        Duration = duration;
    }

    @Override
    public String toString() {
        return Name + " : " + Duration;
    }
}
