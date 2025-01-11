package utils;

import net.datafaker.Faker;

public class DataFaker {

    static Faker faker = new Faker();

    public static String anyBeerName = faker.beer().name();
    public static String userName = faker.name().name();
    public static String userJob = faker.job().title();

}
