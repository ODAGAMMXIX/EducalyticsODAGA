package fatec.sp.gov.tecnocode.service.impl;

import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.model.Tss;
import fatec.sp.gov.tecnocode.repository.TssRepository;
import fatec.sp.gov.tecnocode.service.TssService;
import fatec.sp.gov.tecnocode.validator.TssValidator;
import fatec.sp.gov.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TssServiceImpl implements TssService {
    private final TssRepository repository;
    private final Map<Operation, TssValidator> validator;

    @Override
    public Tss save(final Tss tss, final Operation operation) {
        validator.get(operation).validate(tss);
        return repository.saveAndFlush(tss);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Tss> buscarTssPerfil(Profile profile) {
        return repository.findAllByProfile(profile);
    }

    @Override
    public List<Tss> buscarTodosAvgMin(Integer avgMin) {
        return repository.findAllByAvgMin(avgMin);
    }

    @Override
    public List<Tss> buscarTodosExpPlat(Double expPlat) {
        return repository.findAllByExpPlat(expPlat);
    }

    @Override
    public List<Tss> buscarTodosAvgHour(Integer avgHour) {
        return repository.findAllByAvgHour(avgHour);
    }

    @Override
    public List<Tss> buscarTodosExpContent(Double expContent) {
        return repository.findAllByExpContent(expContent);
    }

    @Override
    public List<Tss> buscarTodosTss(){
        return repository.findAll();
    }
}
