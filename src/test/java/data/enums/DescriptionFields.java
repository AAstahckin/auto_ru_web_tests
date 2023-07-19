package data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DescriptionFields {

    DESCRIPTION_HEADER("Описание"),
    DESCRIPTION_WARNING("Пожалуйста, не указывайте ссылки, цену, контактные данные и не предлагайте услуги — такое объявление не пройдет модерацию"),
    DESCRIPTION_ONLY_ON_AUTO("Только на Авто.ру"),
    DESCRIPTION_BEATEN("Битый или не на ходу");

    final String typeValue;

}
