package com.test.tracking.composite;

import com.test.tracking.factory.PhoneAPI;
import com.test.tracking.factory.PhoneFactory;
import com.test.tracking.model.Person;
import com.test.tracking.model.PhoneType;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton Yapıda içeriyor
 *
 */
public class PhoneDirectory implements PhoneAPI {
    private List<PhoneAPI> phoneAPIS = new ArrayList<>();

    private static PhoneDirectory INSTANCE;


    public PhoneDirectory() {
        PhoneFactory phoneFactory = new PhoneFactory();
        phoneAPIS.add(phoneFactory.getPhoneAPI(PhoneType.IPHONE));
        phoneAPIS.add(phoneFactory.getPhoneAPI(PhoneType.SAMSUNG));
    }

    public synchronized static PhoneDirectory getInstance() {
        if(INSTANCE == null) INSTANCE = new PhoneDirectory();

        return INSTANCE;
    }


    public void addPhoneAPI(PhoneAPI phoneAPI) {
        phoneAPIS.add(phoneAPI);
    }

    public void removePhoneAPI(PhoneAPI phoneAPI) {
        phoneAPIS.remove(phoneAPI);
    }

    @Override
    public List<Person> read() {
        List<Person> persons = new ArrayList<>();
        for(PhoneAPI phoneAPI: phoneAPIS) {
            persons.addAll(phoneAPI.read());
        }
        return persons;
    }

    @Override
    public void write(Person person, PhoneType phoneType) {
        for(PhoneAPI phoneAPI: phoneAPIS) {
            phoneAPI.write(person, phoneType);
        }
    }

    @Override
    public void write(List<Person> personList, PhoneType phoneType) {
        for(PhoneAPI phoneAPI: phoneAPIS) {
            phoneAPI.write(personList, phoneType);
        }
    }
}
