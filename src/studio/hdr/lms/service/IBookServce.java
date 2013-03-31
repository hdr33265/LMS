package studio.hdr.lms.service;

import java.util.List;

import studio.hdr.lms.dto.BookDetailDTO;
import studio.hdr.lms.model.view.BookInfoView;
import studio.hdr.lms.model.view.SimpleBookDetailView;

public interface IBookServce {
	public BookDetailDTO getBookDetailByBookId( long bookId);
	public List<SimpleBookDetailView> getSimpleBookDetailsByBookInfoId(long id);
	public BookInfoView getBookInfoViewByBookInfoId(long id);
}
