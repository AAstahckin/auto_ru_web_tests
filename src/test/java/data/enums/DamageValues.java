package data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DamageValues {

    PAINTED("Окрашено"),
    CORROSION("Коррозия"),
    DENT("Вмятина"),
    SCRATCH("Царапина/Скол");

    final String typeValue;

}

