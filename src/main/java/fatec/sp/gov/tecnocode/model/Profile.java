package fatec.sp.gov.tecnocode.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @Column(name = "usr_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_sequence")
    private Long id;

    @OneToOne
    private Login login;

    @Column(name = "usr_cpf")
    private String cpf;

    @Column(name = "usr_name")
    private String name;

    @Column(name = "usr_email")
    private String email;

    @Column(name = "usr_phone")
    private String phone;

    @Column(name = "usr_genre")
    private String genre;

    @Column(name = "usr_birth")
    private LocalDate birth;

    @Column(name = "usr_created_at")
    private LocalDate createdAt;
}
