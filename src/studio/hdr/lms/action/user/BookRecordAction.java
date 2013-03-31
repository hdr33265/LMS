package studio.hdr.lms.action.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dto.RecordInfoDTO;
import studio.hdr.lms.service.IBorrowServce;

@Component("bookRecordAction")
@Scope("prototype")
public class BookRecordAction implements ServletRequestAware {
	private List<RecordInfoDTO> recordList;
	private HttpServletRequest request;

	private IBorrowServce borrowServce;
	
	private long userId;

	public String execute() {
		this.userId = (Long) this.request.getSession().getAttribute("userId");
		this.recordList=borrowServce.getRecordInfoById(userId);
//		for (RecordInfoDTO recordInfo : this.recordList) {
//			System.out.println(recordInfo.getBookName());
//		}
		return "success";
	}

	public List<RecordInfoDTO> getRecordList() {
		return recordList;
	}


	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;

	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	@Autowired
	public void setBorrowServce(IBorrowServce borrowServce) {
		this.borrowServce = borrowServce;
	}

}
