package src.implementation;

import src.annotation.Property;
import src.interfaces.SomethingElse;

import java.util.Properties;

public class SomethingElseImpl implements SomethingElse {
    private Properties properties = null;

    @Override
    @Property("db.cat")
    public String getCat() {
        return properties.getProperty("db.cat");
    }

    @Override
    @Property("db.dog")
    public String getDog() {
        return properties.getProperty("db.dog");
    }
}
