package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionTest {
    private final Feline feline = Mockito.mock(Feline.class);
    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLions() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void testGetKittens() throws Exception {
        int lionKittens = new Lion(sex, new Feline()).getKittens();
        assertEquals("Неверное число котят", lionKittens, 1);
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        boolean lionHasMane = new Lion(sex, new Feline()).doesHaveMane();
        assertEquals("Не совпадает", lionHasMane, hasMane);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> lionFood = new Lion(sex, new Feline()).getFood();
        assertEquals("Не совпадает список еды", lionFood, List.of("Животные", "Птицы", "Рыба"));
    }
    @Test
    public void getFoodKind() throws Exception {
        new Lion(sex, feline).getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

}
