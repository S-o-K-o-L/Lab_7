package src.interfaces;

import src.annotation.Config;
import src.annotation.Property;

@Config(path = "config/db.properties")
public interface SomethingElse {
    @Property("db.cat")
    String getCat();

    @Property("db.dog")
    String getDog();
}
