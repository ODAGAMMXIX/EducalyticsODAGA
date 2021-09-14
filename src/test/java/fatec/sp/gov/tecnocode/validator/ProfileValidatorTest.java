package fatec.sp.gov.tecnocode.validator;

import fatec.sp.gov.tecnocode.model.Login;
import fatec.sp.gov.tecnocode.model.Profile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import fatec.sp.gov.tecnocode.validator.AbstractValidator;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ProfileValidatorTest {
    @Autowired
    private Map<Operation, ProfileValidator> validator;

    @Test
    public void givenAValidProfileData_whenTryToValidate_thenShouldSuccess() {
        LocalDate birth = LocalDate.of(2001,2,5);
        Profile profile = Profile.builder()
                .login(Login.builder().id(1l).build())
                .cpf("123.456.789-10")
                .name("Gabriela")
                .email("gabrielarodrigues@hotmail.com")
                .phone("+551298173-2403")
                .genre("feminino")
                .birth(birth)
                .build();
        assertDoesNotThrow(() -> validator.get(Operation.INSERT).validate(profile));
        assertDoesNotThrow(() -> validator.get(Operation.UPDATE).validate(profile));

    }

    @Test
    public void givenAnInvalidProfileData_whenTryToValidate_thenThrowsException(){
        LocalDate birth = LocalDate.of(2001,2,5);
        Profile profile1 = Profile.builder()
                .cpf("123.456.789-10")
                .name("Gabriela")
                .email("gabrielarodrigues@hotmail.com")
                .phone("+551298173-2403")
                .genre("feminino")
                .birth(birth)
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(profile1));
        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(profile1));

        Profile profile2 = Profile.builder()
                .cpf("")
                .name("Gabriela")
                .email("gabrielarodrigues@hotmail.com")
                .phone("+551298173-2403")
                .genre("feminino")
                .birth(birth)
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(profile2));
        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(profile2));

        Profile profile3 = Profile.builder()
                .cpf("")
                .name("")
                .email("gabrielarodrigues@hotmail.com")
                .phone("+551298173-2403")
                .genre("feminino")
                .birth(birth)
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(profile3));
        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(profile3));

        Profile profile4 = Profile.builder()
                .cpf("")
                .name("")
                .email("")
                .phone("+551298173-2403")
                .genre("feminino")
                .birth(birth)
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(profile4));
        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(profile4));

        Profile profile5 = Profile.builder()
                .cpf("")
                .name("")
                .email("")
                .phone("")
                .genre("feminino")
                .birth(birth)
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(profile5));
        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(profile5));

        Profile profile6 = Profile.builder()
                .cpf("")
                .name("")
                .email("")
                .phone("")
                .genre("")
                .birth(birth)
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(profile6));
        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(profile6));

        Profile profile7 = Profile.builder()
                .cpf("")
                .name("")
                .email("")
                .phone("")
                .genre("")
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(profile7));
        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(profile7));
    }

}
