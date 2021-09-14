package fatec.sp.gov.tecnocode.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fatec.sp.gov.tecnocode.model.Performance;

@SpringBootTest
public class PerformanceValidatorTest {
	
	 @Autowired
	    private Map<Operation, PerformanceValidator> validator;

	    @Test
	    public void givenAValidPerformanceData_whenTryToValidate_thenShouldSuccess() {
	        Performance performance = Performance.builder()
	                .course("teste")
	                .grade(62.1)
	                .parClasses(6)
	                .totClasses(5)
	                .build();

	        assertDoesNotThrow(() -> validator.get(Operation.INSERT).validate(performance));
	        assertDoesNotThrow(() -> validator.get(Operation.UPDATE).validate(performance));
	    }

	    @Test
	    public void givenAnInvalidCourseData_whenTryToValidate_thenThrowsException() {
	        Performance performance1 = Performance.builder()
	        		    .course("teste")
		                .grade(62.1)
		                .parClasses(6)
		                .totClasses(5)
		                .build();
	        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(performance1));
	        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(performance1));

	        Performance performance2 = Performance.builder()
	        		    .grade(62.1)
		                .parClasses(6)
		                .totClasses(5)
		                .build();
	        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(performance2));
	        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(performance2));

	        Performance performance3 = Performance.builder()
	        		    .parClasses(6)
		                .totClasses(5)
		                .build();
	        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(performance3));
	        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(performance3));

	        Performance performance4 = Performance.builder()
	        		    .totClasses(5)
		                .build();
	        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(performance4));
	        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(performance4));

	        Performance performance5 = Performance.builder()
	        		    .build();
	        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(performance5));
	        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(performance5));
	    }
	}



