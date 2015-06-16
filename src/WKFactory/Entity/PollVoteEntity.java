package WKFactory.Entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BgGpollVote entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pollvote", catalog = "cloudcourse")
public class PollVoteEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private String studentNum;
	private String courseNum;
	private String matchNum;
	private Double poll;
	private Timestamp voteTime;

	// Constructors

	/** default constructor */
	public PollVoteEntity() {
	}

	/** full constructor */
	public PollVoteEntity(String studentNum, String courseNum, String matchNum,
			Double poll, Timestamp voteTime) {
		this.studentNum = studentNum;
		this.courseNum = courseNum;
		this.matchNum = matchNum;
		this.poll = poll;
		this.voteTime = voteTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "StudentNum", length = 20)
	public String getStudentNum() {
		return this.studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	@Column(name = "CourseNum", length = 20)
	public String getCourseNum() {
		return this.courseNum;
	}

	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}

	@Column(name = "MatchNum", length = 20)
	public String getMatchNum() {
		return this.matchNum;
	}

	public void setMatchNum(String matchNum) {
		this.matchNum = matchNum;
	}

	@Column(name = "Poll", precision = 53, scale = 0)
	public Double getPoll() {
		return this.poll;
	}

	public void setPoll(Double poll) {
		this.poll = poll;
	}

	@Column(name = "VoteTime", length = 23)
	public Timestamp getVoteTime() {
		return this.voteTime;
	}

	public void setVoteTime(Timestamp voteTime) {
		this.voteTime = voteTime;
	}

}