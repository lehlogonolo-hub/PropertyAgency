import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {
    @Test
    void testValidPropertyCreation() {
        Address address = new Address("Apt 123", 456, "Main St", "12345", "City");
        Property property = new Property(100000, address, 3, true, "residence", "ABC123");
        assertNotNull(property);
        assertEquals(100000, property.getPriceUsd());
        assertEquals(address, property.getAddress());
        assertEquals(3, property.getNumberOfBedrooms());
        assertTrue(property.hasSwimmingPool());
        assertEquals("residence", property.getType());
        assertEquals("ABC123", property.getPropertyId());
    }

    @Test
    void testInvalidPropertyCreation() {
        Address address = new Address("Apt 123", 456, "Main St", "12345", "City");
        assertThrows(IllegalArgumentException.class, () -> new Property(0, address, 3, true, "residence", "ABC123"));
        assertThrows(NullPointerException.class, () -> new Property(100000, null, 3, true, "residence", "ABC123"));
        assertThrows(IllegalArgumentException.class, () -> new Property(100000, address, 0, true, "residence", "ABC123"));
        assertThrows(IllegalArgumentException.class, () -> new Property(100000, address, 3, true, "unknown", "ABC123"));
        assertThrows(IllegalArgumentException.class, () -> new Property(100000, address, 3, true, "residence", ""));
        assertThrows(IllegalArgumentException.class, () -> new Property(100000, address, 3, true, "residence", null));
    }

    @Test
    void testSetPriceUsd() {
        Address address = new Address("Apt 123", 456, "Main St", "12345", "City");
        Property property = new Property(100000, address, 3, true, "residence", "ABC123");
        property.setPriceUsd(150000);
        assertEquals(150000, property.getPriceUsd());
        assertThrows(IllegalArgumentException.class, () -> property.setPriceUsd(0));
    }
}