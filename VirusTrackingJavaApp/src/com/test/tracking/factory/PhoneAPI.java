package com.test.tracking.factory;

import com.test.tracking.model.Person;
import com.test.tracking.model.PhoneType;

import java.util.List;

public interface PhoneAPI {
    public List<Person> read();

    public void write(Person person, PhoneType phoneType);

    public void write(List<Person> personList, PhoneType phoneType);
}
