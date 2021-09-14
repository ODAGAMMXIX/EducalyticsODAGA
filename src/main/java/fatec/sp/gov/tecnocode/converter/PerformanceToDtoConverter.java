package fatec.sp.gov.tecnocode.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import fatec.sp.gov.tecnocode.model.Performance;
import fatec.sp.gov.tecnocode.payload.PerformanceDto;

@Component
public class PerformanceToDtoConverter implements Converter<Performance, PerformanceDto>{
	
	 @Override
	    public PerformanceDto convert(Performance performance) {
	        return PerformanceDto.builder()
	        		   .course(performance.getCourse())
	                   .grade(performance.getGrade())
	                   .parClasses(performance.getParClasses())
	                   .totClasses(performance.getTotClasses())
	                   .build();

}
}