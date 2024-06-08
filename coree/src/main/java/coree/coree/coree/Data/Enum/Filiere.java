package coree.coree.coree.Data.Enum;

public enum Filiere {
    GLRS,ETSE,MAIE,TTL,CPD,CDSD,IAGE;
    public static Filiere toEnum(int valOrdinal) {
        for (Filiere enumValue:values()){
            if(enumValue.ordinal()==valOrdinal) {
                return enumValue;
            }
        }
        return null;
    }
}
