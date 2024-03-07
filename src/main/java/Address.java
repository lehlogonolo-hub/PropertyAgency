/**
 *This Class Represents An Address Of The Properties
 * @author Aphane Jimmy
 * version 1.0
 */


public class Address
{
    private final String unitNumber;
    private final int    streetNumber;
    private final String streetName;
    private final String postalCode;
    private final String city;

    private static final int MIN_STREET_NUMBER =  1;
    private static final int MAX_STREET_NUMBER =  999999;
    private static final int STREET_NAME_LENGTH = 50;
    private static final int CITY_LENGTH =        50;
    private static final int MIN_POSTAL_LENGTH =  5;
    private static final int MAX_POSTAL_LENGTH =  6;
    private static final int MAX_UNIT_LENGTH =    10;

    /**
     * Address Constructor That Creates Address Objects
     *
     * @param unitNumber  The unit number (up to MAX_UNIT_LENGTH)
     * @param streetNumber The street number (between MIN_STREET_NUMBER and MAX_STREET_NUMBER)
     * @param streetName  The street name (up to STREET_NAME_LENGTH)
     * @param postalCode  The postal code (MIN_POSTAL_LENGTH or MAX_POSTAL_LENGTH characters)
     * @param city        The city name (up to CITY_LENGTH characters)
     * @throws IllegalArgumentException If parameters are invalid
     */

    public Address(final String unitNumber,
                   final int    streetNumber,
                   final String streetName,
                   final String postalCode,
                   final String city)
    {

        // Parameters Validations
    if (unitNumber != null && unitNumber.isEmpty() || unitNumber.length() > MAX_UNIT_LENGTH)
    {
        throw new IllegalArgumentException("Invalid Unit Number: " + unitNumber);
    }

    if (streetNumber <= MIN_STREET_NUMBER || streetNumber > MAX_STREET_NUMBER)
    {
        throw new IllegalArgumentException("Invalid Street Number: " + streetNumber);
    }

    if (streetName == null || streetName.isEmpty() || streetName.length() > STREET_NAME_LENGTH)
    {
        throw new IllegalArgumentException("Invalid Street Name: " + streetName);
    }

    if (postalCode == null || postalCode.length() != MIN_POSTAL_LENGTH && postalCode.length() != MAX_POSTAL_LENGTH)
    {
        throw new IllegalArgumentException("Invalid Postal Code: " + postalCode);
    }

    if (city == null || city.isEmpty() || city.length() > CITY_LENGTH)
    {
        throw new IllegalArgumentException("Invalid City: " + city);
    }

    this.unitNumber =   unitNumber;
    this.streetNumber = streetNumber;
    this.streetName =   streetName;
    this.postalCode =   postalCode;
    this.city =         city;
}

    String getUnitNumber() {
        return unitNumber;
    } // Get unitNumber and returns it

    int getStreetNumber() {
        return streetNumber;
    } // Get streetNumber and returns it

    String getStreetName() {
        return streetName;
    } // Get streetName and returns it

    String getPostalCode() {
        return postalCode;
    } // Get postal code and returns it

    String getCity() {
        return city;
    } // Gets the city and returns it
}
