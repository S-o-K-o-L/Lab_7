package src;

import src.interfaces.DatabaseConfig;
import src.interfaces.NewInterface;
import src.interfaces.SomethingElse;
import src.logic.ConfigService;

// properties
public class Main {
    public static void main(String[] args) {
        DatabaseConfig config1 = ConfigService.load(DatabaseConfig.class);
        System.out.println(config1.getJdbcUrl());
        System.out.println(config1.getUser());
        System.out.println(config1.getSsl());
        System.out.println(config1.getPassword());
        NewInterface newInterface = ConfigService.load(NewInterface.class);
        System.out.println(newInterface.getLogin());
        System.out.println(newInterface.getMarks());
        SomethingElse somethingElse = ConfigService.load(SomethingElse.class);
        System.out.println(somethingElse.getCat());
        System.out.println(somethingElse.getDog());
    }
}
