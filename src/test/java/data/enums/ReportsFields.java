package data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReportsFields {

    REPORT_TITTLE("Проверьте историю автомобиля по госномеру или VIN"),
    REPORT_VIN_TITTLE("Соберём данные из десятков источников: ДТП, юридические ограничения, пробеги, обслуживание, предыдущие размещения на Авто.ру и многое другое");

    final String value;

}
