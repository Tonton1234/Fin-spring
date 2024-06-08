package coree.coree.coree.Data.Enum;

public enum EtatSessionCours {
    Planifier,Valider,Annuler,Invalider,Faits;

    public static EtatSessionCours toEnum(int valOrdinal) {
        for (EtatSessionCours enumValue:values()){
            if(enumValue.ordinal()==valOrdinal) {
                return enumValue;
            }
        }
        return null;
    }
    //Méthode pour convertir un string en une enumération de type EtatSesionCours
    public static EtatSessionCours convertStringToEtatCours(String etat) {
        return EtatSessionCours.valueOf(etat);
    }

}