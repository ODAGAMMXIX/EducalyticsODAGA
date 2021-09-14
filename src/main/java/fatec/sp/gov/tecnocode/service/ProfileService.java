package fatec.sp.gov.tecnocode.service;

import fatec.sp.gov.tecnocode.model.Login;
import fatec.sp.gov.tecnocode.model.Profile;

import java.util.List;

public interface ProfileService extends GenericService<Profile> {
    List<Profile> buscarEstePerfil(Login login);

    List<Profile> buscarTodosPeloNome(String name);

    List<Profile> buscarTodosPeloEmail(String email);

    List<Profile> buscarTodosPerfis();
}
