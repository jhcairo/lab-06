package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class,()->{
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This lines checks if the first city in the cityList (retrieved by cityList.getCities().get(0) )
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = mockCity();
        // Test if mock city is in the list
        assertTrue(cityList.hasCity(city));

        // Test if hasCity() returns false if a city doesn't exist
        City newCity = new City("Vancouver", "British Columbia");
        assertFalse(cityList.hasCity(newCity));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = mockCity();
        // Tests if the city is in the list
        assertEquals(1, cityList.getCities().size());
        assertTrue(cityList.hasCity(city));
        // Delete city
        cityList.delete(city);
        // Tests if the city is removed from the list
        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        // Tests if exception is thrown when tried to delete a city that doesn't exist
        assertThrows(IllegalArgumentException.class, ()-> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        // Test if the list is empty
        assertEquals(0, cityList.countCities());
        // add a city and test
        cityList.add(mockCity());
        assertEquals(1, cityList.countCities());
        // add another city and test
        City city2 = new City("Toronto", "Ontario");
        cityList.add(city2);
        assertEquals(2, cityList.countCities());
        // delete city and test
        cityList.delete(city2);
        assertEquals(1, cityList.countCities());
    }

}
