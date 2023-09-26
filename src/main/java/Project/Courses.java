package Project;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Courses")
public class Courses {

    @Id
    @Column(name = "Course_id")
    private int Course_id;

    @Column(name = "Course_name")
    private String Course_name;

    @ManyToMany(mappedBy = "Courses")
    private Set<Student> Student = new HashSet<>();

    public Courses() {
    	super();
    }

	public int getCourse_id() {
		return Course_id;
	}

	public void setCourse_id(int course_id) {
		Course_id = course_id;
	}

	public String getCourse_name() {
		return Course_name;
	}

	public void setCourse_name(String course_name) {
		Course_name = course_name;
	}

	public Set<Student> getStudent() {
		return Student;
	}

	public void setStudent(Set<Student> student) {
		Student = student;
	}
}
