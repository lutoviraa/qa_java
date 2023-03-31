package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    Feline feline = new Feline();

    @Test
    public void eatMeatCorrectValue() throws Exception {
        Feline feline = new Feline();
        List<String> expectedMeatReturn = List.of("Животные", "Птицы", "Рыба");
        List<String> actualMeatReturn = feline.eatMeat();
        assertEquals(expectedMeatReturn, actualMeatReturn);
    }
    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensNoParameters() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensParameters() {
        assertEquals(3, feline.getKittens(3));

    }
    @Test
    public void testSexException() {
        var exception = assertThrows(Exception.class, () -> new Lion("Хищник", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
