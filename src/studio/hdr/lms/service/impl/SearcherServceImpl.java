package studio.hdr.lms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dao.IBookInfoViewDAO;
import studio.hdr.lms.dto.BookInfoDTO;
import studio.hdr.lms.model.view.BookInfoView;
import studio.hdr.lms.service.ISearcherServce;
import studio.hdr.lms.util.LuceneHelper;
import studio.hdr.lms.util.MyQuery;

@Component("searcherServce")
public class SearcherServceImpl implements ISearcherServce {
	private LuceneHelper luceneHelper;
	private IBookInfoViewDAO bookInfoViewDao;
	@Autowired
	public void setBookInfoViewDao(IBookInfoViewDAO bookInfoViewDao) {
		this.bookInfoViewDao = bookInfoViewDao;
	}

	public List<BookInfoDTO> commonSearch(String queryString) {
		List<Long> ids = luceneHelper.commonSearch(queryString);
		if (ids == null)
			return null;
		List<BookInfoView> bookLists = bookInfoViewDao.findById(ids);
		return this.transform(bookLists);
	}

	private List<BookInfoDTO> transform(List<BookInfoView> bookLists) {
		List<BookInfoDTO> dtos = new ArrayList<BookInfoDTO>(bookLists.size());
		for (BookInfoView bookList : bookLists) {
			BookInfoDTO dto = new BookInfoDTO();
			dto.setName(bookList.getName());
			dto.setAuthor(bookList.getAuthor());
			dto.setAvailableCount(bookList.getAvailableCount());
			dto.setBookClass(bookList.getBookClass());
			dto.setCount(bookList.getCount());
			dto.setLang(bookList.getLang());
			dto.setPress(bookList.getPress());
			dto.setPrice(bookList.getPrice());
			dto.setId(bookList.getId());
			dtos.add(dto);
		}
		return dtos;
	}

	public List<BookInfoDTO> advancedSearch(MyQuery myQuery) {
		List<Long> ids = luceneHelper.advancedSearch(myQuery);
		if (ids == null)
			return null;
		List<BookInfoView> bookLists = bookInfoViewDao.findById(ids);
		return this.transform(bookLists);
	}

	@Autowired
	public void setLuceneHelper(LuceneHelper luceneHelper) {
		this.luceneHelper = luceneHelper;
	}



}
