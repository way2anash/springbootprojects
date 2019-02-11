package com.studentreg;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {

	@Autowired
	private StudentsService studentsService;
	
	//get All students list
	@GetMapping("/students")
	public List<Students> getAllStudentsList() {
		
		return studentsService.getAllStudents();
	}
	
	//registering students
	@PostMapping("/students")
	public Students regStudents(@RequestBody Students student) {
		
		return studentsService.saveStudents(student);
	}
	
	//Get Student by id
	@GetMapping("/students/{id}")
	public ResponseEntity<Students> getStudentById(@PathVariable("id") String id) {
		
		Optional<Students> student= studentsService.findById(id);
		//Students tempStudents = student.get();
		if (student.isPresent()) {
			return new ResponseEntity<Students>(student.get(),HttpStatus.OK);
            
        }
		return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
	}
	
	//overriding Student by put http method
	@PutMapping("/students/{id}")
	public ResponseEntity<String> updateStudentById(@RequestBody Students updateStudent, @PathVariable("id") String id) {
		
		return studentsService.updateStudentById(updateStudent, id);
		
	}
	
	//modify student using patch http method
	@PatchMapping("/students/{id}")
	public ResponseEntity<Students> modifyStudent(@RequestBody Students student, @PathVariable("id") String id) {
		
		return studentsService.modifyStudentById(student,id);
	}
	
	
	//Delete Student by id
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Students> deleteStudent(@PathVariable String id) {
		
		 return studentsService.deleteById(id);
	}
}
