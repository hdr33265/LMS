package studio.hdr.lms.action.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studio.hdr.lms.model.view.BookInfoView;
import studio.hdr.lms.model.view.SimpleBookDetailView;
import studio.hdr.lms.service.IBookServce;
import studio.hdr.lms.service.IBorrowServce;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component("userOrderBookAction")
public class UserOrderBookAction  extends ActionSupport{

	private long bookId;

	private IBookServce bookServce;

	private List<SimpleBookDetailView> bookDetails;

	@Autowired
	public void setBorrowServce(IBorrowServce borrowServce) {
		this.borrowServce = borrowServce;
	}

	private BookInfoView bookInfo;

	private IBorrowServce borrowServce;

	public BookInfoView getBookInfo() {
		return bookInfo;
	}

	public String execute() {

		return "commonSearch";
	}

	public String openAdvancedSearch() {

		return "advancedSearch";
	}

	public String openOrderBook() {
		this.bookDetails = this.bookServce
				.getSimpleBookDetailsByBookInfoId(bookId);
		this.bookInfo = this.bookServce.getBookInfoViewByBookInfoId(bookId);
		return "order";
	}

	public List<SimpleBookDetailView> getBookDetails() {
		return bookDetails;
	}

	@Autowired
	public void setBookServce(IBookServce bookServce) {
		this.bookServce = bookServce;
	}

	public String order() {
		long userId=(Long) ActionContext.getContext().getSession().get("userId");
		this.borrowServce.orderBook(userId, bookId);
		return "success";
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
}
