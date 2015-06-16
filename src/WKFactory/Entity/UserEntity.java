package WKFactory.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "user", catalog = "cloudcourse")
public class UserEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userNum;
	private String nickName;
	private String userName;
	private String userPassword;
	private Timestamp regTime;
	private Integer loginNum;
	private Short isLock;
	private String lastLoginIp;
	private Integer userType;
	private String userPicture ;
	private String userPhone ;

	// Constructors

	/** default constructor */
	public UserEntity() {
	}

	/** full constructor */
	public UserEntity(String userNum, String nickName, String userName,
			String userPassword, Timestamp regTime, Integer loginNum,
			Short isLock, String lastLoginIp, Integer userType) {
		this.userNum = userNum;
		this.nickName = nickName;
		this.userName = userName;
		this.userPassword = userPassword;
		this.regTime = regTime;
		this.loginNum = loginNum;
		this.isLock = isLock;
		this.lastLoginIp = lastLoginIp;
		this.userType = userType;
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

	@Column(name = "UserNum", length = 20)
	public String getUserNum() {
		return this.userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	@Column(name = "NickName", length = 15)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "UserName", length = 15)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "UserPassword", length = 50)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "RegTime", length = 19)
	public Timestamp getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	@Column(name = "LoginNum")
	public Integer getLoginNum() {
		return this.loginNum;
	}

	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}

	@Column(name = "isLock")
	public Short getIsLock() {
		return this.isLock;
	}

	public void setIsLock(Short isLock) {
		this.isLock = isLock;
	}

	@Column(name = "LastLoginIP", length = 15)
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Column(name = "UserType")
	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	@Column(name = "UserPicture")
	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}
	@Column(name = "UserPhone")
	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	
}