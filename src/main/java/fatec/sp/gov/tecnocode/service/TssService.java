package fatec.sp.gov.tecnocode.service;

import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.model.Tss;

import java.util.List;

public interface TssService extends GenericService<Tss> {
    List<Tss> buscarTssPerfil(Profile profile);

    List<Tss> buscarTodosAvgMin(Integer avgMin);

    List<Tss> buscarTodosExpPlat(Double expPlat);

    List<Tss> buscarTodosAvgHour(Integer avgHour);

    List<Tss> buscarTodosExpContent(Double expContent);

    List<Tss> buscarTodosTss();
}
