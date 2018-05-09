package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {
	@Id
	@GeneratedValue
	@Column(name="userId")
	int userId;
	/*@Column(name="userName")
	String Username;*/
	
	@Column(name="feedback")
	String feedback;

	

	

	public Feedback(int userId, String feedback) {
		super();
		this.userId = userId;
		this.feedback = feedback;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [userId=" + userId  + ", feedback=" + feedback + "]";
	}

	
}
