package br.com.javanei.platform.api.v1.vo;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name="PlatformList", description="POJO representing the list of platforms")
public class PlatformListVO {
    @Schema(required = true)
    private List<PlatformVO> platforms = new LinkedList<>();

    public List<PlatformVO> getPlatforms() {
        return platforms;
    }

    public PlatformListVO setPlatforms(List<PlatformVO> platforms) {
        this.platforms = platforms;
        return this;
    }
    
    public void add(PlatformVO platform) {
        platforms.add(platform);
    }

    public int getSize() {
        return platforms.size();
    }
}
