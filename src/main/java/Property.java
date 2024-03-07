/**
 * The Class Represents A Property,
 * The Price, Address, Number Of Bedrooms, Swimming Pool Availability,Type And PropertyId
 * @author Aphane Jimmy
 * Version 1.0
 */
class Property
{
    private double        priceUsd;
    private final Address address;
    private final int     numberOfBedrooms;
    private final boolean hasSwimmingPool;
    private final String  type;
    private final String  propertyId;

    /**
     * Property Constructor That Creates Property Object
     * @param priceUsd         The price of the property in USD
     * @param address          The address of the property
     * @param numberOfBedrooms The number of bedrooms in the property
     * @param hasSwimmingPool  Indicates if the property has a swimming pool
     * @param type             The type of the property (residence, commercial, retail)
     * @param propertyId       The unique ID of the property
     * @throws IllegalArgumentException If any parameter is invalid
     * @throws NullPointerException     If the address is null
     */

    Property(final double priceUsd,
             final Address address,
             final int numberOfBedrooms,
             final boolean hasSwimmingPool,
             final String type,
             final String propertyId)
    {
        // Parameters Validations
        if (priceUsd <= 0) {
            throw new IllegalArgumentException("Invalid price: " + priceUsd);
        }
        if (address == null) {
            throw new NullPointerException("Invalid address: null");
        }
        if (numberOfBedrooms < 1 || numberOfBedrooms > 20) {
            throw new IllegalArgumentException("Invalid number of bedrooms: " + numberOfBedrooms);
        }
        if (type == null || (!type.equalsIgnoreCase("residence") && !type.equalsIgnoreCase("commercial") && !type.equalsIgnoreCase("retail"))) {
            throw new IllegalArgumentException("Invalid property type: " + type);
        }
        if (propertyId == null || propertyId.isEmpty() || propertyId.length() > 6) {
            throw new IllegalArgumentException("Invalid property id: " + propertyId);
        }

        this.priceUsd = priceUsd;
        this.address = address;
        this.numberOfBedrooms = numberOfBedrooms;
        this.hasSwimmingPool = hasSwimmingPool;
        this.type = type.toLowerCase(); // Convert type to lowercase
        this.propertyId = propertyId;
    }

    /**
     * Gets the price of the property.
     *
     * @return The price of the property in USD.
     */
    double getPriceUsd() {
        return priceUsd;
    }

    /**
     * Gets the address of the property.
     *
     * @return The address of the property.
     */
    Address getAddress() {
        return address;
    }

    /**
     * Gets the number of bedrooms in the property.
     *
     * @return The number of bedrooms in the property.
     */
    int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    /**
     * Checks if the property has a swimming pool.
     *
     * @return true if the property has a swimming pool, false otherwise.
     */
    boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }

    /**
     * Gets the type of the property.
     *
     * @return The type of the property.
     */
    String getType() {
        return type;
    }

    /**
     * Gets the property ID.
     *
     * @return The property ID.
     */
    String getPropertyId() {
        return propertyId;
    }

    /**
     * Sets the price of the property.
     *
     * @param priceUsd The new price of the property in USD.
     * @throws IllegalArgumentException If the price is not positive.
     */
    void setPriceUsd(double priceUsd) {
        if (priceUsd <= 0) {
            throw new IllegalArgumentException("Invalid price: " + priceUsd);
        }
        this.priceUsd = priceUsd;
    }
}