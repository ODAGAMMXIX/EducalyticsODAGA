package fatec.sp.gov.tecnocode.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;
import fatec.sp.gov.tecnocode.model.Performance;
import fatec.sp.gov.tecnocode.payload.PerformanceDto;

@Component
public class DtoToPerformanceConverter implements Converter<PerformanceDto, Performance> {
	
	@Override
    public Performance convert(PerformanceDto performanceDto) {
        return Performance.builder()
                .course(performanceDto.getCourse())
                .grade(performanceDto.getGrade())
                .parClasses(performanceDto.getParClasses())
                .totClasses(performanceDto.getTotClasses())
                .build();
    }

}
