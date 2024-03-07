import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Class Represents An Agency Using The Name And Properties
 * @author Aphane Jimmy
 * version 1.0
 */
public class Agency
{
    private final String name;
    private final HashMap<String, Property> properties;

    private static final int TOTAL_VALUE = 0;

    /**
     * Agency Constructor To Create Agency Object
     * @param name The name of the agency
     */
    public Agency(final String name)
    {
        this.name = name;
        this.properties = new HashMap<>();
    }

    /**
     * Adds a property to the agency
     * @param property The property to add
     */
    public void addProperty(Property property)
    {
        if (property != null)
        {
            properties.put(property.getPropertyId(), property);
        }
    }

    /**
     * Removes a property from the agency
     * @param propertyId The ID of the property to remove
     */
    public void removeProperty(String propertyId) {
        properties.remove(propertyId);
    }

    /**
     * Calculates the total value of all properties in the agency
     * @return The total value of all properties in USD
     */
    public Property getProperty(String propertyId) {
        return properties.get(propertyId);
    }

    /**
     * Calculates the total value of all properties in the agency
     * @return The total value of all properties in USD
     */
    public double getTotalPropertyValues()
    {
        double totalValue = TOTAL_VALUE;
        for (Property property : properties.values())
        {
            totalValue += property.getPriceUsd();
        }
        return totalValue;
    }

    /**
     * Retrieves properties with swimming pools
     * @return ArrayList of properties with swimming pools, or null if none
     */
    public ArrayList<Property> getPropertiesWithPools()
    {
        ArrayList<Property> propertiesWithPools = new ArrayList<>();
        for (Property property : properties.values())
        {
            if (property.hasSwimmingPool())
            {
                propertiesWithPools.add(property);
            }
        }
        return propertiesWithPools.isEmpty() ? null : propertiesWithPools;
    }

    /**
     * Gets the name of the agency
     * @return The name of the agency
     */
    public String getName() {
        return name;
    }
}
