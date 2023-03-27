package com.badmashCompany.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController// In this class we will be writing API endpoints
public class StudentController {
    Map<Integer,Student> db = new HashMap<>(); // database
    @GetMapping("/get_info")
   public Student getStudent(@RequestParam("rollNo") int rollNo)
    {
        
        return db.get(rollNo);  // need to fetch the value

        }
        @PostMapping("/addStudent")
        public String addStudent(@RequestBody Student student)
        {
            int key = student.getRollNo();
            db.put(key,student);
                    return "Student has been added successfully";
        }
        @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int rollNo)
        {
            db.remove(rollNo);
            return "Student deleted";
        }

}
