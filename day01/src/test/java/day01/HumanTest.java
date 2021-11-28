package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {


 //

    @Test
    public void createTest () {
        Human human = new Human("Tim Ball", 2000);
        assertEquals("Tim Ball", human.getName());
        assertEquals(2000, human.getYearOfBirth());
    }

    @Test
    public void invalidNameTest(){
        assertThrows(IllegalArgumentException.class, ()-> new Human("Tim", 2000));
        assertThrows(IllegalArgumentException.class, ()-> new Human("", 2000));
    }

    @Test
    public void invalidAgeTest(){
        assertThrows(IllegalArgumentException.class, ()-> new Human("Tim Ball", 1000));
        assertThrows(IllegalArgumentException.class, ()-> new Human("Tim Ball", 3000));
    }
}