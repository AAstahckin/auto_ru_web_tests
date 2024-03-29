package data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransportType {

    COMMERCIAL("Коммерческие", new String[]{
            "Лёгкие коммерческие", "Грузовики", "Седельные тягачи", "Автобусы",
            "Прицепы и полуприцепы", "Сельскохозяйственная", "Строительная и дорожная",
            "Погрузчики", "Автокраны", "Экскаваторы", "Бульдозеры", "Коммунальная" }),
    MOTO("Мото", new String[]{ "Мотоциклы", "Скутеры", "Мотовездеходы", "Снегоходы" }),
    CARS("Легковые", new String[]{
            "Внедорожник", "Седан", "Хэтчбек", "Лифтбек", "Универсал", "Минивэн",
            "Купе", "Пикап", "Кабриолет", "Фургон" });

    final String typeName;
    final String[] typeValue;

}
