package org.afroz.practice.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.afroz.practice.ejb.remotes.StudentRemote;

@Stateless(name="Student")
public class StudentBean implements StudentRemote{
	public static List<Student> students = new ArrayList<>();
	
	@Override
	public void addStudent(Student s) {
		students.add(s);
	}

	@Override
	public void removeStudent(int id) {
		students.remove(id);
	}

	@Override
	public List<Student> listStudent() {
		return students;
	}

}
