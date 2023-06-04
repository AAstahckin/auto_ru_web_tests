package data.enums;

public enum PtsOwnersParams {

    FIRST_OWNER("Первый"),
    SECOND_OWNER("Второй"),
    THIRD_OWNER("Третий"),
    FOURTH_OR_MORE_OWNER("Четвёртый или более");

    final String typeValue;

    PtsOwnersParams(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getValue() {
        return typeValue;
    }
}
