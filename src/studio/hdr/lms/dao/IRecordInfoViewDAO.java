package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.view.RecordInfoView;

public interface IRecordInfoViewDAO {

	public abstract RecordInfoView findById(
			Long id);

	public abstract List findByExample(RecordInfoView instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract List<RecordInfoView> findByUserId(long userId);

}