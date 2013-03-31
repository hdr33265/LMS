package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.view.BookInfoView;

public interface IBookInfoViewDAO {

	public static final String NAME = "name";
	public static final String AUTHOR = "author";
	public static final String BOOK_CLASS = "bookClass";
	public static final String PRESS = "press";
	public static final String COUNT = "count";
	public static final String AVAILABLE_COUNT = "availableCount";
	public static final String PRICE = "price";
	public static final String DESCRIPTION = "description";
	public static final String LANG = "lang";
	
	public abstract List findByExample(BookInfoView instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract BookInfoView findById(long i);

	public abstract List<BookInfoView> findById(List<Long> ids);

}