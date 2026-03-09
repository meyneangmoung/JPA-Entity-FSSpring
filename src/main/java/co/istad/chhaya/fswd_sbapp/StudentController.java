package co.istad.chhaya.fswd_sbapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class StudentController {
    @GetMapping ("api/student")
    public List <Student> getStudent(){
        Student student = Student.builder()
                .name("Meyneang")
                .gender("Female")
                .Course("Spring boot")
                .build();
        return List.of(student);
    }
}


