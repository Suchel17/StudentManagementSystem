package edu.cjc.sms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.servicei.StudentServicei;

@Controller
public class AdminController {
	
	@Autowired
	StudentServicei ssi;

	@RequestMapping("/")
	public String preLogin() {
		
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model m) {
		
		if(username.equals("admin") && password.equals("admin"))
		{
			List<Student> list = ssi.getAllStudents();
			m.addAttribute("data", list);
			
			return "adminscreen";
		}
		else {
			m.addAttribute("login_fail", "Enter valid username and password");
			return "login";
		}
		
	}
	
	@RequestMapping("/enroll_student")
	public String saveStudentDetails(@ModelAttribute Student s, Model m) {
		
		ssi.saveStudentData(s);
		
		List<Student> list = ssi.getAllStudents();
		m.addAttribute("data", list);
		
		return "adminscreen";
	}
	
	@RequestMapping("/delete")
	public String removeStudent(@RequestParam("rollno") int rollno, Model m) {
			
		ssi.deleteStudent(rollno);
		
		List<Student> list = ssi.getAllStudents();
		m.addAttribute("data", list);
		
		return "adminscreen";
	}
	
	@RequestMapping("/search")
	public String getStudentBatch(@RequestParam("batchNumber") String batchNumber,@RequestParam("batchMode") String batchMode, Model m) {
		
		List<Student> list = ssi.searchStudentByBatch(batchNumber, batchMode);
		
		if(list.size()>0) {
			m.addAttribute("data", list);
		}
		else {
			List<Student> alllist = ssi.getAllStudents();
			m.addAttribute("data", alllist);
			m.addAttribute("message", "NO records are available for the batch" + batchNumber);
		}

		return "adminscreen";
	}
	
	@RequestMapping("/fees")
	public String payFees(@RequestParam("rollno") int studentId, Model m) {
		
		Student stu = ssi.getSelectedStudent(studentId);
		m.addAttribute("stu", stu);
		
		return "fees";
	}
	
	@RequestMapping("/payfees")
	public String paidfees(@RequestParam("studentId") int studentId, @RequestParam("ammount") double ammount, Model m) {
		
		ssi.currentPaidFees(studentId, ammount);
		
		List<Student> list = ssi.getAllStudents();
		m.addAttribute("data", list);
		
		return "adminscreen";
	}
	
	@RequestMapping("/shift")
	public String shiftBatch(@RequestParam("rollno") int studentId, Model m) {
		
		Student stu = ssi.getforBatchShiftingStudent(studentId);
		m.addAttribute("stu", stu);
		
		return "shiftbatch";
	}
	
	@RequestMapping("/shiftbatch")
	public String newBatch(@RequestParam("studentId") int studentId, @RequestParam("batchNumber") String batchNumber, Model m) 
	{
		ssi.newbatchShift(studentId, batchNumber);
		
		List<Student> list = ssi.getAllStudents();
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
	
	
}
