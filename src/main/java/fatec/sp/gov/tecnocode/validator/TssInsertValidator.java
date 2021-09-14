package fatec.sp.gov.tecnocode.validator;

import fatec.sp.gov.tecnocode.model.Tss;
import fatec.sp.gov.tecnocode.repository.LoginRepository;
import fatec.sp.gov.tecnocode.repository.TssRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class TssInsertValidator implements TssValidator {
    private final TssRepository tssRepository;
    private final LoginRepository loginRepository;

    @Override
    public void validate(Tss tss) {
        if(!isNull(tss.getId())) {
            throw new RuntimeException("O ID desse TSS é gerado automaticamente.");
        }
        if(isNull(tss.getProfile()) || isNull(tss.getProfile().getId())) {
            throw new RuntimeException("O login não pode ser vazio.");
        }
        if(!loginRepository.findById(tss.getProfile().getId()).isPresent()){
            throw new RuntimeException("O login informado não existe.");
        }
        if(isNull(tss.getAvgMin())) {
            throw new RuntimeException("O avg minimo deve ser informado");
        }
        if(isNull(tss.getExpPlat())) {
            throw new RuntimeException("O ExpPlat deve ser informado");
        }
        if(isNull(tss.getAvgHour())) {
            throw new RuntimeException("O avgHour deve ser informado");
        }
        if(isNull(tss.getExpContent())) {
            throw new RuntimeException("O ExpContent deve ser informado");
        }
    }
}
