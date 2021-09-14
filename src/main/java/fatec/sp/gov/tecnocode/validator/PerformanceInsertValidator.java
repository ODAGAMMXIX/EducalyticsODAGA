package fatec.sp.gov.tecnocode.validator;

import static java.util.Objects.isNull;

import org.springframework.stereotype.Component;

import fatec.sp.gov.tecnocode.model.Performance;
import fatec.sp.gov.tecnocode.repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PerformanceInsertValidator implements PerformanceValidator {
	private final PerformanceRepository performanceRepository;

	@Override
	public void validate(Performance performance) {
		if (!isNull(performance.getId())) {
			throw new RuntimeException("O ID desse Performance é gerado automaticamente.");

		}
		if (isNull(performance.getCourse())) {
			throw new RuntimeException("O course minimo deve ser informado");
		}
		if (isNull(performance.getGrade())) {
			throw new RuntimeException("O grade deve ser informado");
		}
		if (isNull(performance.getParClasses())) {
			throw new RuntimeException("O parClasses deve ser informado");
		}

		if (isNull(performance.getTotClasses())) {
			throw new RuntimeException("O totClasses deve ser informado");
		}
		
	}

}
