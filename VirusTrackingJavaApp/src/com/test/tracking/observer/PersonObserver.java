package com.test.tracking.observer;

import com.sun.org.apache.xml.internal.serializer.utils.Utils;
import com.test.tracking.UtilFunctions;
import com.test.tracking.iterator.person.PersonIterator;
import com.test.tracking.model.Condition;
import com.test.tracking.model.Person;
import com.test.tracking.model.PrintType;

import java.util.List;

public class PersonObserver implements Observer {
    @Override
    public void update(List<Person> personList, List<PrintType> printTypes) {
        StringBuilder builder = new StringBuilder();

        PersonIterator personIterator = new PersonIterator(personList);
        for(PrintType printType : printTypes) {
            if(printType == PrintType.COUNT) {
                builder.append("PERSON COUNT : ").append(personList.size()).append("\n------------------------------\n");
            }
        }

        while(personIterator.hasNext()) {
            Person person = personIterator.next();
            for(PrintType printType: printTypes) {
                switch (printType) {
                    case NAME: builder.append(printType.toString()).append( " : ").append(person.getName()).append("\n"); break;
                    case ADDRESS: builder.append(printType.toString()).append( " : ").append(person.getAddress()).append("\n"); break;
                    case LAST_CONDITION: {
                        Condition latestCondition = UtilFunctions
                                .getLastConditionOfPerson(person.getConditions());
                        builder.append(printType.toString()).append( " : ").append(latestCondition.getUserCondition()).append(" --- TIME :")
                                .append(UtilFunctions
                                        .getLastConditionOfPerson(person.getConditions()) == null ? "" : UtilFunctions
                                        .getLastConditionOfPerson(person.getConditions()).getTime()).append("\n");
                    } break;
                    case ALL_CONDITION: {
                        builder.append(printType.toString()).append( " : -----\n");
                        for(Condition condition : person.getConditions()) {
                            builder.append("CONDITION : ")
                                    .append(condition.getUserCondition())
                                    .append(" --- TIME : ")
                                    .append(condition.getTime())
                                    .append("\n");
                        }
                        builder.append("----");
                    }
                }
            }
            builder.append("-------------------------\n");
        }

        System.out.println(builder.toString());
    }
}
