package apii.apii.apii.security.controllers.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TokenReponseDto {
    private String token;
    private String username;
    private String type;
    private List<String> roles=new ArrayList<String>();
}
