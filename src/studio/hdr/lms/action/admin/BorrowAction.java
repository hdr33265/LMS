package studio.hdr.lms.action.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dto.OrderInfoDTO;
import studio.hdr.lms.service.IBorrowServce;

import com.opensymphony.xwork2.ActionContext;

@Component("borrowAction")
public class BorrowAction {

	private List<OrderInfoDTO> orderList;

	private IBorrowServce borrowServce;
	
	private long userId;
	
	private long bookId;
	
	private long orderId;
	
	private List<Long> orders;
	
	private boolean isSuccess;
	
	public boolean getIsSuccess(){
		return isSuccess;
	}
	
	public void setOrders(List<Long> orders){
		this.orders=orders;
	}
	
	public void setOrderId(long orderId){
		this.orderId=orderId;
	}
	
	public void setBookId(long bookId){
		this.bookId=bookId;
	}
	
	public void setUserId(long userId){
		this.userId=userId;
	}

	public List<OrderInfoDTO> getOrderList() {
		return orderList;
	}
	
	public String ajaxForBorrowBooks(){
		this.isSuccess=this.borrowServce.borrowBookByOrders(orders);
		return "borrowBooks";
	}
	
	public String ajaxForOrderList(){
		this.orderList=borrowServce.getOrderInfoById(userId);
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.put("userId", userId);
		return "orderList";
	}
	public String openOrderBook(){
		borrowServce.borrowBookByOrder(orderId);
		return "success";
	}
	@Autowired
	public void setBorrowServce(IBorrowServce borrowServce) {
		this.borrowServce = borrowServce;
	}

	public String openBorrowByOrder() {
		return "borrowByOrder";
	}

	public String openReturnBook() {
		return "returnBook";
	}

	public String openBorrowByBookId() {
		return "borrowByBookId";
	}

}
