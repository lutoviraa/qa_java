package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {
    @Mock
    Feline mock;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(mock);
        assertEquals("Звук не совпадает","Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(new Feline());
        assertEquals("Список еды не совпадает", List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}
