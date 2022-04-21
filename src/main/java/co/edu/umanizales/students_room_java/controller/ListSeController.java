package co.edu.umanizales.students_room_java.controller;

import co.edu.umanizales.students_room_java.model.Node;
import co.edu.umanizales.students_room_java.model.Pet;
import co.edu.umanizales.students_room_java.service.ListSeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="listse")
public class ListSeController {
    @Autowired
    private ListSeService listSeService;
    @GetMapping
    public Node getAllLinked()
    {
        return listSeService.getAllLinked();
    }

    @PostMapping
    public String cratePet(@RequestBody Pet pet)
    {
        return listSeService.add(pet);
    }
}
