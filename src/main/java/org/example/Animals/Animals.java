package org.example.Animals;

import java.util.ArrayList;

public abstract class Animals {
    protected final int id;
    private String name;
    private String birthDate;
    private ArrayList<String> commands;

    public Animals(int id, String name, String birthDate, ArrayList<String> commands) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public Animals(String name, String birthDate, ArrayList<String> commands) {
        this.id = generateId();
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    protected abstract int generateId();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }
}
