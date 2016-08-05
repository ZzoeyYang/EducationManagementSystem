package team.hnucs.edu.action.admin;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;

import team.hnucs.edu.entity.Student;
import team.hnucs.edu.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminManageStudentAction extends ActionSupport implements SessionAware, ModelDriven<Student>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student stu = new Student();
	private StudentService stuService;
	public void setStuService(StudentService stuService) {
		this.stuService = stuService;
	}
	public StudentService getStuService() {
		return stuService;
	}
	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return stu;
	}
	public String save() throws ParseException, UnsupportedEncodingException{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		String birth = request.getParameter("stuBir");
		String enroll = request.getParameter("stuEnrollment");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(birth);
		stu.setStuBirth(date);
		date = format.parse(enroll);
		stu.setStuEnrollmentDate(date);
		stuService.save(stu);
		return "save";
	}
	public String update() throws ParseException, UnsupportedEncodingException{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		String birth = request.getParameter("stuBir");
		String enroll = request.getParameter("stuEnrollment");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(birth);
		stu.setStuBirth(date);
		date = format.parse(enroll);
		stu.setStuEnrollmentDate(date);
		stuService.updateInfo(stu);;
		return "update";
	}
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String studentNum = request.getParameter("stuNum");
		stuService.delete(studentNum);
		return "delete";
	}
	

}
