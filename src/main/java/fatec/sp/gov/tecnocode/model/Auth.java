package fatec.sp.gov.tecnocode.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "auth")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Auth {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "auth_sequence")
    private Long id;

    @Column(name = "permission")
    private String permission;





}
