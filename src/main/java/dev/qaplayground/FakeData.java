package dev.qaplayground;

import net.datafaker.Faker;

public class FakeData {

    static Faker faker = new Faker();

    public static String anyBeerName = faker.beer().name();

}
