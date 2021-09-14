package fatec.sp.gov.tecnocode.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.sp.gov.tecnocode.converter.DtoToPerformanceConverter;
import fatec.sp.gov.tecnocode.converter.PerformanceToDtoConverter;
import fatec.sp.gov.tecnocode.model.Performance;
import fatec.sp.gov.tecnocode.payload.PerformanceDto;
import fatec.sp.gov.tecnocode.service.PerformanceService;
import fatec.sp.gov.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/performance")
@RequiredArgsConstructor
public class PerformanceController {
	private final PerformanceService service;
	private final DtoToPerformanceConverter dtoToPerformanceConverter;
	private final PerformanceToDtoConverter performanceToDtoConverter;

	@PostMapping
	public ResponseEntity saveNew(@RequestBody final PerformanceDto performanceDto) {

		try {
			Performance performance = service.save(dtoToPerformanceConverter.convert(performanceDto), Operation.INSERT);
			return ResponseEntity.status(HttpStatus.CREATED).body(performanceToDtoConverter.convert(performance));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}

	@GetMapping
	public List<Performance> buscarTodosPerformance() {
		return service.buscarTodosPerformance();
	}

	@GetMapping("/{course}")
	public List<Performance> buscarTodosCourse(@PathVariable("course") String course) {
		return service.buscarTodosCourse(course);
	}

	@GetMapping("/{grade}")
	public List<Performance> buscarTodosGrade(@PathVariable("grade") Double grade) {
		return service.buscarTodosGrade(grade);
	}

	@GetMapping("/{parClasses}")
	public List<Performance> buscarTodosParClasses(@PathVariable("parClasses") Integer parClasses) {
		return service.buscarTodosParClasses(parClasses);
	}

	@GetMapping("/{totClasses}")
	public List<Performance> buscarTodosTotClasses(@PathVariable("totClasses") Integer totClasses) {
		return service.buscarTodosTotClasses(totClasses);
	}
}
