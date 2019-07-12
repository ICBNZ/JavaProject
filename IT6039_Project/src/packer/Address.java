package packer;

/**
 *
 * @author I.M.Bad
 */
public class Address {
    private String street;
    private String suburb;
    private String city;
    private String postcode;
    private Coordinates coordinates;


    /**
     * Address of the Customer or Depot
     * @param street the street
     * @param suburb the suburb
     * @param city the city
     * @param postcode the postcode
     * @param coordinates the x and y co-ordinates
     */
    public Address(String street, String suburb, String city, String postcode, Coordinates coordinates) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }


    /**
     * To String method Returns string of address
     * @return the street, suburb, city and postcode of the address
     */
    public String toString() {
        return 
                street + "\n" +
                suburb + "\n" +
                city + "\n" +
                postcode;
    }


    /**
     * Get Co-ordinates
     * @return the address coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

}
