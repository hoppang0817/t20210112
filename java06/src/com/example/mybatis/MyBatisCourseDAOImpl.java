package com.example.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.project.Course;
import com.project.CourseDAO;

public class MyBatisCourseDAOImpl implements CourseDAO{

	//DB연동
	SqlSession conn = MyBatisContext.getSqlSession();
	
	@Override
	public int insertCourse(Course course) throws Exception {
		int result = conn.insert("CourseMapper.insertCourse", course);
		conn.commit();
		return result;
	}

	@Override
	public int updateCourse(Course course) throws Exception {
		int result = conn.update("CouseMapper.updateCourse", course);
		conn.commit();
		return result;
	}

	@Override
	public int deleteCourse(Course course) throws Exception {
		int result = conn.delete("CourseMapper.deleteCourse", course);
		conn.commit();
		return result;
	}

	@Override
	public Course selectCourseOne(Course course) throws Exception {
		return conn.selectOne("CourseMapper.selectCourseOne", course);
	}

	@Override
	public List<Course> selectCourseListe() throws Exception {
		return conn.selectList("CourseMapper.selectCourseListe");
	}

	@Override
	public List<Course> selectCourseListeWhere(Course course) throws Exception {
		return conn.selectList("CourseMapper.selectCourseListeWhere", course);
	}

}
