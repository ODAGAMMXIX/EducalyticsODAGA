package fatec.sp.gov.tecnocode.converter;

import fatec.sp.gov.tecnocode.model.Tss;
import fatec.sp.gov.tecnocode.payload.TssDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TssToDtoConverter implements Converter<Tss, TssDto> {
    @Override
    public TssDto convert(Tss tss) {
        return TssDto.builder()
                .profile(tss.getProfile())
                .avgMin(tss.getAvgMin())
                .expPlat(tss.getExpPlat())
                .avgHour(tss.getAvgHour())
                .expContent(tss.getExpContent())
                .build();
    }
}
