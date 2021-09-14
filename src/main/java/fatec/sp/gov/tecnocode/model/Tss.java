package fatec.sp.gov.tecnocode.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tss")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Tss {
    @Id
    @Column(name = "tss_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "tss_sequence")
    private Long id;

    @OneToOne
    private Profile profile;

    @Column(name = "tss_avg_min")
    private Integer avgMin;

    @Column(name = "tss_exp_plat")
    private Double expPlat;

    @Column(name = "tss_avg_hr")
    private Integer avgHour;

    @Column(name = "tss_exp_content")
    private Double expContent;

}
