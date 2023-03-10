package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * check if city contains a list not yet added
     * add a city to the list
     * check if our list contains the added city
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City test = new City("Estevan", "SK");
        assertFalse(list.hasCity(test));
        list.addCity(test);
        assertTrue(list.hasCity(test));
    }

    /**
     * add city to list
     * get size of list
     * delete city
     * check if our list size is one below original
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        int listSize = list.getCount();
        list.deleteCity(city);
        assertEquals(list.getCount(),listSize - 1);
    }

    /**
     * add 2 cities to list
     * check if count is 2
     * delete 2 cities from list
     * check if count is 0
     */
    @Test
    public void getCountTest() {
        list = MockCityList();
        assertEquals(list.getCount(), 0);
        City city1 = new City("Estevan", "SK");
        City city2 = new City("Esteban", "SB");
        list.addCity(city1);
        list.addCity(city2);
        assertEquals(list.getCount(), 2);
    }

}
