package com.test.tracking.observer;

import com.test.tracking.model.Person;
import com.test.tracking.model.PrintType;

import java.util.List;

public interface Observer {
    public void update(List<Person> t, List<PrintType> printTypes);
}
