package data.enums;

public enum OptionsFields {

    OPTIONS_HEADER("Опции");

    final String typeValue;

    OptionsFields(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getOptionsField() {
        return typeValue;
    }
}
