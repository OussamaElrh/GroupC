package org.mql.platform.business.projects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mql.platform.dao.StudentRepository;
import org.mql.platform.models.ClassYear;
import org.mql.platform.models.Gender;
import org.mql.platform.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author chermehdi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
    {
        "file:WebContent/WEB-INF/config/test-root-context.xml",
    }
)
public class TestExample {

  @Autowired
  StudentRepository repository;

  @Test
  public void test() throws Exception {
    Student student = createStudent();
    Student saved = repository.save(student);
    assertNotNull(saved.getId());
    assertEquals(saved.getCin(), student.getCin());
  }

  private Student createStudent() {
    Student student = new Student();
    student.setCin("123123");
    student.setCne("2213123");
    student.setClassYear(new ClassYear());
    student.setBirthdate(LocalDate.now().minusYears(20));
    student.setEmail("mehdi.cheracher@gmail.com");
    student.setFirstName("mehdi");
    student.setLastName("cheracher");
    student.setGender(Gender.MALE);
    student.setPassword("hello");
    return student;
  }
}