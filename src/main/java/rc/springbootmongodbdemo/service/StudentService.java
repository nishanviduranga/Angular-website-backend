package rc.springbootmongodbdemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import rc.springbootmongodbdemo.model.Student;
import rc.springbootmongodbdemo.repository.StudentsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentsRepository studentsRepository;



    public Student updateStudent(Integer id, Student studentNewDetails) {

        Student student = studentsRepository.findStudentById(id);
        if (student != null) {
//                student.setName(studentNewDetails.getName());
//                student.setAddress(studentNewDetails.getAddress());
//                student.setAge(studentNewDetails.getAge());
//                student.setTelephoneNumber(studentNewDetails.getTelephoneNumber());

            studentNewDetails.setId(student.getId());

            studentNewDetails = studentsRepository.save(studentNewDetails);

        } else {
            throw new ResourceNotFoundException("Student", "empNo", id);
        }

        return studentNewDetails;

    }

    public List<Student> getAllStudents() {

        return studentsRepository.findAll();
    }


    public Student save(Student student) {
        return studentsRepository.save(student);
    }

    public HttpStatus deleteById(int id) {

        Student student = studentsRepository.findStudentById(id);
            System.out.println("called");
            if(student!=null){
                studentsRepository.delete(student);
            }
            else{
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }
//                .orElseThrow(()-> new ResourceNotFoundException("Student", "id", id));
            return HttpStatus.OK;
        }


    public Student getStudent(int id) {
        Optional<Student> student = studentsRepository.findById(id);
        Student resultStudent = new Student();
        if(student.isPresent()){
            resultStudent = student.get();            
        }
        return resultStudent;

    }


}






