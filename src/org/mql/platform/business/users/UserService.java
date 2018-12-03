package org.mql.platform.business.users;

import java.util.List;

import org.mql.platform.models.Laureate;
import org.mql.platform.models.Professor;
import org.mql.platform.models.Student;
import org.mql.platform.models.User;


public interface UserService {
 
	public Student addStudent(Student s);
	
	public Student deleteStudent(Integer id_student);
	
	public Student updateStudent(Student newStudent);
	
	public Student getStudentById(Integer id_student);
	
	public List<Student> getAllStudents();
	
	//------------------------------------------------------//
	
	public Professor addProfessor(Professor p);
	
	public Professor deleteProfessor(Integer id_professor);
	
	public Professor updateProfessor(Professor newProfessor);
	
	public Professor getProfessorById(Integer id_professor);
	
	public List<Professor> getAllProfessors();
	
	//------------------------------------------------------//
	
	public Laureate addLaureate(Laureate l);
	
	public Laureate deleteLaureate(Integer id_laureate);
	
	public Laureate updateLaureate(Laureate newLaureate);
	
	public Laureate getLaureateById(Integer id_laureate);
	
	public List<Laureate> getAllLaureates();
	
	 
	
	
}
