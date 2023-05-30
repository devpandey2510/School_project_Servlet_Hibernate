package com.SchoolWeb.service;

import java.util.ArrayList;
import java.util.List;

import com.SchoolWeb.Dao.StudentDaoFactory;
import com.SchoolWeb.Dao.StudentDaoInterface;
import com.SchoolWeb.entity.Country;
import com.SchoolWeb.entity.Student;

public class StudentService implements StudentServiceInterface {

	public int registerStudent(Student st) {
		StudentDaoInterface sd = StudentDaoFactory.createObject();
		return sd.registerDao(st);
	}

	public int loginStudent(Student st) {
		StudentDaoInterface sd = StudentDaoFactory.createObject();
		return sd.loginDao(st);
	}

	
	public Student ViewPofileStudent(Student st) {
		StudentDaoInterface sd = StudentDaoFactory.createObject();
		Student st1 = sd.ViewProfileDao(st);
	     return st1;
	}

	
	public int DeletePofileStudent(Student st) {
		StudentDaoInterface sd = StudentDaoFactory.createObject();
		return sd.DeleteProfileDao(st);
	}

	
	public ArrayList<Student> SearchPofileStudent(Student st) {
		StudentDaoInterface sd = StudentDaoFactory.createObject();
		ArrayList<Student> st1 = sd.SearchProfileDao(st);
	     return st1;
	}

	public ArrayList<Student> ViewAllPofileStudent() {
		StudentDaoInterface sd = StudentDaoFactory.createObject();
		ArrayList<Student> st1 = sd.ViewAllProfileDao();
	     return st1;
	}

	public int EditProfileStudent(Student st) {
		StudentDaoInterface sd = StudentDaoFactory.createObject();
		return sd.EditProfileDao(st);
	}

	public int checkEmailService(Student st) {
		StudentDaoInterface sd = StudentDaoFactory.createObject();
		return sd.checkEmailDao(st);
	}

	public List<Country> LoadCountryService() {
		StudentDaoInterface sd = StudentDaoFactory.createObject();
		return sd.LoadCountryDao();
	}

	
}
