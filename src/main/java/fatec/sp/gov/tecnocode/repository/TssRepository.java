package fatec.sp.gov.tecnocode.repository;

import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.model.Tss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TssRepository extends JpaRepository<Tss, Long> {

    @Query("SELECT t FROM Tss t WHERE t.profile like :profile")
    List<Tss> findAllByProfile(@Param("profile") Profile profile);

    @Query("SELECT t FROM Tss t WHERE t.avgMin like :avgMin")
    List<Tss> findAllByAvgMin(@Param("avgMin") Integer avgMin);

    @Query("SELECT t FROM Tss t WHERE t.expPlat like :expPlat")
    List<Tss> findAllByExpPlat(@Param("expPlat") Double expPlat);

    @Query("SELECT t FROM Tss t WHERE t.avgHour like :avgHour")
    List<Tss> findAllByAvgHour(@Param("avgHour") Integer avgHour);

    @Query("SELECT t FROM Tss t WHERE t.expContent like :expContent")
    List<Tss> findAllByExpContent(@Param("expContent") Double expContent);
}
