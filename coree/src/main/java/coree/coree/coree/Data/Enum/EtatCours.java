package coree.coree.coree.Data.Enum;

public enum EtatCours {
    Encours,Terminer;

    public static EtatCours toEnum(int valOrdinal) {
        for (EtatCours enumValue:values()){
            if(enumValue.ordinal()==valOrdinal) {
                return enumValue;
            }
        }
        return null;
    }

    //Méthode pour convertir un string en une enumération de type EtatCours
    public static EtatCours convertStringToEtatCours(String etat) {
        return EtatCours.valueOf(etat);
    }
}
