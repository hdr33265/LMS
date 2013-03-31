package studio.hdr.lms.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import studio.hdr.lms.service.IAdminServce;
import studio.hdr.lms.service.IUserServce;

import com.opensymphony.xwork2.ActionSupport;

@Component("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String identity;
	
	private Map<String ,Object> session;

	public void setIdentity(String identify) {
		this.identity = identify;
	}

	private IUserServce userServce;
	private IAdminServce adminServce;

	@Autowired
	public void setAdminServce(IAdminServce adminServce) {
		this.adminServce = adminServce;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String verify() {
		if (identity.equals("user")) {
			String pwd = userServce.getPasswordByName(username);
			if (pwd.equals(password)) {
				session.put("userId", userServce.getUserIdByUserName(username));
				session.put("username", username);
				return "user";
			}
		}
		else if(identity.equals("admin")){
			String pwd = adminServce.getPasswordByName(username);
			if (pwd.equals(password)) {
				session.put("adminId", adminServce.getAdminIdByAdminName(username));
				session.put("adminName", username);
				return "admin";
			}
		}
		super.addActionError("密码错误");
		return "login";

	}

	public String execute() {

		return "login";
	}

	public IUserServce getUserServce() {
		return userServce;
	}

	@Autowired
	public void setUserServce(IUserServce userServce) {
		this.userServce = userServce;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}

}
