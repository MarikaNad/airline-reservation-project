package services;

import model.Booking;
import model.CabinClass;
import model.FlightDetails;
import model.PassengerInfo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;

public class BookingServiceTest {

    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void verifyAddingFlightsWorks() throws ParseException {
        BookingService bs = new BookingService();
        bs.addFlight("EZY214",
                "Easy Jet",
                "London",
                DATE_FORMAT.parse("16/02/2024"),
                LocalTime.of(10, 0),
                "Geneva",
                LocalTime.of(12, 00),
                PassengerInfo.ADULT,
                CabinClass.ECONOMY, 50.00);

        FlightDetails stored = bs.getFlight("EZY214");
        assertNotNull(stored);
        assertEquals("EZY214", stored.getFlightNumber());
        assertEquals("Easy Jet", stored.getAirline());
        assertEquals("London", stored.getDepartureDetails().getDepartureCity());
        assertEquals("16/02/2024", DATE_FORMAT.format(stored.getDepartureDetails().getDepartureDate()));
        assertEquals(LocalTime.of(10, 0), stored.getDepartureDetails().getDepartureTime());
        assertEquals("Geneva", stored.getArrivalDetails().getArrivalCity());
        assertEquals(LocalTime.of(12, 00), stored.getArrivalDetails().getArrivalTime());
        assertEquals(PassengerInfo.ADULT, stored.getPassengerInfo());
        assertEquals(CabinClass.ECONOMY, stored.getCabinClass());

    }

    @Test
    public void verifyFindAFlight() throws ParseException {
        BookingService bs = new BookingService();
        bs.addFlight("EZY214",
                "Easy Jet",
                "London",
                DATE_FORMAT.parse("10/08/2023"),
                LocalTime.of(10, 0),
                "Madrid",
                LocalTime.of(12, 00),
                PassengerInfo.ADULT,
                CabinClass.ECONOMY, 50.00);

        List<FlightDetails> foundFlights =  bs.findAFlight("London", "Madrid", DATE_FORMAT.parse("10/08/2023"), CabinClass.ECONOMY);

        assertEquals(1, foundFlights.size());
        FlightDetails discoveredFlight = foundFlights.get(0);
        assertEquals("London", discoveredFlight.getDepartureDetails().getDepartureCity());
        assertEquals("Madrid", discoveredFlight.getArrivalDetails().getArrivalCity());
        assertEquals("10/08/2023", DATE_FORMAT.format(discoveredFlight.getDepartureDetails().getDepartureDate()));
        assertEquals(CabinClass.ECONOMY, discoveredFlight.getCabinClass());
    }

    @Test
    public void VerifyBookAFlight() throws ParseException {
        BookingService bs = new BookingService();
        bs.addFlight("EZY214",
                "Easy Jet",
                "London",
                DATE_FORMAT.parse("10/08/2023"),
                LocalTime.of(10, 0),
                "Madrid",
                LocalTime.of(12, 00),
                PassengerInfo.ADULT,
                CabinClass.ECONOMY, 50.00);

        String email = "marika.nad@gmail.com";
        String flightNumber = "EZY214";
        bs.bookAFlight(email, flightNumber);

        String bookingID = bs.bookedFlights.keySet().iterator().next();
        Booking storedBooking = bs.bookedFlights.get(bookingID);

        assertNotNull(storedBooking); // Check if the booking is not null
        assertEquals(email, storedBooking.getEmail()); // Verify the email
        assertEquals(flightNumber, storedBooking.getFlightNumber()); // Verify the flight number
    }
}
