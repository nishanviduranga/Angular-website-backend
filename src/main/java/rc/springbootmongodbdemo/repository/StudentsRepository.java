package rc.springbootmongodbdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rc.springbootmongodbdemo.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends MongoRepository<Student , Integer> {


    Student findStudentById(Integer id);


    List<Student> findAllBy(Integer id);
}
