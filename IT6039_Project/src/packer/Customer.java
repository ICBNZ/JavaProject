package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I.M.Bad
 */
public class Customer {

    private String name;
    private List<Address> addresses;


    /**
     * Customer
     * @param name Customer's name
     * @param address List of Customer's addresses
     */
    public Customer(String name, Address address) {

        addresses = new ArrayList<>();

        this.name = name;
        this.addresses.add(address);
    }


    /**
     * Add Address: Adds Customer addresses to list
     * @param address Customer address
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }


    /**
     * Get Name
     * @return Customer's name
     */
    public String getName() {
        return name;
    }


    /**
     * Closest Address To: Compares all Customer addresses and finds
     * the closest address to the depot
     * @param d Depot
     * @return bestAddress - Closest Customer address to depot
     */
    public Address getClosestAddressTo(Depot d) {

        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;

        for (Address a : addresses) {   // loop address list
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());

            if (distance < bestDistance) {  //compare distances
                bestAddress = a;
                bestDistance = distance;
            }
        }
        return bestAddress;
    }


    /**
     * To String: Overrides toString method to return Customer name
     * @return Customer name
     */
    public String toString() {
        return this.getName();
    }
}
