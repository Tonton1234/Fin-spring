package coree.coree.coree.Data.Enum;

public enum EtatLieu {
    Enligne,Présentiel;

    public static EtatLieu toEnum(int valOrdinal) {
        for (EtatLieu enumValue:values()){
            if(enumValue.ordinal()==valOrdinal) {
                return enumValue;
            }
        }
        return null;
    }
}
