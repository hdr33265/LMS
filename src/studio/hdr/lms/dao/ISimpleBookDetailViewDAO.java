package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.view.SimpleBookDetailView;

public interface ISimpleBookDetailViewDAO {

	public abstract SimpleBookDetailView findById(java.lang.Long id);

	public abstract List findAll();

	public List findByBookInfoId(Long bookInfo);
}