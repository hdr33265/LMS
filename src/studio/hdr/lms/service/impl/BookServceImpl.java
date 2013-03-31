package studio.hdr.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dao.IBookDetailViewDAO;
import studio.hdr.lms.dao.IBookInfoViewDAO;
import studio.hdr.lms.dao.ISimpleBookDetailViewDAO;
import studio.hdr.lms.dto.BookDetailDTO;
import studio.hdr.lms.model.view.BookDetailView;
import studio.hdr.lms.model.view.BookInfoView;
import studio.hdr.lms.model.view.SimpleBookDetailView;
import studio.hdr.lms.service.IBookServce;

@Component("bookServce")
public class BookServceImpl implements IBookServce {

	private IBookDetailViewDAO bookDetailDao;
	private ISimpleBookDetailViewDAO simpleBookDetailDao;
	private IBookInfoViewDAO bookInfoViewDao;
	@Autowired
	public void setBookInfoViewDao(IBookInfoViewDAO bookInfoViewDao) {
		this.bookInfoViewDao = bookInfoViewDao;
	}

	@Autowired
	public void setSimpleBookDetailDao(
			ISimpleBookDetailViewDAO simpleBookDetailDao) {
		this.simpleBookDetailDao = simpleBookDetailDao;
	}

	public BookDetailDTO getBookDetailByBookId(long bookId) {
		BookDetailDTO dto = new BookDetailDTO();
		BookDetailView bd = bookDetailDao.findById(bookId);
		dto.setName(bd.getName());
		dto.setAuthor(bd.getAuthor());
		dto.setBorrower(bd.getBorrower());
		dto.setBookClass(bd.getBookClass());
		dto.setDescription(bd.getDescription());
		dto.setPress(bd.getPress());
		dto.setState(bd.getState());
		dto.setPrice(bd.getPrice());
		dto.setId(bd.getId());
		dto.setLang(bd.getLang());
		return dto;
	}

	@Autowired
	public void setBookDetailDao(IBookDetailViewDAO bookDetailDao) {
		this.bookDetailDao = bookDetailDao;
	}

	public List<SimpleBookDetailView> getSimpleBookDetailsByBookInfoId(long id) {
		return this.simpleBookDetailDao.findByBookInfoId(id);
	}

	public BookInfoView getBookInfoViewByBookInfoId(long id) {
		return this.bookInfoViewDao.findById(id);
	}

}
