package com.studentreg;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	public List<Students> getAllStudents(){
		
		return studentsRepository.findAll();
	}
	
	public Students saveStudents( Students student) {
		
		return studentsRepository.save(student);
	}

	public Optional<Students> findById(String id) {
		// TODO Auto-generated method stub
		return studentsRepository.findById(id) ;
	}
	
	public ResponseEntity<String> updateStudentById(Students student,String id){
		
		Optional<Students> tempStudent = studentsRepository.findById(id);
		if(tempStudent.isPresent()) {
			student.setId(id);
			studentsRepository.save(student);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

		
	}

	public ResponseEntity<Students> deleteById(String id) {
		
		Optional<Students> student = studentsRepository.findById(id);
		if(student.isPresent()) {
			studentsRepository.deleteById(id);
			return new ResponseEntity<Students>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
        
	}

	public ResponseEntity<Students> modifyStudentById( Students student, String id) {
		
		Optional<Students> tempStudent = studentsRepository.findById(id);
		
		if(tempStudent.isPresent()) {
			if(student.getFirstName()!=null) {
				Students student1 = tempStudent.get();
				student1.setFirstName(student.getFirstName());
			    studentsRepository.save(student1);
			    return new ResponseEntity<Students>(student1, HttpStatus.OK);
			}
			
		}
		
		return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
	}

	

}







