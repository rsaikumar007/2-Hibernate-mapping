package Project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Hmain {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("1-Hibernate.config.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory sfactory=meta.buildSessionFactory();
		Session session=sfactory.openSession();
		
		Transaction t=session.beginTransaction();
		try {
			Student s1=new Student();
			s1.setStudent_id(201);
			s1.setStudent_name("Teju");
			
			Student s2=new Student();
			s2.setStudent_id(202);
			s2.setStudent_name("Sai");
			
			Student s3=new Student();
			s3.setStudent_id(203);
			s3.setStudent_name("Sazid");
			
			Courses c1=new Courses();
			c1.setCourse_id(1124);
			c1.setCourse_name("Core Java");
			
			Courses c2=new Courses();
			c2.setCourse_id(5632);
			c2.setCourse_name("Python");
			
			Courses c3=new Courses();
			c3.setCourse_id(4201);
			c3.setCourse_name("JavaScript");
			
			s1.getCourses().add(c1);			
			s1.getCourses().add(c2);			
			s1.getCourses().add(c3);
			
			s2.getCourses().add(c1);			
			s2.getCourses().add(c2);			
			s2.getCourses().add(c3);
			
			s3.getCourses().add(c1);			
			s3.getCourses().add(c2);			
			s3.getCourses().add(c3);
			
			session.save(s1);
			session.save(s2);
			session.save(s3);
			
			session.save(c1);
			session.save(c2);
			session.save(c3);
			
			t.commit();
		}finally {
			sfactory.close();
			session.close();
		}

	}

}
