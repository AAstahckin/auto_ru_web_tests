package data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PtsTypeParams {

    ORIGINAL_PTS("Оригинал / Электронный ПТС"),
    DUPLICATE_PTS("Дубликат"),
    NO_PTS("Нет ПТС");

    final String typeValue;

}
