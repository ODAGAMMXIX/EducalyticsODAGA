package fatec.sp.gov.tecnocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "performance")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

public class Performance {
	@Id
	@Column(name = "prf_std_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "prf_sequence")
	private Long id;

	@Column(name = "prf_course")
	private String course;

	@Column(name = "prf_partial_grade")
	private Double grade;

	@Column(name = "prf_partial_classes")
	private Integer parClasses;

	@Column(name = "prf_total_classes")
	private Integer totClasses;

}
