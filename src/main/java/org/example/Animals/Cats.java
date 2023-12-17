package org.example.Animals;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Cats extends Pets {

    public Cats(String name, String birthDate, ArrayList<String> commands) {
        super(name, birthDate, commands);
    }

    @Override
    public int generateId() {
        return ThreadLocalRandom.current().nextInt(100, 200);
    }

}
