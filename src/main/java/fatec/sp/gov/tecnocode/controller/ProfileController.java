package fatec.sp.gov.tecnocode.controller;

import fatec.sp.gov.tecnocode.converter.DtoToProfileConverter;
import fatec.sp.gov.tecnocode.converter.ProfileToDtoConverter;
import fatec.sp.gov.tecnocode.model.Login;
import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.payload.ProfileDto;
import fatec.sp.gov.tecnocode.service.ProfileService;
import fatec.sp.gov.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService service;
    private final DtoToProfileConverter dtoToProfileConverter;
    private final ProfileToDtoConverter profileToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final ProfileDto profileDto) {
        try {
            Profile profile = service.save(dtoToProfileConverter.convert(profileDto), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(profileToDtoConverter.convert(profile));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping
    public List<Profile> buscarTodosPerfis() {
        return service.buscarTodosPerfis();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{login}")
    public List<Profile> buscarEstePerfil(@PathVariable("login") Login login) {
        return service.buscarEstePerfil(login);
    }

    @GetMapping("/{name}")
    public List<Profile> buscarTodosPeloNome(@PathVariable("name") String name) {
        return service.buscarTodosPeloNome(name);
    }

    @GetMapping("/{email}")
    public List<Profile> buscarTodosPeloEmail(@PathVariable("email") String email) {
        return service.buscarTodosPeloEmail(email);
    }
}
