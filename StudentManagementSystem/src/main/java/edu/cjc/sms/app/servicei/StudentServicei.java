package edu.cjc.sms.app.servicei;

import java.util.List;

import edu.cjc.sms.app.model.Student;


public interface StudentServicei {
	
	public void saveStudentData(Student s);
	public List<Student> getAllStudents();
	public void deleteStudent(int rollno);
	public List<Student> searchStudentByBatch(String batchNumber, String batchMode);
	public Student getSelectedStudent(int studentId);
	public void currentPaidFees(int studentId, double ammount);
	public Student getforBatchShiftingStudent(int studentId);
	public void newbatchShift(int studentId, String batchNumber);
	
}
