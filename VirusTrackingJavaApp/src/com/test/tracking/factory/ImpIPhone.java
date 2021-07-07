package com.test.tracking.factory;

import com.test.tracking.UtilFunctions;
import com.test.tracking.model.BaseCondition;
import com.test.tracking.model.Condition;
import com.test.tracking.model.Person;
import com.test.tracking.model.PhoneType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImpIPhone implements PhoneAPI {

    private List<Person> iphonePersons;

    public ImpIPhone() {
        //sample database
        // simulating we are accessing that data from iphoneAPI
        iphonePersons = new ArrayList<>();
        iphonePersons.addAll(
                Arrays.asList(
                        new Person("Ahmet",45,"Muhtarlar sokak apt 9 Istanbul",
                            Arrays.asList(
                                    new Condition(BaseCondition.Ache, UtilFunctions.getCurrentTimeAsString()),
                                    new Condition(BaseCondition.Fever, UtilFunctions.getThirtyMinutesBeforeAsString(1)),
                                    new Condition(BaseCondition.Muscle, UtilFunctions.getThirtyMinutesBeforeAsString(2)))
                        ),
                        new Person("Ayşe", 52, "Karapaşa sokak apt 7 Izmir",
                                Arrays.asList(new Condition(BaseCondition.Ache, UtilFunctions.getCurrentTimeAsString()),
                                        new Condition(BaseCondition.Fever, UtilFunctions.getThirtyMinutesBeforeAsString(4)),
                                        new Condition(BaseCondition.Muscle, UtilFunctions.getThirtyMinutesBeforeAsString(5)))
                        ),
                        new Person("Mahmut",57,"Muhtarlar sokak apt 9 Istanbul",
                                Arrays.asList(
                                        new Condition(BaseCondition.Ache, UtilFunctions.getCurrentTimeAsString()),
                                        new Condition(BaseCondition.Fever, UtilFunctions.getThirtyMinutesBeforeAsString(1)),
                                        new Condition(BaseCondition.Muscle, UtilFunctions.getThirtyMinutesBeforeAsString(2)))
                        ),
                        new Person("Ayşe", 52, "Yalın sokak apt 12 Trabzon",
                                Arrays.asList(new Condition(BaseCondition.Ache, UtilFunctions.getCurrentTimeAsString()),
                                        new Condition(BaseCondition.Fever, UtilFunctions.getThirtyMinutesBeforeAsString(4)),
                                        new Condition(BaseCondition.Muscle, UtilFunctions.getThirtyMinutesBeforeAsString(5)))
                        ),
                        new Person("Ahmet",64,"Muhtarlar sokak apt 9 Istanbul",
                                Arrays.asList(
                                        new Condition(BaseCondition.Ache, UtilFunctions.getCurrentTimeAsString()),
                                        new Condition(BaseCondition.Fever, UtilFunctions.getThirtyMinutesBeforeAsString(1)),
                                        new Condition(BaseCondition.Muscle, UtilFunctions.getThirtyMinutesBeforeAsString(2)))
                        ),
                        new Person("Karahan", 52, "Vapur sokak apt 10 Samsun",
                                Arrays.asList(new Condition(BaseCondition.Ache, UtilFunctions.getCurrentTimeAsString()),
                                        new Condition(BaseCondition.Fever, UtilFunctions.getThirtyMinutesBeforeAsString(4)),
                                        new Condition(BaseCondition.Muscle, UtilFunctions.getThirtyMinutesBeforeAsString(5)))
                        )
                )
        );
    }

    @Override
    public List<Person> read() {
        return iphonePersons;
    }

    @Override
    public void write(Person person, PhoneType phoneType) {
        if( phoneType == PhoneType.IPHONE)
            iphonePersons.add(person);
    }

    @Override
    public void write(List<Person> personList, PhoneType phoneType) {
        if( phoneType == PhoneType.IPHONE)
            iphonePersons.addAll(personList);
    }
}
