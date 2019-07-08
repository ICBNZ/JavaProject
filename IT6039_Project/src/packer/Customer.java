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

    // Customer name, address/addresses
    public Customer(String name, Address address) {

        addresses = new ArrayList<>();

        this.name = name;
        this.addresses.add(address);
    }

    // Add addresses to address list
    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    // name
    public String getName() {
        return name;
    }

    // Get closest address to depot
    public Address getClosestAddressTo(Depot d) {

        //System.out.println("\nDepot:" + d );

        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;

        // loop address list
        for (Address a : addresses) {

            // companyDistanceTo - co-ordinates method
            // for each address: get co-ordinates, get distance to depot
            //(Address.getCo).companyDistanceTo(depot co-ordinates)
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());
            //System.out.println("\nAddress distance:" + distance);

            //compare distances
            if (distance < bestDistance) {

                bestAddress = a;
                bestDistance = distance;
                //System.out.println("Best Distance:\n" + bestAddress + "Best d:\n" + bestDistance);
            }
        }

        //System.out.println("\nBEST:" + bestAddress);
        return bestAddress;
    }

    public String toString() {
        return this.getName();
    }
}
