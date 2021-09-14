package fatec.sp.gov.tecnocode.validator;

import static java.util.Objects.isNull;

import org.springframework.stereotype.Component;

import fatec.sp.gov.tecnocode.model.Performance;
import fatec.sp.gov.tecnocode.repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PerformanceUpdateValidator implements PerformanceValidator{
	private final PerformanceRepository performanceRepository;
	
	 @Override
	    public void validate(Performance performance) {
	        if (isNull(performance.getId())) {
	            throw new RuntimeException("O ID do performance deverá ser informado.");
	        }
	        if(!performanceRepository.findById(performance.getId()).isPresent()){
	            throw new RuntimeException("O performance informado para atualizar não existe.");
	        }
	    }

}
