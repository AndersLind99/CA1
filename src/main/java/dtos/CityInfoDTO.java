package dtos;

import entities.Address;
import entities.CityInfo;

import java.util.ArrayList;
import java.util.List;

public class CityInfoDTO {
    private long zipCode;
    private String city;

    public CityInfoDTO(CityInfo cityInfo) {

        if (cityInfo.getZipCode() != null)
            this.zipCode = cityInfo.getZipCode();
        this.zipCode = cityInfo.getZipCode();
        this.city = cityInfo.getCity();
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
