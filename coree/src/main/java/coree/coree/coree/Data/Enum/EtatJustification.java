package coree.coree.coree.Data.Enum;

public enum EtatJustification {
    Acceptée,Refusée;
    public static EtatJustification toEnum(int valOrdinal) {
        for (EtatJustification enumValue:values()){
            if(enumValue.ordinal()==valOrdinal) {
                return enumValue;
            }
        }
        return null;
    }
}
