package co.edu.umanizales.students_room_java.model;

import lombok.Data;

@Data
public class Node {
    private Pet data;
    private Node next;

    public Node(Pet data) {
        this.data = data;
    }
}
