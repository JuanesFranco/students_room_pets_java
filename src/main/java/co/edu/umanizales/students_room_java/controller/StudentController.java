package co.edu.umanizales.students_room_java.controller;

import co.edu.umanizales.students_room_java.model.Average;
import co.edu.umanizales.students_room_java.model.Student;
import co.edu.umanizales.students_room_java.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(path = "student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/percentage/{gender}")
    public float getPercentageByGender(@PathVariable char gender) {
        return studentService.getPercentageByGender(gender);
    }

    @GetMapping(path = "/studentwork")
    public List<Student> getStudentsWork() {
        return studentService.getStudentWork();
    }

    @GetMapping(path = "/studentsworkbysalary/{gender}{salary}")
    public List<Student> getStudentsWorkBySalary
            (@PathVariable char gender,
             @PathVariable double salary) {
        return studentService.getStudentsWorkBySalary(gender, salary);
    }

    @GetMapping(path = "/students/{final_number}")
    public List<Student> getStudentsZone(@PathVariable char final_number) {
        return studentService.getStudentsZone(final_number);
    }

    @GetMapping(path = "/between/{min_salary}/{max_salary}")
    public List<Student> getStudentsBetweenSalaries(@PathVariable double min_salary, @PathVariable double max_salary) {
        return studentService.getStudentsBetweenSalaries(min_salary, max_salary);
    }

    @GetMapping(path = "/average")
    public List<Average> getAverageSalaries() {
        return studentService.getAverageSalaries();
    }
}
