package com.SchoolWeb.service;

import java.util.ArrayList;
import java.util.List;

import com.SchoolWeb.entity.Country;
import com.SchoolWeb.entity.Student;

public interface StudentServiceInterface {

	int registerStudent(Student st);

	int loginStudent(Student st);

	Student ViewPofileStudent(Student st);

	int DeletePofileStudent(Student st);

	ArrayList<Student> SearchPofileStudent(Student st);

	ArrayList<Student> ViewAllPofileStudent();

	int EditProfileStudent(Student st);

	int checkEmailService(Student st);

	List<Country> LoadCountryService();

}
