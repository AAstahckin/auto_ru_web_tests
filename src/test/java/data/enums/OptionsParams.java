package data.enums;

public enum OptionsParams {

    OPTIONS_FOG_LIGHTS("Противотуманные фары"),
    OPTIONS_BOARD_COMPUTER("Бортовой компьютер"),
    OPTIONS_CENTRAL_LOCKING("Центральный замок"),
    OPTIONS_IMMOBILIZER("Иммобилайзер");

    final String typeValue;

    OptionsParams(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getOptionsValue() {
        return typeValue;
    }
}
