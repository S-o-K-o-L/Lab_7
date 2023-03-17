package Tests;

import org.junit.jupiter.api.Test;
import src.interfaces.DatabaseConfig;
import src.interfaces.SomethingElse;
import src.logic.ConfigService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomethingElseTest {
    private final SomethingElse somethingElse = ConfigService.load(SomethingElse.class);
    @Test
    public void testGetCat() {
        assertEquals("cat", somethingElse.getCat());
    }

    @Test
    public void testGetDog() {
        assertEquals("dog", somethingElse.getDog());
    }
}
