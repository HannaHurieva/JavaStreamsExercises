package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

    final Predicate<Car> carPredicate = car -> car.getPrice() < 20000;

    @Test
    public void understandingFilter() throws Exception {
        ImmutableList<Car> cars = MockData.getCars();

        List<Car> carsFiltered = cars.stream()
                .filter(carPredicate)
                .collect(Collectors.toList());

        //carsFiltered.forEach(System.out::println);
        System.out.println(carsFiltered.size());

        assertThat(carsFiltered).hasSize(156);
    }

    @Test
    public void ourFirstMapping() throws Exception {
        // transform from one data type to another
        List<Person> people = MockData.getPeople();

        List<PersonDTO> dtos = people.stream()
                .map(person -> {
                    PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
                    return dto;
                })
                .collect(Collectors.toList());

        //dtos.forEach(System.out::println);
        System.out.println(dtos.size());

        assertThat(dtos).hasSize(1000);
    }

    @Test
    public void averageCarPrice() throws Exception {
        // calculate average of car prices

    }

    @Test
    public void test() throws Exception {

    }
}



