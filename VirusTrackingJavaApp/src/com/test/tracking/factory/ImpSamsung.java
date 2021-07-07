package com.test.tracking.factory;

import com.test.tracking.UtilFunctions;
import com.test.tracking.model.BaseCondition;
import com.test.tracking.model.Condition;
import com.test.tracking.model.Person;
import com.test.tracking.model.PhoneType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImpSamsung implements PhoneAPI {

    private List<Person> samsungPersons;

    public ImpSamsung() {
        //sample database
        // simulating we are accessing that data from iphoneAPI
        samsungPersons = new ArrayList<>();
        samsungPersons.addAll(
                Arrays.asList(
                        new Person("Murat",55,"Karaköy sokak apt 14 Bursa",
                                Arrays.asList(
                                        new Condition(BaseCondition.Ache, UtilFunctions.getCurrentTimeAsString()),
                                        new Condition(BaseCondition.Muscle, UtilFunctions.getThirtyMinutesBeforeAsString(1)),
                                        new Condition(BaseCondition.Nose, UtilFunctions.getThirtyMinutesBeforeAsString(2)))
                        ),
                        new Person("Fikriye", 48, "Kardelen sokak apt 7 Adana",
                                Arrays.asList(new Condition(BaseCondition.Ache, UtilFunctions.getCurrentTimeAsString()),
                                        new Condition(BaseCondition.Fever, UtilFunctions.getThirtyMinutesBeforeAsString(4)),
                                        new Condition(BaseCondition.Runny, UtilFunctions.getThirtyMinutesBeforeAsString(5)))
                        ),
                        new Person("Fıkra",57,"Ölü sokak apt 14 Kartal/Istanbul",
                                Arrays.asList(
                                        new Condition(BaseCondition.Ache, UtilFunctions.getCurrentTimeAsString()),
                                        new Condition(BaseCondition.Muscle, UtilFunctions.getThirtyMinutesBeforeAsString(1)),
                                        new Condition(BaseCondition.Nose, UtilFunctions.getThirtyMinutesBeforeAsString(2)))
                        ),
                        new Person("Fikriye", 70, "Kardelen sokak apt 7 Adana",
                                Arrays.asList(new Condition(BaseCondition.Ache, UtilFunctions.getCurrentTimeAsString()),
                                        new Condition(BaseCondition.Fever, UtilFunctions.getThirtyMinutesBeforeAsString(4)),
                                        new Condition(BaseCondition.Runny, UtilFunctions.getThirtyMinutesBeforeAsString(5)))
                        ),
                        new Person("Ayşe",55,"Ağa sokak apt 14 Ağrı",
                                Arrays.asList(
                                        new Condition(BaseCondition.Ache, UtilFunctions.getCurrentTimeAsString()),
                                        new Condition(BaseCondition.Muscle, UtilFunctions.getThirtyMinutesBeforeAsString(1)),
                                        new Condition(BaseCondition.Nose, UtilFunctions.getThirtyMinutesBeforeAsString(2)))
                        ),
                        new Person("Fikriye", 70, "Kardelen sokak apt 7 Adana",
                                Arrays.asList(new Condition(BaseCondition.Ache, UtilFunctions.getCurrentTimeAsString()),
                                        new Condition(BaseCondition.Fever, UtilFunctions.getThirtyMinutesBeforeAsString(4)),
                                        new Condition(BaseCondition.Runny, UtilFunctions.getThirtyMinutesBeforeAsString(5)))
                        )
                )
        );
    }

    @Override
    public List<Person> read() {
        return samsungPersons;
    }

    @Override
    public void write(Person person, PhoneType phoneType) {
        if(phoneType == PhoneType.SAMSUNG)
            samsungPersons.add(person);
    }

    @Override
    public void write(List<Person> personList, PhoneType phoneType) {
        if(phoneType == PhoneType.SAMSUNG)
            samsungPersons.addAll(personList);
    }
}
