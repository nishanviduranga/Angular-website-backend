package rc.springbootmongodbdemo.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Persistence;
import javax.persistence.Table;


@Setter
@Getter
@ToString
@Document(collection = "Student")
public class Student {
    @Id
    private int id;
    private String name;
    private String age;
    private String telephoneNumber;
    private String address;


}
