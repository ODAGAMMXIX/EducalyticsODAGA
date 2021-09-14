package fatec.sp.gov.tecnocode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fatec.sp.gov.tecnocode.model.Performance;


public interface PerformanceRepository extends JpaRepository<Performance, Long> {

	@Query("SELECT prf FROM Performance prf WHERE prf.course like :course")
	List<Performance> findAllByCourse(@Param("course") String course);

	@Query("SELECT prf FROM Performance prf WHERE prf.grade like :grade")
	List<Performance> findAllByGrade(@Param("grade") Double grade);

	@Query("SELECT prf FROM Performance prf WHERE prf.parClasses like :parClasses")
	List<Performance> findAllByParClasses(@Param("parClasses") Integer parClasses);

	@Query("SELECT prf FROM Performance prf WHERE prf.totClasses like :totClasses")
	List<Performance> findAllByTotClasses(@Param("totClasses") Integer totClasses);

}




