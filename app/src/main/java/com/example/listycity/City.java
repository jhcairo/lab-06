package com.example.listycity;

/**
* This is a class that defines a City.
*/
public class City implements Comparable{
    private String city;
    private String province;

    /**
     * Constructor for City
     * @param city
     *      The name of the city
     * @param province
     *      The name of the province the city is located
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name
     * @return
     *      The name of the city
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Gets the province name
     * @return
     *      The name of the province
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this city to another city
     * @param o
     *      The city to compare to
     * @return
     *      Negative if this city comes before, positive if after, 0 if equal
     */
    @Override
    public int compareTo(Object o) {
        // typecasting
        City c = (City) o;
        return this.city.compareTo(c.getCityName());    // this.city refers to the city name
    }

    /**
     * Checks if this city is equal to another object
     * @param obj
     *      The object to compare with
     * @return
     *      True if cities have the same name and province, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City other = (City) obj;
        return this.city.equals(other.city) && this.province.equals(other.province);
    }

    /**
     * Generates a hash code for this city
     * @return
     *      Hash code based on city name and province
     */
    @Override
    public int hashCode() {
        return city.hashCode() + province.hashCode();
    }
}


