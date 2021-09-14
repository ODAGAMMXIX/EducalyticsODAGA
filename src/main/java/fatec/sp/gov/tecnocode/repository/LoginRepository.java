package fatec.sp.gov.tecnocode.repository;

import fatec.sp.gov.tecnocode.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    @Query("SELECT l FROM Login l WHERE l.id like :id")
    Optional<Login> findById(@Param("id") Long id);

    @Query("SELECT l FROM Login l WHERE l.login like :login")
    Optional<Login> findByLogin(@Param("login") String login);
}