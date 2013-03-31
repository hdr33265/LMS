package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Book;

public interface IBookDAO {

	// property constants
	public static final String BOOK_BORROW_COUNT = "bookBorrowCount";

	public abstract void save(Book transientInstance);

	public abstract void update(Book transientInstance);

	public abstract void delete(Book persistentInstance);

	public abstract Book findById(java.lang.Long id);

	public abstract List findByExample(Book instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByBookBorrowCount(Object bookBorrowCount);

	public abstract List findAll();

}