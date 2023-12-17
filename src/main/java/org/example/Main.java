package org.example;

import org.example.Animals.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Zoo zooList = new Zoo();
        ArrayList<Animals> addAnimals = new ArrayList<Animals>();
        ArrayList<Animals> animals = new ArrayList<Animals>();
        Scanner in = new Scanner(System.in);
//        System.out.println("Введите имя и дату рождения зверька в формате ДД.ММ.ГГГГ:");
//
//        Cats cat = new Cats(in.next(), in.next());
//        System.out.println("Cat ID: " + cat.getId() + " Cat name: " + cat.getName() + " Cat birth date: " + cat.getBirthDate());

        while (true) {
            System.out.println(View.mainMenu(Text.mainMenu));
            int choice = in.nextInt();
            if (choice <= 0 | choice > 5)
                break;
            switch (choice) {
                case 1 -> {
                    System.out.println(View.chooseAnimalType(Text.chooseAnimalType));
                    int choice2 = in.nextInt();
                    switch (choice2) {
                        case 1 -> {
                            System.out.println(View.enterSomething(Text.enterTheName));
                            String name = in.next();
                            System.out.println(View.enterSomething(Text.enterBirthDate));
                            String birthDate = in.next();
                            System.out.println(View.enterSomething(Text.enterPetComm));
                            System.out.println(View.warning(Text.stop));
                            ArrayList<String> commands = new ArrayList<>();
                            while (true) {
                                String str = in.next();
                                if (str.equals("exit"))
                                    break;
                                commands.add(str);
                            }
                            addAnimals.add(new Dogs(name, birthDate, commands));
                            animals.add(new Dogs(name, birthDate, commands));
                        }
                        case 2 -> {
                            System.out.println(View.enterSomething(Text.enterTheName));
                            String name2 = in.next();
                            System.out.println(View.enterSomething(Text.enterBirthDate));
                            String birthDate2 = in.next();
                            System.out.println(View.enterSomething(Text.enterPetComm));
                            System.out.println(View.warning(Text.stop));
                            ArrayList<String> commands2 = new ArrayList<>();
                            while (true) {
                                String str = in.next();
                                if (str.equals("exit"))
                                    break;
                                commands2.add(str);
                            }
                            addAnimals.add(new Cats(name2, birthDate2, commands2));
                            animals.add(new Cats(name2, birthDate2, commands2));
                        }
                        case 3 -> {
                            System.out.println(View.enterSomething(Text.enterTheName));
                            String name3 = in.next();
                            System.out.println(View.enterSomething(Text.enterBirthDate));
                            String birthDate3 = in.next();
                            System.out.println(View.enterSomething(Text.enterPetComm));
                            System.out.println(View.warning(Text.stop));
                            ArrayList<String> commands3 = new ArrayList<>();
                            while (true) {
                                String str = in.next();
                                if (str.equals("exit"))
                                    break;
                                commands3.add(str);
                            }
                            addAnimals.add(new Hamsters(name3, birthDate3, commands3));
                            animals.add(new Hamsters(name3, birthDate3, commands3));
                        }
                        case 4 -> {
                            System.out.println(View.enterSomething(Text.enterTheName));
                            String name4 = in.next();
                            System.out.println(View.enterSomething(Text.enterBirthDate));
                            String birthDate4 = in.next();
                            System.out.println(View.enterSomething(Text.enterPetComm));
                            System.out.println(View.warning(Text.stop));
                            ArrayList<String> commands4 = new ArrayList<>();
                            while (true) {
                                String str = in.next();
                                if (str.equals("exit"))
                                    break;
                                commands4.add(str);
                            }
                            addAnimals.add(new Dogs(name4, birthDate4, commands4));
                            animals.add(new Horses(name4, birthDate4, commands4));
                        }
                        case 5 -> {
                            System.out.println(View.enterSomething(Text.enterTheName));
                            String name5 = in.next();
                            System.out.println(View.enterSomething(Text.enterBirthDate));
                            String birthDate5 = in.next();
                            System.out.println(View.enterSomething(Text.enterPetComm));
                            System.out.println(View.warning(Text.stop));
                            ArrayList<String> commands5 = new ArrayList<>();
                            while (true) {
                                String str = in.next();
                                if (str.equals("exit"))
                                    break;
                                commands5.add(str);
                            }
                            addAnimals.add(new Donkeys(name5, birthDate5, commands5));
                            animals.add(new Donkeys(name5, birthDate5, commands5));
                        }
                        case 6 -> {
                            System.out.println(View.enterSomething(Text.enterTheName));
                            String name6 = in.next();
                            System.out.println(View.enterSomething(Text.enterBirthDate));
                            String birthDate6 = in.next();
                            System.out.println(View.enterSomething(Text.enterPetComm));
                            System.out.println(View.warning(Text.stop));
                            ArrayList<String> commands6 = new ArrayList<>();
                            while (true) {
                                String str = in.next();
                                if (str.equals("exit"))
                                    break;
                                commands6.add(str);
                            }
                            addAnimals.add(new Camels(name6, birthDate6, commands6));
                            animals.add(new Camels(name6, birthDate6, commands6));
                        }
                        default -> {
                            return;
                        }
                    }
                }
                case 2 -> {
                    try {
                        zooList.recordAnimal(addAnimals);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    addAnimals.remove(0);
                }
                case 3 -> zooList.printAnimals2();
                case 4 -> {
                    System.out.println(View.warning(Text.SearchInfo));
                    String search = in.next();
                    zooList.SearchForAnimalInfo(search);
                }
                case 5 -> {
                    System.out.println(View.warning(Text.ModifyAnimalInformation));
                    String change = in.next();
                    zooList.SearchForAnimalInfo(change); // чтобы скопировать нужную инфу, а не писать строку целиком на память
                }
//                    zooList.ModifyAnimalInformation2(change, Text.NewInfo, Text.msg);
                default -> {
                }
            }
        }
    }
}
//ID: 39, кличка: Goofy, дата рождения: 12.04.2017, команды: [sit], вид: Dogs
//ID: 27, кличка: Snoop, дата рождения: 23.01.2020, команды: [sit, lie], вид: Dogs