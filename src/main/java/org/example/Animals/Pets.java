package org.example.Animals;

import java.util.ArrayList;

public abstract class Pets extends Animals {
    public Pets(String name, String birthDate, ArrayList<String> commands) {
        super(name, birthDate, commands);
    }
}
