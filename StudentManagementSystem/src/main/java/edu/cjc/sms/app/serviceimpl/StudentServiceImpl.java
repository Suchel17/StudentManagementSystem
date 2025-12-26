package edu.cjc.sms.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.repository.StudentRepository;
import edu.cjc.sms.app.servicei.StudentServicei;

@Service
public class StudentServiceImpl implements StudentServicei {

	@Autowired
	StudentRepository sr;
	
	@Override
	public void saveStudentData(Student s) {
		
		sr.save(s);
	}

	@Override
	public List<Student> getAllStudents() {
		
		return sr.findAll() ;
	}

	@Override
	public void deleteStudent(int rollno) {
		
		sr.deleteById(rollno);
		
	}

}
