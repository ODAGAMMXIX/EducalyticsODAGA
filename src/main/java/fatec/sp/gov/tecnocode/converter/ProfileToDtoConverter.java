package fatec.sp.gov.tecnocode.converter;

import fatec.sp.gov.tecnocode.model.Profile;
import fatec.sp.gov.tecnocode.payload.ProfileDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProfileToDtoConverter implements Converter<Profile, ProfileDto> {
    @Override
    public ProfileDto convert(Profile profile){
        return ProfileDto.builder()
                .name(profile.getName())
                .email(profile.getEmail())
                .createdAt(profile.getCreatedAt())
                .build();
    }
}
