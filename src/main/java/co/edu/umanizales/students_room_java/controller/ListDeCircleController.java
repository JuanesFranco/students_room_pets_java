package co.edu.umanizales.students_room_java.controller;

import co.edu.umanizales.students_room_java.model.Node;
import co.edu.umanizales.students_room_java.model.Pet;
import co.edu.umanizales.students_room_java.service.ListSeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="listdec")
public class ListDeCircleController {
    @Autowired
    private ListSeService listDeService;

    @GetMapping
    public Node getAllLinked()
    {
        return listDeService.getAllLinked();
    }

    @PostMapping
    public String createPet(@RequestBody Pet pet)
    {
        return listDeService.add(pet);
    }

    @PostMapping(path="/tostart")
    public String createPetToStart(@RequestBody Pet pet){
        return listDeService.addToStart(pet);
    }
    
    @GetMapping(path="/toinvert")
    public String invert(){
        return listDeService.invert();
    }
}


