package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {
    private StringProcessor processor;
    @BeforeEach
    public void setUp() {
        processor = new StringProcessor();
    }

    @Test
    void isStrongPassword() { /*here im checking possible scenarios*/
        assertTrue(processor.isStrongPassword("Password21!"), "It is a strong password"); /*everything is present*/
        assertFalse(processor.isStrongPassword(""), "Your password is empty");
        assertFalse(processor.isStrongPassword("password"), "Your password is easy to hack"); /*forgot about digits, Upper case latter, special char*/
        assertTrue(processor.isStrongPassword("PaSSWord22121$$!"), "Your password is strong");
        assertFalse(processor.isStrongPassword("123absd"), "Your password is easy to hack");/*forgot about Upper case latter, special char*/
        assertTrue(processor.isStrongPassword("myWorld901%"), "Strong password");
    }

    @Test
    void calculateDigitsTest(){ /*tests work correctly, in the last test I made a mistake on purpose, to check if everything works correctly*/
        assertEquals(2, processor.calculateDigits("45"));
        assertEquals(4, processor.calculateDigits("7384"));
        assertEquals(5, processor.calculateDigits("99997"));
        assertEquals(2, processor.calculateDigits("10"));
        assertEquals(2, processor.calculateDigits("197"));
    }

    @Test
    void calculateWords(){ /*all tests work correctly*/
        assertEquals(2, processor.calculateWords("Hello World!"));
        assertEquals(4, processor.calculateWords("Coraline in a Wonderland"));
        assertEquals(9, processor.calculateWords("My favorite book is \"The picture of Dorian Gray\" "));
        assertEquals(4, processor.calculateWords("Coraline in a Wonderland"));
        assertEquals(6, processor.calculateWords("This year i will work hard"));
        assertEquals(7, processor.calculateWords("Next summer I'm going to visit London"));
    }

}
