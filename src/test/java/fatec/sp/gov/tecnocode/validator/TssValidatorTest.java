package fatec.sp.gov.tecnocode.validator;

import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.model.Tss;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TssValidatorTest {
    @Autowired
    private Map<Operation, TssValidator> validator;

    @Test
    public void givenAValidTssData_whenTryToValidate_thenShouldSuccess() {
        Tss tss = Tss.builder()
                .profile(Profile.builder().id(1l).build())
                .avgMin(12)
                .expPlat(662.1)
                .avgHour(6)
                .expContent(1154.5)
                .build();

        assertDoesNotThrow(() -> validator.get(Operation.INSERT).validate(tss));
        assertDoesNotThrow(() -> validator.get(Operation.UPDATE).validate(tss));
    }

    @Test
    public void givenAnInvalidProfileData_whenTryToValidate_thenThrowsException() {
        Tss tss1 = Tss.builder()
                .avgMin(12)
                .expPlat(662.1)
                .avgHour(6)
                .expContent(1154.5)
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(tss1));
        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(tss1));

        Tss tss2 = Tss.builder()
                .expPlat(662.1)
                .avgHour(6)
                .expContent(1154.5)
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(tss2));
        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(tss2));

        Tss tss3 = Tss.builder()
                .avgHour(6)
                .expContent(1154.5)
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(tss3));
        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(tss3));

        Tss tss4 = Tss.builder()
                .expContent(1154.5)
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(tss4));
        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(tss4));

        Tss tss5 = Tss.builder()
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(tss5));
        assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(tss5));
    }
}
