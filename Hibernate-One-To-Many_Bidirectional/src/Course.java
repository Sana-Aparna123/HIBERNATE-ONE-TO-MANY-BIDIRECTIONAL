import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	
	//many courses choosen by one student
	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST})
	@JoinColumn(name="student_id")
	private Student student;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	
	public void addReview(Review tempReview) {
		if(reviews==null) {
			reviews=new ArrayList<Review>();
		}
		reviews.add(tempReview);
		
	}
	
	
	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Course(String title) {
		super();
		this.title = title;
	}

	public Course() {
		super();
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}

	
	
	

}
