package packer;

/**
 *
 * @author I.M.Bad
 */
public class Product {

    private String name;
    private int weight;
    private boolean hazardous;
    private boolean fragile;

    /**
     *
     * @param name - Product name
     * @param weight - Product weight
     * @param hazardous - if Product is hazardous true or false
     * @param fragile - if Product is fragile true or false
     */
    public Product(String name, int weight, boolean hazardous, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.hazardous = hazardous;
        this.fragile = fragile;
    }

    /**
     * @return Product weight
     */
    public int getWeight() {

        return weight;
    }

    /**
     * @return Product name
     */
    public String getName() {

        return name;
    }

    /**
     * @return hazardous true or false
     */
    public boolean isHazardous() {

        return hazardous;
    }

    /**
     * @return fragile true or false
     */
    public boolean isFragile() {

        return fragile;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product)o;
        return p.getName().equals(this.getName());
    }

}
