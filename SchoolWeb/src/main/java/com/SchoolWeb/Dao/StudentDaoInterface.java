package com.SchoolWeb.Dao;

import java.util.ArrayList;
import java.util.List;

import com.SchoolWeb.entity.Country;
import com.SchoolWeb.entity.Student;

public interface StudentDaoInterface {

	int registerDao(Student st);

	int loginDao(Student st);

	Student ViewProfileDao(Student st);

	int DeleteProfileDao(Student st);

	ArrayList<Student> SearchProfileDao(Student st);

	ArrayList<Student> ViewAllProfileDao();

	int EditProfileDao(Student st);

	int checkEmailDao(Student st);

	List<Country> LoadCountryDao();

}
