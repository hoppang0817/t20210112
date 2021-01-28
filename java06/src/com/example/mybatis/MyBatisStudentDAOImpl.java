package com.example.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.project.Student;
import com.project.StudentDAO;

public class MyBatisStudentDAOImpl implements StudentDAO{
	
	SqlSession sqlsession = MyBatisContext.getSqlSession();

	@Override
	public int insertStudent(Student student) throws Exception {
		int result = sqlsession.insert("StudentMapper.insertStudent", student);
		sqlsession.commit();
		return result;
	}

	@Override
	public int deleteStudent(Student student) throws Exception {
		int result = sqlsession.delete("StudentMapper.deleteStudent", student);
		sqlsession.commit();
		return result;
	}

	@Override
	public int updateStudent(Student student) throws Exception {
		int result = sqlsession.update("StudentMapper.updateStudent", student);
		sqlsession.commit();
		return result;
	}

	@Override
	public List<Student> selectStudentList() throws Exception {
		return sqlsession.selectList("StudentMapper.selectStudentList");
	}

	@Override
	public List<Student> selectStudentList(Student student) throws Exception {
		return sqlsession.selectList("StudentMapper.selectStudentList1", student);
	}

	@Override
	public Student selectStudentOne(Student student) throws Exception {
		return sqlsession.selectOne("StudentMapper.selectSubjectOne", student);
	}

}
