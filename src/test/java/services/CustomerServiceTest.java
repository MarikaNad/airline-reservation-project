package services;

import model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerServiceTest {

    @Test
    public void verifyAddingCustomerWorks() {
        CustomerService sc = new CustomerService();
        sc.addCustomer("Marika", "Nad", "marika.nad@gmail.com");

        Customer stored = sc.getCustomer("marika.nad@gmail.com");
        assertNotNull(stored);
        assertEquals("Marika", stored.getName());
        assertEquals("Nad", stored.getSurname());
        assertEquals("marika.nad@gmail.com", stored.getEmail());

    }
}
