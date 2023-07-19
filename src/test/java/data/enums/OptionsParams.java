package data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OptionsParams {

    OPTIONS_FOG_LIGHTS("Противотуманные фары"),
    OPTIONS_BOARD_COMPUTER("Бортовой компьютер"),
    OPTIONS_CENTRAL_LOCKING("Центральный замок"),
    OPTIONS_IMMOBILIZER("Иммобилайзер");

    final String typeValue;

}
