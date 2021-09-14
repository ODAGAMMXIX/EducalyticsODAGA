package fatec.sp.gov.tecnocode.validator;

import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class ProfileInsertValidator implements ProfileValidator {
    private final LoginRepository loginRepository;

    @Override
    public void validate(Profile profile) {
        if(!isNull(profile.getId())) {
            throw new RuntimeException("O Id deste perfil é gerado automaticamente.");
        }
        if(isNull(profile.getLogin()) || isNull(profile.getLogin().getId())) {
            throw new RuntimeException("O login não pode ser vazio.");
        }
        if(!loginRepository.findById(profile.getLogin().getId()).isPresent()){
            throw new RuntimeException("O login informado não existe.");
        }
        if(profile.getCpf().isEmpty()){
            throw new RuntimeException("O CPF naõ pode ser vazio.");
        }
        if(profile.getName().isEmpty()){
            throw new RuntimeException("O nome não pode ser vazio.");
        }
        if(profile.getEmail().isEmpty()){
            throw new RuntimeException("O email não pode ser vazio.");
        }
        if(profile.getPhone().isEmpty()){
            throw new RuntimeException("O telefone não pode ser vazio.");
        }
        if(profile.getGenre().isEmpty()){
            throw new RuntimeException("O genero não pode ser vazio");
        }
        if(isNull(profile.getBirth())){
            throw new RuntimeException("O aniversário não pode ser vazio");
        }
    }

}
