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
}
