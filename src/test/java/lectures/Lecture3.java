package lectures;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

public class Lecture3 {

    @Test
    public void min() throws Exception {
        final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

        System.out.println("The minimum is: " + numbers.stream().min(Integer::compareTo).orElse(0));
    }

    @Test
    public void max() throws Exception {
        final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

        System.out.println("The maximum is: " + numbers.stream().max(Integer::compareTo).orElse(0));
    }
}
