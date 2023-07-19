package data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PtsFields {

    PTS_HEADER("ПТС"),
    PTS_TYPE_DOCUMENT("Тип документа"),
    PTS_OWNERS("Какой вы владелец?"),
    PTS_YEAR("Год"),
    PTS_MONTH("Месяц"),
    PTS_NOT_CLEARED("Не растаможен"),
    PTS_GUARANTEE("На гарантии"),
    PTS_GUARANTEE_YEAR_OF_ENDING("Год окончания"),
    PTS_GUARANTEE_END_MONTH("Месяц"),
    PTS_SALE_DATE("Когда был куплен автомобиль?");

    final String value;

}
