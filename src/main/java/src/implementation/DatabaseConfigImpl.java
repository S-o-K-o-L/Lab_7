package src.implementation;

import src.annotation.Property;
import src.interfaces.DatabaseConfig;

import java.util.Properties;

public class DatabaseConfigImpl implements DatabaseConfig {
    private Properties properties = null;

    @Override
    @Property("db.jdbcUrl")
    public String getJdbcUrl() {
        return properties.getProperty("db.jdbcUrl");
    }

    @Override
    @Property("db.user")
    public String getUser() {
        return properties.getProperty("db.user");
    }

    @Override
    @Property("db.password")
    public String getPassword() {
        return properties.getProperty("db.password");
    }

    @Override
    @Property("db.ssl")
    public boolean getSsl() {
        String ssl = properties.getProperty("db.ssl");
        return Boolean.parseBoolean(ssl);
    }
}
