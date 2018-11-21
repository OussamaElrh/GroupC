package org.mql.platform.business.impl;

import java.util.List;
import java.util.Optional;

import org.mql.platform.business.UserService;
import org.mql.platform.dao.LaureateRepository;
import org.mql.platform.dao.ProfessorRepository;
import org.mql.platform.dao.StudentRepository;
import org.mql.platform.models.Laureate;
import org.mql.platform.models.Professor;
import org.mql.platform.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jafer oualid
 */
@Service
public class DefaultUserService implements UserService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private LaureateRepository laureateRepository;
	
	public DefaultUserService() {

	}

	@Transactional
	public Student addStudent(Student s) {
		// TODO Auto-generated method stub

		return studentRepository.save(s);

	}

	@Transactional
	public Student deleteStudent(Integer id_student) {
		// TODO Auto-generated method stub
		Optional<Student> std = studentRepository.findById(id_student);

		studentRepository.deleteById(id_student);
		if (studentRepository.findById(id_student).get() == null) {
			return std.get();
		}

		return null;
	}

	@Transactional
	public Student updateStudent(Student newStudent) {
		// TODO Auto-generated method stub
		Optional<Student> std = studentRepository.findById(newStudent.getId());

		studentRepository.save(newStudent);
		return std.get();
	}

	@Transactional
	public Student getStudentById(Integer id_student) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id_student).get();
	}

	@Transactional
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Transactional
	public Professor addProfessor(Professor p) {
		// TODO Auto-generated method stub
		return professorRepository.save(p);
	}

	@Transactional
	public Professor deleteProfessor(Integer id_professor) {
		// TODO Auto-generated method stub
		Optional<Professor> pro = professorRepository.findById(id_professor);

		professorRepository.deleteById(id_professor);
		if (professorRepository.findById(id_professor).get() == null) {
			return pro.get();
		}

		return null;
	}

	@Transactional
	public Professor updateProfessor(Professor newProfessor) {
		// TODO Auto-generated method stub
		Optional<Professor> pro = professorRepository.findById(newProfessor.getId());

		professorRepository.save(newProfessor);
		return pro.get();
	}

	@Transactional
	public Professor getProfessorById(Integer id_professor) {
		// TODO Auto-generated method stub
		return professorRepository.findById(id_professor).get();
	}

	@Transactional
	public List<Professor> getAllProfessors() {
		// TODO Auto-generated method stub
		return professorRepository.findAll();
	}

	@Transactional
	public Laureate addLaureate(Laureate l) {
		// TODO Auto-generated method stub
		return laureateRepository.save(l);
	}

	@Transactional
	public Laureate deleteLaureate(Integer id_laureate) {
		// TODO Auto-generated method stub
		Optional<Laureate> laureat = laureateRepository.findById(id_laureate);

		laureateRepository.deleteById(id_laureate);
		if (laureateRepository.findById(id_laureate).get() == null) {
			return laureat.get();
		}

		return null;
	}

	@Transactional
	public Laureate updateLaureate(Laureate newLaureate) {
		// TODO Auto-generated method stub
		Optional<Laureate> laureate = laureateRepository.findById(newLaureate.getId());

		laureateRepository.save(newLaureate);
		return laureate.get();
	}

	@Transactional
	public Laureate getLaureateById(Integer id_laureate) {
		// TODO Auto-generated method stub
		return laureateRepository.findById(id_laureate).get() ;
	}

	@Transactional
	public List<Laureate> getAllLaureates() {
		// TODO Auto-generated method stub
		return laureateRepository.findAll();
	}

}
