package fatec.sp.gov.tecnocode.service.impl;

import fatec.sp.gov.tecnocode.model.Login;
import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.repository.ProfileRepository;
import fatec.sp.gov.tecnocode.service.ProfileService;
import fatec.sp.gov.tecnocode.validator.ProfileValidator;
import fatec.sp.gov.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final Map<Operation, ProfileValidator> validator;

    @Override
    public Profile save(final Profile profile, final Operation operation) {
        validator.get(operation).validate(profile);
        return null; //repository.saveAndFlush(profile);
    }

    @Override
    public void delete(Long id) {
        //repository.deleteById(id);
    }

    @Override
    public List<Profile> buscarEstePerfil(Login login) {
        return null; //repository.findAllByProfile(login);
    }

    @Override
    public List<Profile> buscarTodosPeloNome(String name) {

        return null; //repository.findAllByName(name);
    }

    @Override
    public List<Profile> buscarTodosPeloEmail(String email) {
        return null; // repository.findAllByEmail(email);
    }

    @Override
    public List<Profile> buscarTodosPerfis() {
        return null; // repository.findAll();
    }
}
