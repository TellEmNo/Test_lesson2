package org.example;

import org.example.Animals.Animals;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Zoo {
    private ArrayList<Animals> zooList = new ArrayList<Animals>();

//    public void addAnimal(Animals animal) {
//        zooList.add(animal);
//    }

//    public void printAnimals() {
//        try (FileReader reader = new FileReader("Animals.txt")) {
//            int c;
//            while ((c = reader.read()) != -1) {
//                System.out.print((char) c);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void printAnimals2() {
        ArrayList<String> AnimalList = new ArrayList<String>();
        try (Scanner scanner = new Scanner(new File("Animals.txt")).useDelimiter("\\A")) {
            while (scanner.hasNext()) {
                AnimalList.add(scanner.next());
            }
            for (String an : AnimalList) {
                System.out.println(an);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void recordAnimal(ArrayList<Animals> zooList) throws IOException {
        FileWriter writer = new FileWriter("Animals.txt", true);
        for (Animals an : zooList) {
            writer.write("ID: " + an.getId() + ", кличка: " + an.getName() + ", дата рождения: " + an.getBirthDate() + ", команды: " + an.getCommands() + ", вид: " + an.getClass().getSimpleName() + "\n");
        }
        writer.flush();
        writer.close();
    }

    public String SearchForAnimalInfo(String str) {
        String line = null;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("Animals.txt"))) {
            while ((line = reader.readLine()) != null) {
                if (line.contains(str)) {
                    //System.out.printf("Found string: %s%n", line);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    // Решил сделать таким способом, чтобы можно было редактировать информацию о любом животном даже после перезапуска программы, если затупил и сделал не так, как нужно, извиняюсь, по-другому не сообразил
    public ArrayList<String> FromFileToList() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("Animals.txt"))){
            ArrayList<String> lines = new ArrayList<>();
            String line;
            int i = 1;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            for (String ln: lines) {
                System.out.println(i+": " + ln);
                i++;
            }
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void FromListToFile(ArrayList<String> lines, String changedLine, int pos) throws IOException {
        lines.set(pos-1, changedLine);
        for (String ln: lines) {
            System.out.println(ln);
        }
        FileWriter writer = new FileWriter("Animals.txt");
        for (String ln : lines) {
            writer.write(ln + "\n");
        }
        writer.flush();
        writer.close();
    }
}

