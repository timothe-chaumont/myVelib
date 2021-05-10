package src.test;

import src.classes.User;
import src.enums.TypeOfBicycle;
import src.registrationCard.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserTest {
    User user1 = new User("Billy Gates", 123.0, 145.4, "12353849583740384",
            new NoRegistrationCard());
    User user2 = new User("Marcus Zuckerberg", 12.0, 15.4, "12353849sfg740384",
            new VlibreRegistrationCard());

    @Test
    void setId() throws Exception {
//        assertThrows(new Exception(), user2.setId(0));
        user1.setId(16);
        assertEquals(1, user2.getId()); // users cannot have the same id
        assertEquals(16, user1.getId());
    }

    @Test
    void setRegistrationCard() {
        user2.setRegistrationCard(new NoRegistrationCard()); // assert everything else is deleted
    }

    @Test
    void computeCost() {
        // add more test cases

        // No registration card
        double cost1 = user1.computeCost(20.0, TypeOfBicycle.Electrical);
        double cost2 = user1.computeCost(130.0, TypeOfBicycle.Mechanical);
        assertEquals(2.0, cost1);
        assertEquals(3.0, cost2);

        // Vlibre
        double cost3 = user2.computeCost(100.0, TypeOfBicycle.Electrical);
        double cost4 = user2.computeCost(50.3, TypeOfBicycle.Mechanical);
        assertEquals(1.0 + 2.0, cost3);
        assertEquals(0.0, cost4);

        // Vmax
    }
}