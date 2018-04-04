package xyz.ibenben.zhongdian.system.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;//

	@Column(name = "nickname")
	private String nickname;// 用户昵称

	public String getNickname() {
		return nickname;
	}

	@Column(name = "email")
	private String email;// 邮箱|登录帐号

	@Column(name = "pswd")
	private String pswd;// 密码

	@Column(name = "create_time")
	private Date createTime;// 创建时间

	@Column(name = "last_login_time")
	private Date lastLoginTime;// 最后登录时间

	@Column(name = "status")
	private Long status;// 1:有效，0:禁止登录
	@Transient
	private List<String> roleStrlist;
	@Transient
	private List<String> perminsStrlist;

	public List<String> getRoleStrlist() {
		return roleStrlist;
	}

	public void setRoleStrlist(List<String> roleStrlist) {
		this.roleStrlist = roleStrlist;
	}

	public List<String> getPerminsStrlist() {
		return perminsStrlist;
	}

	public void setPerminsStrlist(List<String> perminsStrlist) {
		this.perminsStrlist = perminsStrlist;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", email=" + email + ", pswd=" + pswd + ", createTime="
				+ createTime + ", lastLoginTime=" + lastLoginTime + ", status=" + status + ", roleStrlist="
				+ roleStrlist + ", perminsStrlist=" + perminsStrlist + "]";
	}

	public String echarts() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

}
