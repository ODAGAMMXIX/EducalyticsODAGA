package fatec.sp.gov.tecnocode.converter;

import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.payload.ProfileDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToProfileConverter implements Converter<ProfileDto, Profile> {
    @Override
    public Profile convert(ProfileDto profileDto) {
        return Profile.builder()
                .name(profileDto.getName())
                .email(profileDto.getEmail())
                .createdAt(profileDto.getCreatedAt())
                .build();
    }
}
