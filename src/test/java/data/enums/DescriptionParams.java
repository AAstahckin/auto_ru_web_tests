package data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DescriptionParams {

    OPTIONS_VALUE_WINTER_TIRES("Комплект зимних шин в подарок"),
    OPTIONS_VALUE_SUMMER_TIRES("Комплект летних шин в подарок"),
    OPTIONS_VALUE_TIMELY_SERVICE("Своевременное обслуживание"),
    OPTIONS_VALUE_PASSED_TO("Пройдены все ТО"),
    OPTIONS_VALUE_NOT_CREDIT("Куплена не в кредит"),
    OPTIONS_VALUE_SMOKE_INTERIOR("Непрокуренный салон"),
    OPTIONS_VALUE_SERVICE_BOOK("Сервисная книжка"),
    OPTIONS_VALUE_CAR_ACCIDENT("Не участвовала в ДТП"),
    OPTIONS_VALUE_TOW_BAR("Фаркоп"),
    OPTIONS_VALUE_VAT_DEDUCTION("Возможен вычет НДС");

    final String typeValue;

}
