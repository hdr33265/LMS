package studio.hdr.lms.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import studio.hdr.lms.model.User;
import studio.hdr.lms.service.IUserServce;

import com.opensymphony.xwork2.ActionSupport;
@Component("userListAction")
@Scope("prototype")
public class UserListAction extends ActionSupport{
	
	private IUserServce userServce;
	@Override
	public String execute() throws Exception {

		List<User> userList=userServce.getUserList();
		
		for (User user : userList) {
			System.out.println(user.getUserName());
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("userList", userList);
		return super.execute();
	}

	public IUserServce getUserServce() {
		return userServce;
	}
	@Autowired
	public void setUserServce(IUserServce userServce) {
		this.userServce = userServce;
	}
}
