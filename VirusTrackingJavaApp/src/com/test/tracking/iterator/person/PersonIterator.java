package com.test.tracking.iterator.person;

import com.test.tracking.iterator.base.Iterator;
import com.test.tracking.model.Person;

import java.util.List;

public class PersonIterator implements Iterator<Person> {
    private Person[] personList;
    private int currentPosition = 0;

    public PersonIterator(List<Person> personList) {
        this.personList = new Person[personList.size()];

        personList.toArray(this.personList);
    }

    @Override
    public boolean hasNext() {
        return currentPosition < personList.length &&
                personList[currentPosition] != null;
    }

    @Override
    public Person next() {
        return personList[currentPosition++];
    }
}
