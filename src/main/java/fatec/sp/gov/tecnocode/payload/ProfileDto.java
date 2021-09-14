package fatec.sp.gov.tecnocode.payload;

import fatec.sp.gov.tecnocode.model.Profile;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProfileDto implements Serializable {

    private String login;

    private String name;

    private String email;

    private LocalDate createdAt;
}
