package utils;

import com.github.javafaker.Faker;
import data.enums.EngineType;
import data.enums.PtsOwnersParams;

public class RandomUtils {

    static Faker faker = new Faker();

    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumClass) {
        int index = faker.random().nextInt(0,enumClass.getEnumConstants().length - 1);
        return enumClass.getEnumConstants()[index];
    }

    public static String getRandomEngineType() {
        return getRandomEnum(EngineType.class).getTypeEngine();
    }

    public static String getRandomDriveType() {
        return getRandomEnum(PtsOwnersParams.class).getValue();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomNumber(int numberLength) {
        return faker.number().digits(numberLength);
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }
}
