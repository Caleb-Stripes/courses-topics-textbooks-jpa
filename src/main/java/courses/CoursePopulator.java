package courses;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import courses.models.Course;
import courses.models.Textbook;
import courses.models.Topic;
import courses.repositories.CourseRepository;
import courses.repositories.TextbookRepository;
import courses.repositories.TopicRepository;

@Component
public class CoursePopulator implements CommandLineRunner  {

	@Resource
	private CourseRepository courseRepo;
	

	@Resource
	private TopicRepository topicRepo;
	

	@Resource
	private TextbookRepository textbookRepo;


	@Override
	public void run(String... args) throws Exception {
		// data
		
		Topic java = new Topic("Java");
		java = topicRepo.save(java);
		
		Topic spring = new Topic("Spring");
		spring = topicRepo.save(spring);
		
		Topic tdd = new Topic("TDD");
		tdd = topicRepo.save(tdd);
		
		
		
		Course java101 = new Course("Intro to Java", "Learn the fundamentals of Java Programming", java);
		java101 = courseRepo.save(java101);
		
		Course java102 = new Course("Advanced Java", "Learn how to test a JPA app", java, tdd);
		java102 = courseRepo.save(java102);
		
		//commenting this out allows us to delete a course in the web app
		textbookRepo.save(new Textbook("Head First Java", java101));
		textbookRepo.save(new Textbook("Head First Design Patterns", java102));
		textbookRepo.save(new Textbook("Clean Coding", java102));
		textbookRepo.save(new Textbook("Intro to JPA", java102));

		
		
		
	}
	
	
	
	
	
}
