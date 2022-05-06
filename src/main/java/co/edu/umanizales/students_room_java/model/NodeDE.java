package co.edu.umanizales.students_room_java.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class NodeDE {
    private Pet data;
    private NodeDE next;
    private NodeDE previous;

    public NodeDE(Pet data) {
        this.data = data;
    }

}
