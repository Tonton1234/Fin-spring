package coree.coree.coree.Data.Enum;

public enum Niveau {
    L1,L2,L3,M1,M2;
    public static Niveau toEnum(int valOrdinal) {
        for (Niveau enumValue:values()){
            if(enumValue.ordinal()==valOrdinal) {
                return enumValue;
            }
        }
        return null;
    }
}
