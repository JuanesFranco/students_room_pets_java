package co.edu.umanizales.students_room_java.service;

import co.edu.umanizales.students_room_java.model.ListDECircle;
import co.edu.umanizales.students_room_java.model.NodeDE;
import co.edu.umanizales.students_room_java.model.Pet;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ListDeCircleService {
    private ListDECircle list = new ListDECircle();
    public NodeDE getAllLinked(){
        return this.list.getHead();
    }

    public String addToStart(Pet pet){
        this.list.addToStart(pet);
        return "Adicionado con éxito";
    }

    public String add(Pet pet){
        this.list.add(pet);
        return "Adicionado con éxito";
    }

}


