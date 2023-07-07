package data.enums;

public enum DamageValues {

    PAINTED("Окрашено"),
    CORROSION("Коррозия"),
    DENT("Вмятина"),
    SCRATCH("Царапина/Скол");

    final String typeValue;

        DamageValues(String typeValue) {
        this.typeValue = typeValue;
    }
    public String getDamageValues() {
        return typeValue;
    }

}

