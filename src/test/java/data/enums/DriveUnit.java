package data.enums;

public enum DriveUnit {

    FRONT("Передний"),
    FULL("Полный");

    final String typeValue;

    DriveUnit(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getTypeDrive() {
        return typeValue;
    }

}

