package br.com.javanei.platform.api.vo;

import java.util.LinkedList;
import java.util.List;

public class PlatformVO {
    private Long id;
    private String name;
    private String shortName;
    private List<String> alternateNames = new LinkedList<>();
    private Integer ssId;
    private String esCode;
    private String romFileExtensions;

    public Long getId() {
        return id;
    }

    public PlatformVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlatformVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public PlatformVO setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public List<String> getAlternateNames() {
        return alternateNames;
    }

    public PlatformVO setAlternateNames(List<String> alternateNames) {
        this.alternateNames = alternateNames;
        return this;
    }

    public Integer getSsId() {
        return ssId;
    }

    public PlatformVO setSsId(Integer ssId) {
        this.ssId = ssId;
        return this;
    }

    public String getEsCode() {
        return esCode;
    }

    public PlatformVO setEsCode(String esCode) {
        this.esCode = esCode;
        return this;
    }

    public String getRomFileExtensions() {
        return romFileExtensions;
    }

    public PlatformVO setRomFileExtensions(String romFileExtensions) {
        this.romFileExtensions = romFileExtensions;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PlatformVO other = (PlatformVO) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PlatformDTO [alternateNames=" + alternateNames + ", esCode=" + esCode + ", id=" + id + ", name=" + name
                + ", romFileExtensions=" + romFileExtensions + ", shortName=" + shortName + ", ssId=" + ssId + "]";
    }
}
