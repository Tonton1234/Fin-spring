package apii.apii.apii.dto.response;

import coree.coree.coree.Data.Enum.EtatLieu;
import coree.coree.coree.Data.entities.Classe;
import coree.coree.coree.Data.entities.Semestre;
import coree.coree.coree.Data.entities.SessionCours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoRequestCalendar {
    private Long id;
    private String module;
    private String semestre;
    private String professeur;
    private String lieu;
    private String debut;
    private String fin;
    private Long duree;
    private String date;
    private String jourActuel;
    private List<String> classeList;
    private Long isArchived;


    public static DtoRequestCalendar toDto(SessionCours sessionCours){
        int i = 1;
        List<Semestre> semestreList = new ArrayList<>();
        List<String> classeLists = new ArrayList<>();
        for (Semestre semestre1 : sessionCours.getCours().getSemestres()){
            if(sessionCours.getCours().getSemestres().size() == i){
                semestreList.add(semestre1);
            }
            i++;
        }

        for (Classe cl : sessionCours.getCours().getClasses()){
            classeLists.add(cl.getLibelle());
        }
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        String formattedDate = sdf.format(sessionCours.getDate());

        long isArchived = sessionCours.getActive()?1L:0L;

        String lieu = sessionCours.getLieu() == EtatLieu.Enligne ? "En Ligne" : "Salle " + sessionCours.getSallescours().getNom();
        return new DtoRequestCalendar(sessionCours.getId(),
                sessionCours.getCours().getModule().getLibelle(),
                semestreList.get(0).getLibelle(),
                sessionCours.getProfesseur().getNom(),
                lieu,
                sessionCours.getHeureDebut().toString(),
                sessionCours.getHeureFin().toString(),
                duration( sessionCours.getHeureDebut(), sessionCours.getHeureFin()),
                sessionCours.getDate().toString(),
                LocalDate.now().toString(),
                classeLists,
                isArchived
        );
    }

    public static Long duration(LocalTime heureDebut,LocalTime heureFin){
        Duration duration = Duration.between(heureDebut, heureFin);
        long hourDifference = duration.toHours();
        return hourDifference;
    }
}
