package studio.hdr.lms.action.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studio.hdr.lms.service.IAdminServce;

@Component("adminManagerAction")
public class AdminActon {
	
	private String adminName;
	
	private IAdminServce adminServce;
	@Autowired
	public void setAdminServce(IAdminServce adminServce) {
		this.adminServce = adminServce;
	}


	private boolean isAdminExists;
	
	public String validateAdminIsExists(){
		System.out.println("进入到adminAction");
		this.isAdminExists =this.adminServce.isAdminExistsByAdminName(adminName);
		System.out.println(isAdminExists);
		return "isAdminExists";
	}

	
	public boolean getIsAdminExists() {
		return isAdminExists;
	}
	
	

	


	public void setAdminName(String username) {
		this.adminName = username;
	}


	public String execute(){
		System.out.println("管理员登陆:"+this.adminName);
		return "index";
	}
	
	public String getSidebar(){
		return "sidebar";
	}
	
	public String getHeader(){
		return "header";
	}
}
