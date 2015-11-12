package org.afroz.practice.ejb.remotes;

import java.util.List;

import javax.ejb.Remote;

import org.afroz.practice.ejb.Student;

@Remote
public interface StudentRemote {
	public void addStudent(Student s);
	public void removeStudent(int id);
	public List<Student> listStudent();
}
