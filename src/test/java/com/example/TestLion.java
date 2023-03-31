package com.example;

//import org.jetbrains.annotations.Contract;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestsParameters {
    Feline feline;
    private final String sex;
    private final boolean hasMane;

    public LionTestsParameters(String sex, boolean hasMane) {
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
        assertEquals("Не совпадает наличие/отсутствие гривы", lionHasMane, hasMane);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> lionFood = new Lion(sex, new Feline()).getFood();
        assertEquals("Не совпадает список еды", lionFood, List.of("Животные", "Птицы", "Рыба"));
    }
    @Test
    public void doesHaveManeTrue() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(hasMane, actualHasMane);
    }
    @Mock
    Feline mock;

    @Test(expected = Exception.class)
    public void testLionNoGetException() throws Exception{
        Lion lion = new Lion("Уточните данные", mock);
    }

}