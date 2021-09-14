package fatec.sp.gov.tecnocode.controller;

import fatec.sp.gov.tecnocode.converter.DtoToTssConverter;
import fatec.sp.gov.tecnocode.converter.TssToDtoConverter;
import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.model.Tss;
import fatec.sp.gov.tecnocode.payload.TssDto;
import fatec.sp.gov.tecnocode.service.TssService;
import fatec.sp.gov.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tss")
@RequiredArgsConstructor
public class TssController {
    private final TssService service;
    private final DtoToTssConverter dtoToTssConverter;
    private final TssToDtoConverter tssToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final TssDto tssDto) {
        try{
            Tss tss = service.save(dtoToTssConverter.convert(tssDto), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(tssToDtoConverter.convert(tss));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping
    public List<Tss> buscarTodosTss() {
        return service.buscarTodosTss();
    }

    @GetMapping("/{login}")
    public List<Tss> buscarTssPerfil(@PathVariable("profile") Profile profile) {
        return service.buscarTssPerfil(profile);
    }

    @GetMapping("/{avgMin}")
    public List<Tss> buscarTodosAvgMin(@PathVariable("avgMin") Integer avgMin) {
        return service.buscarTodosAvgMin(avgMin);
    }

    @GetMapping("/{expPlat}")
    public List<Tss> buscarTodosExpPlat(@PathVariable("expPlat") Double expPlat) {
        return service.buscarTodosExpPlat(expPlat);
    }

    @GetMapping("/{avgHour}")
    public List<Tss> buscarTodosAvgHour(@PathVariable("avgMin") Integer avgHour) {
        return service.buscarTodosAvgHour(avgHour);
    }

    @GetMapping("/{expContent}")
    public List<Tss> buscarTodosExpContent(@PathVariable("expContent") Double expContent) {
        return service.buscarTodosExpContent(expContent);
    }
}
