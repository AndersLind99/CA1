package dtos;

import entities.Hobby;

import java.util.ArrayList;
import java.util.List;

public class HobbyDTO {
    private long id;
    private String name;
    private String description;

    public HobbyDTO(Hobby hobby) {
        if(hobby.getId() != null)
            this.id = hobby.getId();
        this.name = name;
        this.description = description;
    }

//    public List<HobbyDTO> Hobbies(List<Hobby> hobbyList){
//
//        List<HobbyDTO> hobbyDTOList = null;
//
//        for (Hobby hobby: hobbyList) {
//
//            hobbyDTOList.add(new HobbyDTO(hobby.getName(),hobby.getDescription()));
//
//        }
//
//        return hobbyDTOList;
//
//    }

    public HobbyDTO(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public static List<HobbyDTO> getDtos(List<Hobby> rms){
        List<HobbyDTO> rmdtos = new ArrayList();
        rms.forEach(hobby->rmdtos.add(new HobbyDTO(hobby)));
        return rmdtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
