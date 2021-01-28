package com.project;

import java.util.List;

public interface StudentDAO {
	
	public int insertStudent(Student student) throws Exception;
	public int deleteStudent(Student student)throws Exception;
	public int updateStudent(Student student)throws Exception;
	public List<Student> selectStudentList()throws Exception;
	public List<Student> selectStudentList(Student student)throws Exception;
	public Student selectStudentOne(Student student)throws Exception;
	

}
