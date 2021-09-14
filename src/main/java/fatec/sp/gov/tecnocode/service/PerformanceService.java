package fatec.sp.gov.tecnocode.service;


import java.util.List;

import fatec.sp.gov.tecnocode.model.Performance;

public interface PerformanceService extends GenericService<Performance> {

	List<Performance> buscarTodosCourse(String course);

	List<Performance> buscarTodosGrade(Double grade);

	List<Performance> buscarTodosParClasses(Integer parClasses);

	List<Performance> buscarTodosTotClasses(Integer totClasses);

	List<Performance> buscarTodosPerformance();

}
