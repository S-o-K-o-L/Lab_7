package src.implementation;

import src.annotation.Property;
import src.interfaces.NewInterface;

import java.util.Properties;

public class NewInterfaceImpl implements NewInterface {
    private Properties properties = null;

    @Override
    @Property("db.login")
    public String getLogin() {
        return properties.getProperty("db.login");
    }

    @Override
    @Property("db.marks")
    public String getMarks() {
        return properties.getProperty("db.marks");
    }
}
