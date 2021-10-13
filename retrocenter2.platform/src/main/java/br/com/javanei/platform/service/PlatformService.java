package br.com.javanei.platform.service;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlatformService {
    public PlatformDTO create(PlatformDTO dto) {
        return dto;
    }

    public PlatformDTO findById(Long id) {
        return new PlatformDTO().setId(id).setName(String.format("Platform %d", id));
    }

    public List<PlatformDTO> find(String name, String alternateName, int page, int pageSize) {
        List<PlatformDTO> result = new LinkedList<>();
        for (int i = 0; i < pageSize; i++) {
            PlatformDTO vo = new PlatformDTO().setId((long) (i + (page * pageSize) + 1));
            vo.setName(String.format("Platform %d", vo.getId()));
            result.add(vo);
        }
        return result;
    }
}
