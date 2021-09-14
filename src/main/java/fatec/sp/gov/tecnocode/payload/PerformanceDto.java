package fatec.sp.gov.tecnocode.payload;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PerformanceDto implements Serializable {
	
	
	private String course;

	private Double grade;

	private Integer parClasses;

	private Integer totClasses;

}
