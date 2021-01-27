
/* Drop Tables */

DROP TABLE COURSE CASCADE CONSTRAINTS;
DROP TABLE PROGESSOR CASCADE CONSTRAINTS;
DROP TABLE STUDENT CASCADE CONSTRAINTS;
DROP TABLE SUBJECT CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE COURSE
(
	CODE number NOT NULL,
	SCORE number,
	REGDATE date,
	SUBJECT_CODE char(5) NOT NULL,
	STUDENT_ID char(10) NOT NULL,
	PRIMARY KEY (CODE)
);


CREATE TABLE PROGESSOR
(
	PROFESSOR_ID char(10) NOT NULL,
	PROFESSOR_NAME varchar2(10),
	PROFESSOR_MAJOR varchar2(20),
	PROFESSOR_PHONE varchar2(13),
	PROFESSOR_DATE date,
	PRIMARY KEY (PROFESSOR_ID)
);


CREATE TABLE STUDENT
(
	STUDENT_ID char(10) NOT NULL,
	STUDENT_NAME varchar2(10),
	STUDENT_GRADE number,
	STUDENT_PHONE varchar2(13),
	STUDENT_MAJOR varchar2(20),
	STUDENT_DATE date,
	PRIMARY KEY (STUDENT_ID)
);


CREATE TABLE SUBJECT
(
	SUBJECT_CODE char(5) NOT NULL,
	SUBJECT_NAME varchar2(20),
	SUBJECT_CLASS varchar2(10),
	SUBJECT_PROFESSOR varchar2(10),
	SUBJECT_TIME varchar2(10),
	SUBJECT_DATE date,
	PRIMARY KEY (SUBJECT_CODE)
);



/* Create Foreign Keys */

ALTER TABLE COURSE
	ADD FOREIGN KEY (STUDENT_ID)
	REFERENCES STUDENT (STUDENT_ID)
;


ALTER TABLE COURSE
	ADD FOREIGN KEY (SUBJECT_CODE)
	REFERENCES SUBJECT (SUBJECT_CODE)
;



