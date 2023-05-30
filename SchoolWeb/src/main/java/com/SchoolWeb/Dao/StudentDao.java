package com.SchoolWeb.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.SchoolWeb.entity.Country;
import com.SchoolWeb.entity.Student;

public class StudentDao implements StudentDaoInterface {

	public int registerDao(Student st) {
		int i=0;
	  
		try {
			//jdbc
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Dev","Dev");
			PreparedStatement ps=con.prepareStatement("insert into studentWeb values(?,?,?,?,?,?)");
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3,st.getPassword());
			ps.setString(4, st.getRpassword());
			ps.setInt(5, st.getAdmission());
			ps.setString(6, st.getAddress());
			
			i = ps.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public int loginDao(Student st) {
		int i=0;
		  
		try {
			//jdbc
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Dev","Dev");
			PreparedStatement ps=con.prepareStatement("select * from studentWeb where email=? and password=?");
			
			ps.setString(1, st.getEmail());
			ps.setString(2,st.getPassword());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				i=1;
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	
	public Student ViewProfileDao(Student st) {
		Student st1= null;
		  
		try {
			//jdbc
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Dev","Dev");
			PreparedStatement ps=con.prepareStatement("select * from studentWeb where email=?");
			
			ps.setString(1, st.getEmail());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
			   st1 = new Student(); 
			   
			   String n = res.getString(1);
			   String e = res.getString(2);
			   String p = res.getString(3);
			   String rp = res.getString(4);
			   int ad = res.getInt(5);
			   String add = res.getString(6);
			   
			   st1.setName(n);
			   st1.setEmail(e);
			   st1.setPassword(p);
			   st1.setRpassword(rp);
			   st1.setAdmission(ad);
			   st1.setAddress(add);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return st1;
}

	
	public int DeleteProfileDao(Student st) {
		int i=0;
		  
		try {
			//jdbc
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Dev","Dev");
			PreparedStatement ps=con.prepareStatement("delete from studentWeb where email = ?");
			
			ps.setString(1, st.getEmail());
			i = ps.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}


	public ArrayList<Student> SearchProfileDao(Student st) {
		ArrayList<Student> stl= new ArrayList<Student>();
		Student st1=null;
		  
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Dev","Dev");
			PreparedStatement ps=con.prepareStatement("select * from studentWeb where name=?");
			
			ps.setString(1, st.getName());
			ResultSet res=ps.executeQuery();
			
			while(res.next()) 
			{
			   st1 = new Student(); 
			   
			   String n = res.getString(1);
			   String e = res.getString(2);
			   String p = res.getString(3);
			   String rp = res.getString(4);
			   int ad = res.getInt(5);
			   String add = res.getString(6);
			   
			   st1.setName(n);
			   st1.setEmail(e);
			   st1.setPassword(p);
			   st1.setRpassword(rp);
			   st1.setAdmission(ad);
			   st1.setAddress(add);
			   
			   stl.add(st1);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return stl;
	}

	public ArrayList<Student> ViewAllProfileDao() {
		ArrayList<Student> stl= new ArrayList<Student>();
		Student st1=null;
		  
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Dev","Dev");
			PreparedStatement ps=con.prepareStatement("select * from studentWeb");
			
			ResultSet res=ps.executeQuery();
			
			while(res.next()) 
			{
			   st1 = new Student(); 
			   
			   String n = res.getString(1);
			   String e = res.getString(2);
			   String p = res.getString(3);
			   String rp = res.getString(4);
			   int ad = res.getInt(5);
			   String add = res.getString(6);
			   
			   st1.setName(n);
			   st1.setEmail(e);
			   st1.setPassword(p);
			   st1.setRpassword(rp);
			   st1.setAdmission(ad);
			   st1.setAddress(add);
			   
			   stl.add(st1);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return stl;
	}

	public int EditProfileDao(Student st) {
		int i=0;
		  
		try {
			//jdbc
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Dev","Dev");
			PreparedStatement ps=con.prepareStatement("update studentWeb set name= ?,password=?,password2=?,admission_no=?,address=? where email=?");
			ps.setString(1, st.getName());
			ps.setString(2,st.getPassword());
			ps.setString(3, st.getRpassword());
			ps.setInt(4, st.getAdmission());
			ps.setString(5, st.getAddress());
			ps.setString(6, st.getEmail());
			
			i = ps.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public int checkEmailDao(Student st) {
		int i=0;
		  
		try {
			//jdbc
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Dev","Dev");
			PreparedStatement ps=con.prepareStatement("select * from studentWeb where email=?");
			ps.setString(1, st.getEmail());
			
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				i=1;
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public List<Country> LoadCountryDao() {
		List<Country> ff = new ArrayList();
		  
				try {
					//jdbc
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Dev","Dev");
					PreparedStatement ps=con.prepareStatement("select * from country");
					
					ResultSet res=ps.executeQuery();
					while(res.next()) {
					   Country ff1 = new Country();
					   
					   ff1.setCountryId(res.getInt(1));;
					   ff1.setCountryName(res.getString(2));
					  ff.add(ff1);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return ff;
	}
}
