package studio.hdr.lms.action.user;

import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dto.UserInfoDTO;
import studio.hdr.lms.service.IUserServce;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements  SessionAware {
	private long userId;

	private UserInfoDTO userInfo;

	private IUserServce userServce;
	
	private Map<String,Object> session;
	
//	private HttpServletRequest request;

	private String oldPassword;
	private String newPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	public String getUserInfoByUserId() {
		
		Map<String, Object> session=ActionContext.getContext().getSession();
		this.userId = (Long) session.get("userId");
		this.userInfo = this.userServce.getUserInfoByUserId(this.userId);
		return "userInfo";
	}

	public String changePassword() {
	
		if (oldPassword != null) {
			String username = (String) session.get("username");
			if (this.oldPassword.equals(this.userServce
					.getPasswordByName(username))) {
				this.userId = (Long) this.session.get("userId");
				this.userServce.changePasswordByUserId(newPassword, userId);
				return "changePasswordSuccess";
			} else {
				super.addActionError("原密码错误");
				return "changePassword";
			}

		} else {
			return "changePassword";
		}

	}

	public String openSidebar(){
		return "sidebar";
	}
	
	public String openHeader(){
		return "header";
	}
	
	public String execute() {
		return "index";
	}

	
	
	
	public IUserServce getUserServce() {
		return userServce;
	}

	@Autowired
	public void setUserServce(IUserServce userServce) {
		this.userServce = userServce;
	}

	public UserInfoDTO getUserInfo() {
		return userInfo;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
		
	}
}
