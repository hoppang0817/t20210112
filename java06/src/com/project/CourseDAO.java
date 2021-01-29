package com.project;

import java.util.List;

public interface CourseDAO {
	
	public int insertCourse(Course course)throws Exception;
	public int updateCourse(Course course)throws Exception;
	public int deleteCourse(Course course)throws Exception;
	public Course selectCourseOne(Course course)throws Exception;// 내가 수강한 과목1개
	public List<Course>selectCourseListe()throws Exception;//전체 수강생 목록
	public List<Course>selectCourseListeWhere(Course course)throws Exception;//내가수강한 항목리스트

}
