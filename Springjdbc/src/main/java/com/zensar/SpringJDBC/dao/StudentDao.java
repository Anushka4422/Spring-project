package com.zensar.SpringJDBC.dao;

import com.zensar.SpringJDBC.entity.Student;

public interface StudentDao {
	public int insert(Student student);

	public int change(Student student);

	public int delete(int studentID);
}