package org.example.Animals;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Hamsters extends Pets {
    public Hamsters(String name, String birthDate, ArrayList<String> commands) {
        super(name, birthDate, commands);
    }

    @Override
    protected int generateId() {
        return ThreadLocalRandom.current().nextInt(200, 300);
    }

}
