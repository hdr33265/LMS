package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.view.OrderInfoView;
import studio.hdr.lms.model.view.RecordInfoView;

public interface IOrderInfoViewDAO {

	public abstract OrderInfoView findById(java.lang.Long id);

	public abstract List findByExample(OrderInfoView instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract List<OrderInfoView> findByUserId(long userId);

}