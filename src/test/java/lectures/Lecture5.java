package lectures;


import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

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

        Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(),
                person.getFirstName(), person.getAge());

        List<PersonDTO> dtos = people.stream()
                .map(PersonDTO::map)
                //.map(personPersonDTOFunction)
                .collect(Collectors.toList());

        //dtos.forEach(System.out::println);
        System.out.println(dtos.size());

        assertThat(dtos).hasSize(1000);
    }

    @Test
    public void averageCarPrice() throws Exception {
        // calculate average of car prices
        double averagePrice = MockData.getCars().stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println("Average price of cars: " + averagePrice);
        assertThat(averagePrice).isEqualTo(52693.19979);
    }

    @Test
    public void test() throws Exception {
        List<Double> prices = MockData.getCars().stream()
                .map(Car::getPrice)
                .collect(Collectors.toList());

        double sum = prices.stream().mapToDouble(price -> price).sum();
        double average = sum / prices.size();

        assertThat(average).isEqualTo(52693.19979);
    }
}



