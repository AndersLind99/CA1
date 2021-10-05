package dtos;

import entities.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneDTO {
    private long id;
    private long number;
    private String description;

    public PhoneDTO(Phone phone) {
        if(phone.getId() != null)
            this.id = phone.getId();
        this.number = number;
        this.description = description;
    }

    public PhoneDTO(long number, String description) {
        this.number = number;
        this.description = description;

    }

    public static List<PhoneDTO> getDtos(List<Phone> rms) {
        List<PhoneDTO> rmdtos = new ArrayList();
        rms.forEach(phone->rmdtos.add(new PhoneDTO(phone)));
        return rmdtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
