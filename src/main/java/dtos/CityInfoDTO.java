package dtos;

import entities.CityInfo;

import java.util.ArrayList;
import java.util.List;

public class CityInfoDTO {
    private long id;
    private long zipCode;
    private String city;

    public CityInfoDTO(CityInfo cityInfo) {
        if(cityInfo.getId() != null)
            this.id = cityInfo.getId();
        this.zipCode = zipCode;
        this.city = city;
    }

    public CityInfoDTO(long zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;

    }

    public static List<CityInfoDTO> getDtos(List<CityInfo> rms) {
        List<CityInfoDTO> rmdtos = new ArrayList();
        rms.forEach(cityInfo->rmdtos.add(new CityInfoDTO(cityInfo)));
        return rmdtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
