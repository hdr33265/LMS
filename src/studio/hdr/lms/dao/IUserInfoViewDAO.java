package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.view.UserInfoView;

public interface IUserInfoViewDAO {

	public abstract UserInfoView findById(java.lang.Long id);

	public abstract List findByExample(UserInfoView instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

}