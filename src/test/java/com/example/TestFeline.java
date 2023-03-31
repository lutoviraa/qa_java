package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTests {
    Feline feline = new Feline();

    @Test
    public void testGetFoodMeat() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.getFood("Хищник"));
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
}
