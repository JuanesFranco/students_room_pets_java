package co.edu.umanizales.students_room_java.service;

import co.edu.umanizales.students_room_java.model.ListSE;
import co.edu.umanizales.students_room_java.model.Node;
import co.edu.umanizales.students_room_java.model.NodeDE;
import co.edu.umanizales.students_room_java.model.Pet;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ListSECircleService {
    private ListSE list = new ListSE();

    public Node getAllLinked(){
        return this.list.getHead();
    }

    public String add(Pet pet){
        this.list.add(pet);
        return "Adicionado con éxito";
    }

    public String addToStart(Pet pet){
        this.list.addToStart(pet);
        return "Adicionado con éxito";
    }

    public String invert()
    {
        try {
            this.list.invert();
            return "Invertido con éxito.";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
}
