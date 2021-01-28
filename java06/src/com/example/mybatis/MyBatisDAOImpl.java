package com.example.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.project.Subject;
import com.project.SubjectDAO;

public class MyBatisDAOImpl implements SubjectDAO {
	
	//DB접속
	SqlSession sqlsession = MyBatisContext.getSqlSession();

	@Override
	public int insertSubject(Subject subject) throws Exception {
		int result =sqlsession.insert("SubjectMapper.insertSubject",subject);
		sqlsession.commit();
		return result;
		
	}

	@Override
	public int deleteSubject(Subject subject) throws Exception {
		int result = sqlsession.delete("SubjectMapper.deleteSubject",subject);
		sqlsession.commit();
		return result;
	}

	@Override
	public int updateSubject(Subject subject) throws Exception {
		int result = sqlsession.update("SubjectMapper.updateSubject",subject);
		sqlsession.commit();
		return result;
	}

	@Override
	public List<Subject> selectSubject() throws Exception {
		return sqlsession.selectList("SubjectMapper.selectSubject");
	}

	@Override
	public List<Subject> selectSubjectList(Subject subject) throws Exception {
		return sqlsession.selectList("SubjectMapper.selectSubjectList", subject);
	}

	@Override
	public Subject selectSubjectOne(Subject subject) throws Exception {
		return sqlsession.selectOne("SubjectMapper.selectSubjectOne", subject);
	}

	
}
