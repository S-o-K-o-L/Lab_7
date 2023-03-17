package Tests;

import org.junit.jupiter.api.Test;
import src.interfaces.DatabaseConfig;
import src.logic.ConfigService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseConfigTest {
    private final DatabaseConfig databaseConfig = ConfigService.load(DatabaseConfig.class);

    @Test
    public void testGetJdbcUrl() {
        assertEquals("jdbc", databaseConfig.getJdbcUrl());
    }

    @Test
    public void testGetUser() {
        assertEquals("user", databaseConfig.getUser());
    }

    @Test
    public void testGetPassword() {
        assertEquals("pass", databaseConfig.getPassword());
    }

    @Test
    public void testGetSsl() {
        assertEquals(true, databaseConfig.getSsl());
    }
}
