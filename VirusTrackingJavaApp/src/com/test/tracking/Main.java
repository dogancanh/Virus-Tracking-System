package com.test.tracking;

import com.test.tracking.model.PrintType;
import com.test.tracking.observer.PersonLiveData;
import com.test.tracking.observer.PersonObserver;
import com.test.tracking.singleton.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) {
        PersonLiveData personLiveData = new PersonLiveData();

        PersonObserver observer = new PersonObserver();
        personLiveData.registerObserver(observer);

        PersonRepository personRepository = PersonRepository.getInstance();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Ultimate Corona Detector");

        System.out.println("Write \"exit\" for exit the application");


        boolean isRunning = true;
        while (isRunning) {

            System.out.println("Please Enter minimum and maximum age with space ");
            System.out.println("Example \"25 60\"");
            String nextLine1 = scanner.nextLine().trim();
            String[] keys = nextLine1.split(" ");
            if(keys.length != 2) {
                System.out.println("Please enter correct format of  ages");
            } else {
                try {
                    int minimumAge = Integer.parseInt(keys[0]);
                    int maxAge = Integer.parseInt(keys[1]);
                    System.out.println("Which type info do u want to access ? \nKey numbers for informations : ");

                    System.out.format(" %s\n %s\n %s\n %s\n %s\n",
                            "Press 1 for Name",
                            "Press 2 for Address",
                            "Press 3 for count",
                            "Press 4 for latest condition info 5 for all conditions",
                            "You can combine with whitespace like : \" 1 2 3 \"\n");

                    System.out.println("Enter numbers : ");

                    String nextLine = scanner.nextLine().trim();

                    if(nextLine.toLowerCase().equals("exit")) {
                        isRunning = false;
                        continue;
                    }

                    List<PrintType> printTypes = new ArrayList<>();
                    for(String keyCode : nextLine.split(" ")) {
                        switch (keyCode.trim()) {
                            case "1" : printTypes.add(PrintType.NAME); break;
                            case "2" : printTypes.add(PrintType.ADDRESS); break;
                            case "3" : printTypes.add(PrintType.COUNT); break;
                            case "4" : printTypes.add(PrintType.LAST_CONDITION); break;
                            case "5" : printTypes.add(PrintType.ALL_CONDITION); break;
                        }
                    }

                    personLiveData.dataChanged(personRepository.getPersonsByAge(minimumAge,maxAge), printTypes);

                    System.out.println("press anything for next query , write exit for leave");
                    String next = scanner.nextLine();
                } catch (NumberFormatException ex) {
                    System.out.println("Please enter numbers !!");
                }
            }

        }

        personLiveData.unregisterObserver(observer);


    }
}
