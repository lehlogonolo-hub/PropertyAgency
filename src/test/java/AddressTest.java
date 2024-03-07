import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    @Test
    void testValidAddressCreation() {
        Address address = new Address("Apt 123", 456, "Main St", "12345", "City");
        assertNotNull(address);
        assertEquals("Apt 123", address.getUnitNumber());
        assertEquals(456, address.getStreetNumber());
        assertEquals("Main St", address.getStreetName());
        assertEquals("12345", address.getPostalCode());
        assertEquals("City", address.getCity());
    }

    @Test
    void testInvalidAddressCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Address("Apt 12345", 456, "Main St", "12345", "City"));
        assertThrows(IllegalArgumentException.class, () -> new Address("", 456, "Main St", "12345", "City"));
        assertThrows(IllegalArgumentException.class, () -> new Address(null, 456, "Main St", "12345", "City"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Apt 123", -1, "Main St", "12345", "City"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Apt 123", 456, "", "12345", "City"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Apt 123", 456, null, "12345", "City"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Apt 123", 456, "Main St", "1234", "City"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Apt 123", 456, "Main St", null, "City"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Apt 123", 456, "Main St", "12345", ""));
        assertThrows(IllegalArgumentException.class, () -> new Address("Apt 123", 456, "Main St", "12345", null));
    }

}
