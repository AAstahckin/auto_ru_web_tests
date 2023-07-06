package data.enums;

public enum BrandAndMarks {

    BMW("BMW", new String[]{
            "1 серии", "3 серии", "4 серии", "5 серии", "7 серии", "X1", "X3", "X4", "X5", "X6", "X7"}),
    MAZDA("Mazda", new String[]{
            "3", "323", "6", "626", "Axela", "CX-4", "CX-5", "CX-7", "CX-9", "Demio", "Familia",}),
    FORD("Ford", new String[]{
            "C-MAX", "EcoSport", "Escape", "Explorer", "Fiesta", "Focus", "Fusion", "Fusion (North America)", "Kuga", "Mondeo",
            "Mustang"}),
    KIA("Kia", new String[]{
            "Carnival", "Ceed", "Cerato", "K5", "Mohave", "Optima", "Rio", "Seltos", "Sorento", "Soul", "Sportage"}),
    LEXUS("Lexus", new String[]{
            "CT", "ES", "GS", "GX", "IS", "LS", "LX", "NX", "RX", "SC", "UX"}),
    AUDI("Audi", new String[]{
            "100", "80", "A3", "A4", "A5", "A6", "A8", "Q3", "Q5", "Q7", "Q8"});

    final String typeName;
    final String[] typeValue;

    BrandAndMarks(String typeName, String[] typeValue) {
        this.typeName = typeName;
        this.typeValue = typeValue;
    }

    public String getTypeName() {
        return typeName;
    }

    public String[] getTypeValue() {
        return typeValue;
    }

}
