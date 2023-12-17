package org.example.Animals;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Camels extends PackAnimals {
    public Camels(String name, String birthDate, ArrayList<String> commands) {
        super(name, birthDate, commands);
    }

    @Override
    protected int generateId() {
        return ThreadLocalRandom.current().nextInt(500, 600);
    }

}
