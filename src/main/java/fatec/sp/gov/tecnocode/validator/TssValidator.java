package fatec.sp.gov.tecnocode.validator;

import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.model.Tss;

public interface TssValidator extends AbstractValidator<Tss> {
    void validate(Tss tss);
}
