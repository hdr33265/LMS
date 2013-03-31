package studio.hdr.lms.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dto.BookDetailDTO;
import studio.hdr.lms.service.IBookServce;

@Component("userBookDetailAction")
@Scope("prototype")
public class UserBookDetailAction {
	private long bookId;
	private IBookServce bookServce;
	private BookDetailDTO bookDetail;
	
	
	public String execute(){
		this.bookDetail=this.bookServce.getBookDetailByBookId(bookId);
		return "success";
	}
	
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	@Autowired
	public void setBookServce(IBookServce bookServce) {
		this.bookServce = bookServce;
	}

	public BookDetailDTO getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BookDetailDTO bookDetail) {
		this.bookDetail = bookDetail;
	}
}
