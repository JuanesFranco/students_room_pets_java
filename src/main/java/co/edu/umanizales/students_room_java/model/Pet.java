package co.edu.umanizales.students_room_java.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pet {
    private String id;
    private String name;
    private byte age;
    private String breed;
    private char Gender;//M:macho,H:hembra
}
