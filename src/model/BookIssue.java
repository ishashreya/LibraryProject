package model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="BookIssue")
public class BookIssue  {
      
	@Id
	@GeneratedValue
	@Column(name="issueId")
	int issueId;
	@Column(name="bookId")
	int bookId;
	@Column(name="username")
	String userName;
	@Column(name="bookName")
	String bookName;
	@Column(name="startDate")
	String startDate;
	@Column(name="endDate")
	String endDate;
	@Column(name="Approved")
//	@NotNull
//	@org.hibernate.annotations.Type(type="true_false")
	boolean approved;
	public BookIssue(int bookId,String userName, String bookName, String startDate, String endDate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userName=userName;
	}
	
	


	
	
	public BookIssue(int issueId, int bookId, String userName, String bookName, String startDate, String endDate,
			boolean approved) {
		super();
		this.issueId = issueId;
		this.bookId = bookId;
		this.userName = userName;
		this.bookName = bookName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.approved = approved;
	}






	public BookIssue() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isApproved() {
		return approved;
	}






	public void setApproved(boolean approved) {
		this.approved = approved;
	}






	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}






	@Override
	public String toString() {
		return "BookIssue [issueId=" + issueId + ", bookId=" + bookId + ", userName=" + userName + ", bookName="
				+ bookName + ", startDate=" + startDate + ", endDate=" + endDate + ", approved=" + approved + "]";
	}

	

	
	
	
}
