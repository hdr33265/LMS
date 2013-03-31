package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.BookInfo;

public interface IBookInfoDAO {

	// property constants
	public static final String BOOK_INFO_NAME = "bookInfoName";
	public static final String BOOK_INFO_DESCRIPTION = "bookInfoDescription";
	public static final String BOOK_INFO_PRICE = "bookInfoPrice";

	public abstract void save(BookInfo transientInstance);

	public abstract void delete(BookInfo persistentInstance);

	public abstract BookInfo findById(java.lang.Long id);

	public abstract List findByExample(BookInfo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByBookInfoName(Object bookInfoName);

	public abstract List findByBookInfoDescription(Object bookInfoDescription);

	public abstract List findByBookInfoPrice(Object bookInfoPrice);

	public abstract List findAll();

	public abstract BookInfo merge(BookInfo detachedInstance);

	public abstract void attachDirty(BookInfo instance);

	public abstract void attachClean(BookInfo instance);

}