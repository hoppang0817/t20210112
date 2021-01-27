package com.project;

import java.util.List;

public interface SubjectDAO {


	
	public int insertSubject(Subject subject)throws Exception;
	public int deleteSubject(Subject subject)throws Exception;
	public int updateSubject(Subject subject)throws Exception;
	public List<Subject> selectSubject()throws Exception;
	public List<Subject> selectSubjectList(Subject subject)throws Exception;//��ü��ȸ ���� ����
	public Subject selectSubjectOne(Subject subject)throws Exception;//������ 1����ȸ
}
