package data.enums;

public enum TransmissionType {

    MECHANICS("Механика"),
    ROBOT("Робот"),
    MACHINE("Автомат");

    final String typeValue;

        TransmissionType(String typeValue) {
        this.typeValue = typeValue;
    }
    public String getTypeEngine() {
        return typeValue;
    }

}

