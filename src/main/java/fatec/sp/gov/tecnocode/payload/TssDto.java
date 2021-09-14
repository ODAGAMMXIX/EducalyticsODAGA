package fatec.sp.gov.tecnocode.payload;

import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.model.Tss;
import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TssDto implements Serializable {

    private Profile profile;

    private Integer avgMin;

    private Double expPlat;

    private Integer avgHour;

    private Double expContent;

}
