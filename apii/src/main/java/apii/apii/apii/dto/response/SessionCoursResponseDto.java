package apii.apii.apii.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import coree.coree.coree.Data.entities.SessionCours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionCoursResponseDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("start")
    private String start;
    @JsonProperty("end")
    private String end;
    @JsonProperty("description")
    private String description;


    public static SessionCoursResponseDto toDto(SessionCours sessionCours){
        return SessionCoursResponseDto
                .builder()
                .id(sessionCours.getId())
                .title(sessionCours.getLibelle() +'\n'+ sessionCours.getLieu()+'\n'+ sessionCours.getProfesseur().getNom() )
                .start(formatterLocalDate(sessionCours.getDate())+'T'+formatterLocalTime(sessionCours.getHeureDebut()))
                .end(formatterLocalDate(sessionCours.getDate())+'T'+formatterLocalTime(sessionCours.getHeureFin()))
                .description(sessionCours.getCours().getModule().getLibelle() +'\n'+ sessionCours.getLieu()+'\n'+ sessionCours.getProfesseur().getNom() )
                .build();
    }
    public static String formatterLocalDate(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDate.format(formatter);
    }
    public static String formatterLocalTime(LocalTime localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return localDate.format(formatter);
    }

    /*public static void main(String[] args) {
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = date.format(formatter);
            System.out.println("Date formatée : " + formattedDate);
    }*/

}
