package br.com.javanei.platform.api.v1.mapper;

import java.util.List;

import br.com.javanei.platform.api.v1.vo.PlatformListVO;
import br.com.javanei.platform.api.v1.vo.PlatformVO;
import br.com.javanei.platform.service.PlatformDTO;

public class PlatformMapper {
    public static PlatformDTO toDTO(PlatformVO vo) {
        return new PlatformDTO().setId(vo.getId()).setName(vo.getName()).setShortName(vo.getShortName())
                .setAlternateNames(vo.getAlternateNames()).setSsId(vo.getSsId()).setEsCode(vo.getEsCode())
                .setRomFileExtensions(vo.getRomFileExtensions());
    }

    public static PlatformVO toVO(PlatformDTO dto) {
        return new PlatformVO().setId(dto.getId()).setName(dto.getName()).setShortName(dto.getShortName())
                .setAlternateNames(dto.getAlternateNames()).setSsId(dto.getSsId()).setEsCode(dto.getEsCode())
                .setRomFileExtensions(dto.getRomFileExtensions());
    }

    public static PlatformListVO toListVO(List<PlatformDTO> list) {
        PlatformListVO result = new PlatformListVO();
        for (PlatformDTO dto : list) {
            result.add(toVO(dto));
        }
        return result;
    }
}
