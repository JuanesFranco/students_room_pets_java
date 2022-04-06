package co.edu.umanizales.students_room_java.service;

import co.edu.umanizales.students_room_java.model.Average;
import co.edu.umanizales.students_room_java.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
        students.add(new Student("1234555",
                "Carlos Loaiza", 200000, 'M',
                true, "3016052808", true));
        students.add(new Student("2343434",
                "Lucas Villegas", 10000, 'M',
                true, "3057707378", false));
        students.add(new Student("23434343",
                "Catherine Betancurt", 0, 'F',
                false, "3057707378", true));
    }


    public List<Student> getAllStudents() {
        return students;
    }

    public float getPercentageByGender(char gender) {
        int count = 0;
        for (Student student : students) {
            if (student.getGender() == gender) {
                count++;
            }
        }
        return count / (float) students.size();
    }

    public List<Student> getStudentWork() {
        List<Student> studentsWork = new ArrayList<>();
        for (Student student : students) {
            if (student.isJob() == true && student.getSalary() > 1000000) {
                studentsWork.add(student);
            }
        }
        return studentsWork;
    }

    public List<Student> getStudentsWorkBySalary
            (char gender, double salary) {
        List<Student> studentsWork = new ArrayList<>();
        for (Student student : students) {
            if (student.isJob() && student.getGender() == gender
                    && student.getSalary() >= salary) {
                studentsWork.add(student);
            }
        }
        return studentsWork;
    }

    public List<Student> getStudentsBetweenSalaries(double min_salary, double max_salary) {
        List<Student> studentsBetweenSalaries = new ArrayList<>();
        for (Student student : students) {
            if (student.isJob() && student.getSalary() >= min_salary && student.getSalary() <= max_salary) {
                studentsBetweenSalaries.add(student);
            }
        }
        return studentsBetweenSalaries;
    }


        public List<Student> getStudentsZone(char final_number) {
            List<Student> studentsZone = new ArrayList<>();
            for (Student students : students) {
                if (students.isRural() && final_number == students.getIdentification().charAt(students.getIdentification().length() - 1)) {
                    studentsZone.add(students);
                }
            }
            return studentsZone;
        }

    public List<Student> getMayorSalaries() {
        List<Student> mayorSalaries = new ArrayList<>();
        Student M_Student = null;
        Student F_Student = null;
        for (Student student : students) {
            if (student.isJob()) {
                if ((student.getGender() == 'M' && M_Student == null)
                        || (student.getGender() == 'M' && student.getSalary() >
                        M_Student.getSalary())) {
                    M_Student = student;
                }
                if ((student.getGender() == 'F' && F_Student == null)
                        || (student.getGender() == 'F' && student.getSalary() >
                        F_Student.getSalary())) {
                    F_Student = student;
                }

            }
        }
        if (M_Student != null) {
            mayorSalaries.add(M_Student);
        }
        if (F_Student != null) {
            mayorSalaries.add(F_Student);
        }
        return mayorSalaries;

    }

     public List<Average> getAverageSalaries() {
         List<Average> averageSalaries = new ArrayList<>();
         int MenCount = 0;
         int WomenCount = 0;
         double TotalWomenSalary = 0;
         double TotalMenSalary = 0;
         for (Student student : students) {
             if (student.getGender() == 'M' && student.isJob()) {
                 MenCount++;
                 TotalMenSalary = TotalMenSalary + student.getSalary();
             }
             if (student.getGender() == 'F' && student.isJob()) {
                 WomenCount++;
                 TotalWomenSalary = TotalWomenSalary + student.getSalary();
             }
         }
         if (MenCount != 0) {
             averageSalaries.add(new Average('M', (TotalMenSalary / MenCount)));

         }
         if (WomenCount != 0) {
             averageSalaries.add(new Average('F', (TotalWomenSalary / WomenCount)));
         }
         return averageSalaries;

     }
}



