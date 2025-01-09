package dev.qaplayground.utils;

import net.datafaker.Faker;

public class DataFaker {

    static Faker faker = new Faker();

    public static String anyBeerName = faker.beer().name();

}
