package Project;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	@Id
    @Column(name = "Student_id")
    private int Student_id;
	@Column(name = "Student_name")
    private String Student_name;

    @ManyToMany
    @JoinTable(
            name = "Student_Courses",
            joinColumns = @JoinColumn(name = "Student_id"),
            inverseJoinColumns = @JoinColumn(name = "Courses_id")
    )
    private Set<Courses> Courses = new HashSet<>();

    public Student() {
    	super();
    }

	public int getStudent_id() {
		return Student_id;
	}

	public void setStudent_id(int student_id) {
		Student_id = student_id;
	}

	public String getStudent_name() {
		return Student_name;
	}

	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}

	public Set<Courses> getCourses() {
		return Courses;
	}

	public void setCourses(Set<Courses> courses) {
		Courses = courses;
	}
}
