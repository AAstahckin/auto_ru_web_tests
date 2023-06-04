package data.enums;

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

    public final String typeValue;
    public final int typeNumber;

    DamageType(String typeValue, int typeNumber) {
        this.typeValue = typeValue;
        this.typeNumber = typeNumber;
    }

    public String getOptionsTypeValue() {
        return typeValue;
    }

    public static int getNumber(String name) {
        for (DamageType damageType : DamageType.values()) {
            if (damageType.typeValue.equals(name)) {
                return damageType.typeNumber;
            }
        }
        throw new IllegalArgumentException("Unknown name: " + name);
    }

}
