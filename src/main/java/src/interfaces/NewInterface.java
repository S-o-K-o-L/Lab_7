package src.interfaces;

import src.annotation.Config;
import src.annotation.Property;

@Config(path = "config/db.properties")
public interface NewInterface {
    @Property("db.login")
    String getLogin();

    @Property("db.marks")
    String getMarks();
}
