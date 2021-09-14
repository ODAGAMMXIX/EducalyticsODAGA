package fatec.sp.gov.tecnocode.validator;

import fatec.sp.gov.tecnocode.model.Tss;
import fatec.sp.gov.tecnocode.repository.TssRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class TssUpdateValidator implements TssValidator {
    private final TssRepository tssRepository;

    @Override
    public void validate(Tss tss) {
        if (isNull(tss.getId())) {
            throw new RuntimeException("O ID do tss deverá ser informado.");
        }
        if(!tssRepository.findById(tss.getId()).isPresent()){
            throw new RuntimeException("O tss informado para atualizar não existe.");
        }
    }
}
