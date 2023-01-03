package ch01;

import org.junit.jupiter.api.Test;

import static ch01.Sample.sayHello;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SampleTest {
    @Test
    void substring() {
        String str = "abcde";

        assertEquals("cd", str.substring(2, 4));
    }

    @Test
    void 헬로테스트() {
        assertThat(sayHello()).isEqualTo("hello");
    }

}