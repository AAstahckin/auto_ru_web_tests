package data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DamageType {

    FRONT_BUMPER("Передний бампер", 1),
    REAR_BUMPER("Задний бампер", 2),
    FRONT_LEFT_FENDER("Переднее левое крыло", 3),
    FRONT_RIGHT_FENDER("Переднее правое крыло", 4),
    REAR_LEFT_FENDER("Заднее левое крыло", 5),
    REAR_RIGHT_FENDER("Заднее правое крыло", 6),
    ROOF("Крыша", 6),
    HOOD("Капот", 7),
    WINDSHIELD("Лобовое стекло", 8);

    final String typeValue;
    final int typeNumber;

    public static int getNumber(String name) {
        for (DamageType damageType : DamageType.values()) {
            if (damageType.typeValue.equals(name)) {
                return damageType.typeNumber;
            }
        }
        throw new IllegalArgumentException("Unknown name: " + name);
    }

}
