package Tests;

import org.junit.jupiter.api.Test;
import src.interfaces.NewInterface;
import src.logic.ConfigService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewInterfaceTest {
    private final NewInterface newInterface = ConfigService.load(NewInterface.class);

    @Test
    public void testGetLogin() {
        assertEquals("login", newInterface.getLogin());
    }

    @Test
    public void testGetMarks() {
        assertEquals("mark", newInterface.getMarks());
    }
}
