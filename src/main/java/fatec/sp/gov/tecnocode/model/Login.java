package fatec.sp.gov.tecnocode.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "profile")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    @Column(name = "prl_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "profile_sequence")
    private Long id;

    @Column(name = "prl_login")
    private String login;

    @Column(name = "prl_password")
    private String password;

}
