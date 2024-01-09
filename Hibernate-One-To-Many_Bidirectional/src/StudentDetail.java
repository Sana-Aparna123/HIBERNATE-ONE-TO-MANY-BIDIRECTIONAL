import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_detail")
public class StudentDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")//table column name
	private int id;//field name
	@Column(name="branch")//table column name
	private String branch;//field name
	
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="studentDetail",cascade=CascadeType.ALL)
	private Student student;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public StudentDetail(String branch, String hobby) {
		super();
		this.branch = branch;
		this.hobby = hobby;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StudentDetail() {
		super();
	}
	
	@Override
	public String toString() {
		return "StudentDetail [id=" + id + ", branch=" + branch + ", hobby=" + hobby + "]";
	}
	

}
