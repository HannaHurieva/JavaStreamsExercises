package lectures;


import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class Lecture6 {

    final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

    @Test
    public void findAny() throws Exception {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int any = Arrays.stream(numbers)
                .filter(numbersLessThan10)
                .findAny()
                .orElse(0);

        System.out.println(any);
        //nondeterministic
        assertThat(any).isEqualTo(6);
    }

    @Test
    public void findFirst() throws Exception {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Optional<Integer> first = Arrays.stream(numbers).
                filter(numbersLessThan10)
                .findFirst();

        int result = 0;
        if (first.isPresent()) {
            result = first.get();
        }
        //deterministic
        assertThat(result).isEqualTo(6);
    }
}

