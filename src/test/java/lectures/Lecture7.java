package lectures;


import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class Lecture7 {

    private static final String GENDER = "female";
    private static final String COLOR = "yellow";

    Predicate<Car> carPredicate = car -> car.getColor().equalsIgnoreCase(COLOR);

    @Test
    public void count() throws Exception {
        Predicate<Person> personPredicate = person -> person.getGender().equalsIgnoreCase(GENDER);

        long count = MockData.getPeople().stream()
                .filter(personPredicate)
                .count();

        System.out.println("The count of females: " + count);
        assertThat(count).isEqualTo(467L);
    }

    @Test
    public void min() throws Exception {
        List<Car> cars = MockData.getCars();

        double minPrice = cars.stream()
                .filter(carPredicate)
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);

        System.out.println("The min price of " + COLOR + " cars: " + minPrice);
        assertThat(minPrice).isEqualTo(6600.59);
    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();

        double maxPrice = cars.stream()
                .filter(carPredicate)
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);

        System.out.println("The max price of " + COLOR + " cars: " + maxPrice);
        assertThat(maxPrice).isEqualTo(99677.14);
    }


    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();

        double averagePrice = cars.stream()
                .filter(carPredicate)
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println("The average price of " + COLOR + " cars: " + averagePrice);
        assertThat(averagePrice).isEqualTo(49698.7375);
    }

    @Test
    public void averageWithEmptyList() throws Exception {
        ImmutableList<Car> cars = ImmutableList.of();

        double averagePrice = cars.stream()
                .filter(carPredicate)
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println("The average price of " + COLOR + " cars: " + averagePrice);
        assertThat(averagePrice).isEqualTo(0);
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();
        double sum = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();
        BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
        System.out.println(sum);
        System.out.println(bigDecimalSum);
    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println(statistics);
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());
    }

}