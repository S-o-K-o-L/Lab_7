package src.interfaces;

import src.annotation.Config;
import src.annotation.Property;

@Config(path = "config/db.properties")
public interface DatabaseConfig {
    @Property("db.jdbcUrl")
    String getJdbcUrl();

    @Property("db.user")
    String getUser();

    @Property("db.password")
    String getPassword();

    @Property("db.ssl")
    boolean getSsl();
}
