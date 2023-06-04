package data.enums;

public enum PtsTypeParams {

    ORIGINAL_PTS("Оригинал / Электронный ПТС"),
    DUPLICATE_PTS("Дубликат"),
    NO_PTS("Нет ПТС");

    final String typeValue;

    PtsTypeParams(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getValue() {
        return typeValue;
    }
}
