package data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PtsOwnersParams {

    FIRST_OWNER("Первый"),
    SECOND_OWNER("Второй"),
    THIRD_OWNER("Третий"),
    FOURTH_OR_MORE_OWNER("Четвёртый или более");

    final String typeValue;

}
