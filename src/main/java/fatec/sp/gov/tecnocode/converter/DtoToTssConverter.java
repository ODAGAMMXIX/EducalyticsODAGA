package fatec.sp.gov.tecnocode.converter;

import fatec.sp.gov.tecnocode.model.Tss;
import fatec.sp.gov.tecnocode.payload.TssDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToTssConverter implements Converter<TssDto, Tss> {
    @Override
    public Tss convert(TssDto tssDto) {
        return Tss.builder()
                .profile(tssDto.getProfile())
                .avgMin(tssDto.getAvgMin())
                .expPlat(tssDto.getExpPlat())
                .avgHour(tssDto.getAvgHour())
                .expContent(tssDto.getExpContent())
                .build();
    }
}
