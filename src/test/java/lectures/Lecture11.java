package lectures;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Lecture11 {

    private static final String expected = "Anna, John, Marcos, Helena, Yasmin";

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = ImmutableList.of("Anna", "John", "Marcos", "Helena", "Yasmin");
        String listOfNames = String.join(", ", names);
        System.out.println(listOfNames);

        assertThat(listOfNames).isEqualToIgnoringCase(expected);
    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = ImmutableList.of("Anna", "John", "Marcos", "Helena", "Yasmin");

        String join = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining("|"));
        System.out.println(join);

    }
}
