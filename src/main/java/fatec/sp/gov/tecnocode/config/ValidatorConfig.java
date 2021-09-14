package fatec.sp.gov.tecnocode.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fatec.sp.gov.tecnocode.validator.Operation;
import fatec.sp.gov.tecnocode.validator.ProfileValidator;
import fatec.sp.gov.tecnocode.validator.TssValidator;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ValidatorConfig {

    @Bean
    public Map<Operation, ProfileValidator> profileValidators(
            final @Qualifier("profileInsertValidator") ProfileValidator profileInsertValidator,
            final @Qualifier("profileUpdateValidator") ProfileValidator profileUpdateValidator) {
        final Map<Operation, ProfileValidator> map = new HashMap<>();
        map.put(Operation.INSERT, profileInsertValidator);
        map.put(Operation.UPDATE, profileUpdateValidator);
        return Collections.unmodifiableMap(map);
    }

    @Bean
    public Map<Operation, TssValidator> tssValidators(
            final @Qualifier("tssInsertValidator") TssValidator tssInsertValidator,
            final @Qualifier("tssUpdateValidator") TssValidator tssUpdateValidator) {
        final Map<Operation, TssValidator> map = new HashMap<>();
        map.put(Operation.INSERT, tssInsertValidator);
        map.put(Operation.UPDATE, tssUpdateValidator);
        return Collections.unmodifiableMap(map);
    }
}
