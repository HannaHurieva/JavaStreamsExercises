package lectures;

import beans.Person;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Lecture1 {
    private static final Integer AGE = 18;
    private static final Integer LIMIT = 10;

    @Test
    public void imperativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();
        // 1. Find people aged less or equal 18
        List<Person> youngPeople = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() <= AGE) {
                youngPeople.add(person);
            }
        }
        System.out.println("The young people from the list have an age: ");
        for (Person young : youngPeople) {
            System.out.println(young.getAge());
        }
        // 2. Then change implementation to find first 10 people
        List<Person> firstTenYoungPeople = new ArrayList<>();
        // int counter = 0;
        for (Person person : people) {
            if (person.getAge() <= AGE) {
                /*
                counter ++;
                if (counter == LIMIT) {
                    break;
                }
                */
                if (firstTenYoungPeople.size() == LIMIT) {
                    break;
                }
                firstTenYoungPeople.add(person);
            }
        }
        System.out.println("The first " + LIMIT + " young people from the list: ");
        for (Person person : firstTenYoungPeople) {
            System.out.println(person);
        }
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        ImmutableList<Person> people = MockData.getPeople();

        people.stream()
                .filter(person -> person.getAge() <= AGE)
                .limit(LIMIT)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
