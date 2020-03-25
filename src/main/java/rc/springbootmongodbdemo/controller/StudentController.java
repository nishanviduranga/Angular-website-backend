package rc.springbootmongodbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rc.springbootmongodbdemo.model.Student;

import rc.springbootmongodbdemo.service.StudentService;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping({"/Student"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudent")
    public List<Student> getStudents() {
        System.out.println(" nj mj");
        return studentService.getAllStudents();
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){
        System.out.println("student get from database");
        return studentService.save(student);
    }
    @GetMapping("/studentID/{id}")
    public Student getStudent(@PathVariable int id) {

        return studentService.getStudent(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteById(id);
        return "student deleted with id :"+id;
    }
//    @PutMapping("/updateStudent/{id}")
//    public void update(@RequestBody Student student){
//        this.studentsRepository.save(student);
//    }
    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable Integer id, @Valid @RequestBody Student studentNewDetails) {

        return studentService.updateStudent(id, studentNewDetails);
    }



}
