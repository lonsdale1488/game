package com.company.models;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String id;
    private int highscore;
    private int gamess;
    public int getGamess() {
        return gamess;
    }


    public int getHighscore() {
        return highscore;
    }




    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public long getNumericId() {
        return Long.valueOf(id);
    }


    }

