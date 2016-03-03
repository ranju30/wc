import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WcTest {
    String hello = "Hello World";
    String sample = "I am going to implement wc using java. " +
            "\n" + "So,I am going to use this text file for test.";

    @Test
    public void count_number_of_words_for_empty_string() {
        Wc wc = new Wc();
        assertEquals(0, wc.countWords(" "));
    }

    @Test
    public void count_number_of_words() {
        Wc wc = new Wc();
        assertEquals(2, wc.countWords(hello));
    }

    @Test
    public void count_number_of_words_for_one_word() {
        Wc wc = new Wc();
        assertEquals(18, wc.countWords(sample));
    }


    @Test
    public void count_number_of_lines_for_Hello() {
        Wc wc = new Wc();
        assertEquals(1, wc.countLines(hello));
    }


    @Test
    public void count_number_of_lines_for_Sample() {
        Wc wc = new Wc();
        assertEquals(2, wc.countLines(sample));
    }

    @Test
    public void count_bytes_of_hello() {
        Wc wc = new Wc();
        assertEquals(11, wc.countBytes(hello));
    }

    @Test
    public void count_bytes_of_sample_text() {
        Wc wc = new Wc();
        assertEquals(85, wc.countBytes(sample));
    }

    @Test
    public void count_all_if_only_file_name_is_given() {
        Wc wc = new Wc();
        assertEquals("	2	18	85", wc.countAll(sample));
    }

}
