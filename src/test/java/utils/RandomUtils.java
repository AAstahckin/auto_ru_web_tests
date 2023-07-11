package utils;

import com.github.javafaker.Faker;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import data.enums.DamageType;
import data.enums.DamageValues;
import data.enums.DescriptionParams;
import data.enums.OptionsParams;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RandomUtils {

    static Faker faker = new Faker();

    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumClass) {
        int index = faker.random().nextInt(0, enumClass.getEnumConstants().length - 1);
        return enumClass.getEnumConstants()[index];
    }

    public static String getRandomOptionsParams() {
        return getRandomEnum(OptionsParams.class).getOptionsValue();
    }

    public static String getRandomDescriptionParams() {
        return getRandomEnum(DescriptionParams.class).getDescriptionValue();
    }

    public static String getRandomDamageTypeParams() {
        return getRandomEnum(DamageType.class).getOptionsTypeValue();
    }

    public static String getRandomDamageValues() {
        return getRandomEnum(DamageValues.class).getDamageValues();
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

    public static String getRandomText(int length) {
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<length; i++){
            stringBuilder.append(str.charAt(faker.random().nextInt(str.length())));
        }
        return stringBuilder.toString();
    }

}
