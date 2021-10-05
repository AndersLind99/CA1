package dtos;

import entities.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressDTO {
    private long id;
    private String street;
    private long additionalInfo;

    public AddressDTO(Address address) {
        if(address.getId() != null)
            this.id = address.getId();
        this.street = street;
        this.additionalInfo = additionalInfo;
    }


    public AddressDTO(String street, long additionalInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
    }

    public static List<AddressDTO> getDtos(List<Address> rms) {
        List<AddressDTO> rmdtos = new ArrayList();
        rms.forEach(hobby->rmdtos.add(new AddressDTO(address)));
        return rmdtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(long additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

}