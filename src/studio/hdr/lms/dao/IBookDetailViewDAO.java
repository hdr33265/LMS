package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.view.BookDetailView;

public interface IBookDetailViewDAO {

	public abstract BookDetailView findById(java.lang.Long id);

	public abstract List findByExample(BookDetailView instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

}