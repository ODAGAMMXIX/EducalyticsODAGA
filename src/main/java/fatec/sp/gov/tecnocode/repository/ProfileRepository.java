package fatec.sp.gov.tecnocode.repository;

import fatec.sp.gov.tecnocode.model.Login;
import fatec.sp.gov.tecnocode.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("SELECT p FROM Profile p WHERE p.id like :id")
    Optional<Profile> findById(@Param("id") Long id);

    @Query("SELECT p FROM Profile p WHERE p.login like :login")
    List<Profile> findAllByProfile(@Param("login") Login login);

    @Query("SELECT p FROM Profile p WHERE p.name like :name")
    List<Profile> findAllByName(@Param("name") String name);

    @Query("SELECT p FROM Profile p WHERE p.email like :email")
    List<Profile> findAllByEmail(@Param("email") String email);
}
