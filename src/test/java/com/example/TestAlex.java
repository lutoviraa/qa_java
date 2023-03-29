package com.example;

import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AlexTests {
    Alex alex;

    {
        try {
            alex = new Alex(new Feline());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public AlexTests() {
    }

    @Test
    public void testGetFriends() {
        assertEquals("Другие", List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман")
                , alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLiving() {
        assertEquals("Другой зоопарк", "Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }
    @Test
    public void testGetKittens() {
        assertEquals("Другое количество", 0, alex.getKittens());
    }
}
