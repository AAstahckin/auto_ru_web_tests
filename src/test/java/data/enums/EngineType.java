package data.enums;

public enum EngineType {

    PETROL("Бензин"),
    DIESEL("Дизель");

    final String typeValue;

        EngineType(String typeValue) {
        this.typeValue = typeValue;
    }
    public String getTypeEngine() {
        return typeValue;
    }

}

