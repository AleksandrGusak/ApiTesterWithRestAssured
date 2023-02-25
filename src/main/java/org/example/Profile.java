package org.example;

public class Profile {
    private String name;
    private String about;

    public Profile (String name, String about) {
        this.name = name;
        this.about = about;
    }
    public Profile() {
    }

    public void setName () {
        this.name = name;
    }
    public String getName () {
        return name;
    }
    public void setAbout () {
        this.about = about;
    }
    public String getAbout () {
        return about;
    }

    }

