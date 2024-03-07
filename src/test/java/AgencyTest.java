import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class AgencyTest {
    @Test
    void testAddProperty() {
        Agency agency = new Agency("Test Agency");
        Address address = new Address("Apt 123", 456, "Main St", "12345", "City");
        Property property = new Property(100000, address, 3, true, "residence", "ABC123");
        agency.addProperty(property);
        assertEquals(property, agency.getProperty("ABC123"));
    }

    @Test
    void testRemoveProperty() {
        Agency agency = new Agency("Test Agency");
        Address address = new Address("Apt 123", 456, "Main St", "12345", "City");
        Property property = new Property(100000, address, 3, true, "residence", "ABC123");
        agency.addProperty(property);
        agency.removeProperty("ABC123");
        assertNull(agency.getProperty("ABC123"));
    }

    @Test
    void testGetTotalPropertyValues() {
        Agency agency = new Agency("Test Agency");
        Address address1 = new Address("Apt 123", 456, "Main St", "12345", "City");
        Address address2 = new Address("Apt 456", 789, "Oak St", "67890", "Town");
        Property property1 = new Property(100000, address1, 3, true, "residence", "ABC123");
        Property property2 = new Property(150000, address2, 4, false, "commercial", "DEF456");
        agency.addProperty(property1);
        agency.addProperty(property2);
        assertEquals(250000, agency.getTotalPropertyValues());
    }

    @Test
    void testGetPropertiesWithPools() {
        Agency agency = new Agency("Test Agency");
        Address address1 = new Address("Apt 123", 456, "Main St", "12345", "City");
        Address address2 = new Address("Apt 456", 789, "Oak St", "67890", "Town");
        Property property1 = new Property(100000, address1, 3, true, "residence", "ABC123");
        Property property2 = new Property(150000, address2, 4, false, "commercial", "DEF456");
        agency.addProperty(property1);
        agency.addProperty(property2);
        ArrayList<Property> propertiesWithPools = agency.getPropertiesWithPools();
        assertNotNull(propertiesWithPools);
        assertEquals(1, propertiesWithPools.size());
        assertEquals(property1, propertiesWithPools.get(0));
    }

    @Test
    void testGetPropertiesWithPools_NoPools() {
        Agency agency = new Agency("Test Agency");
        Address address1 = new Address("Apt 123", 456, "Main St", "12345", "City");
        Address address2 = new Address("Apt 456", 789, "Oak St", "67890", "Town");
        Property property1 = new Property(100000, address1, 3, false, "residence", "ABC123");
        Property property2 = new Property(150000, address2, 4, false, "commercial", "DEF456");
        agency.addProperty(property1);
        agency.addProperty(property2);
        ArrayList<Property> propertiesWithPools = agency.getPropertiesWithPools();
        assertNull(propertiesWithPools);
    }

    @Test
    void testGetName() {
        Agency agency = new Agency("Test Agency");
        assertEquals("Test Agency", agency.getName());
    }
}
