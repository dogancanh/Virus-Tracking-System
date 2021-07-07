package com.test.tracking.observer;

import com.test.tracking.model.Person;
import com.test.tracking.model.PrintType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonLiveData implements Subject {
    List<Person> personList;
    List<PrintType>printTypes;
    private ArrayList<Observer> observers;

    public PersonLiveData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Iterator<Observer> it =
             observers.iterator(); it.hasNext();)
        {
            Observer o = it.next();
            o.update(personList, printTypes);
        }
    }

    public void dataChanged(List<Person> personList, List<PrintType> printTypes) {
        this.personList = personList;
        this.printTypes = printTypes;

        notifyObservers();
    }
}
