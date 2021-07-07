package com.test.tracking.singleton;

import com.test.tracking.composite.PhoneDirectory;
import com.test.tracking.factory.PhoneAPI;
import com.test.tracking.factory.PhoneFactory;
import com.test.tracking.iterator.person.PersonIterator;
import com.test.tracking.model.Person;
import com.test.tracking.model.PhoneType;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements PhoneAPI {
    private PhoneDirectory phoneDirectory;

    private static PersonRepository INSTANCE;

    private List<Person> personList;

    private PersonRepository() {
        phoneDirectory = PhoneDirectory.getInstance();

        personList = new ArrayList<>();

        personList.addAll(phoneDirectory.read());
    }

    public synchronized static PersonRepository getInstance() {
        if(INSTANCE == null) INSTANCE = new PersonRepository();

        return INSTANCE;
    }

    public void getFreshData() {
        personList.clear();
        personList.addAll(phoneDirectory.read());
    }

    @Override
    public List<Person> read() {
        return personList;
    }

    @Override
    public void write(Person person, PhoneType phoneType) {
        phoneDirectory.write(person, phoneType);

        personList.add(person);
    }

    @Override
    public void write(List<Person> personList, PhoneType phoneType) {
        phoneDirectory.write(personList, phoneType);

        this.personList.addAll(personList);
    }


    public List<Person> getPersonsByAge(int beginNumber, int endNumber) {
        PersonIterator personIterator = new PersonIterator(personList);

        List<Person> result = new ArrayList<>();
        while(personIterator.hasNext()) {
            Person nextPerson = personIterator.next();
            if(nextPerson.getAge() >= beginNumber && nextPerson.getAge() <= endNumber){
                result.add(nextPerson);
            }
        }
        return result;
    }
}
