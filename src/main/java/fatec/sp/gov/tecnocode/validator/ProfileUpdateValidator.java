package fatec.sp.gov.tecnocode.validator;

import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class ProfileUpdateValidator implements ProfileValidator{
    private final ProfileRepository profileRepository;

    @Override
    public void validate(Profile profile) {
        if(isNull(profile.getId())) {
            throw new RuntimeException("O ID perfil deverá ser informado.");
        }
        if(!profileRepository.findById(profile.getId()).isPresent()) {
            throw new RuntimeException("O perfil informado para atualizar não existe.");
        }
    }
}
