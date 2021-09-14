package fatec.sp.gov.tecnocode.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import fatec.sp.gov.tecnocode.model.Performance;
import fatec.sp.gov.tecnocode.repository.PerformanceRepository;
import fatec.sp.gov.tecnocode.service.PerformanceService;
import fatec.sp.gov.tecnocode.validator.Operation;
import fatec.sp.gov.tecnocode.validator.PerformanceValidator;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {
	private final PerformanceRepository repository;
    private final Map<Operation, PerformanceValidator> validator;


    @Override
    public Performance save(final Performance performance, final Operation operation) {
        validator.get(operation).validate(performance);
        return repository.saveAndFlush(performance);
}
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
  
    @Override
    public List<Performance> buscarTodosCourse(String course) {
        return repository.findAllByCourse(course);
    }

    @Override
    public List<Performance> buscarTodosGrade(Double grade) {
        return repository.findAllByGrade(grade);
    }

    @Override
    public List<Performance> buscarTodosParClasses(Integer parClasses) {
        return repository.findAllByParClasses(parClasses);
    }

    @Override
    public List<Performance> buscarTodosTotClasses(Integer totClasses) {
        return repository.findAllByTotClasses(totClasses);
    }

    @Override
    public List<Performance> buscarTodosPerformance(){
        return repository.findAll();
    }
}