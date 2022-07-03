package com.zensar.SpringJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;

import com.zensar.SpringJDBC.dao.StudentDao;
import com.zensar.SpringJDBC.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("My Program started.....");
		ApplicationContext context = new ClassPathXmlApplicationContext(" com/zensar/SpringJDBC/config.xml");

		StudentDao studentDao = context.getBean("studedntDao", StudentDao.class);
		Student student = new Student();
		// INSERT
		// Student student=new Student();
		// student.setId(111);
		// student.setName("Anu");
		// student.setCity("Riya");
		// int result = studentDao.insert(student);
		// System.out.println("student added"+result);

		// UPDATE
		// Student student=new Student();
		// student.setId(222);
		// student.setName("Ram");
		// student.setCity("Sita");
		// int result =StudentDao.change(student);
		// System.out.println("data changed"+result);

		// DELETE
		int result = studentDao.delete(111);
		System.out.println("deleted" + result);
	}
}