package studio.hdr.lms.dao;

import java.util.List;

import studio.hdr.lms.model.Clbumm;

public interface IClbummDAO {

	// property constants
	public static final String CLBUMM_MAJOR = "clbummMajor";
	public static final String CLBUMM_NUM = "clbummNum";

	public abstract void save(Clbumm transientInstance);

	public abstract void delete(Clbumm persistentInstance);

	public abstract Clbumm findById(java.lang.Integer id);

	public abstract List findByExample(Clbumm instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByMajorId(int majorId);

	public abstract List findByClbummNum(Object clbummNum);

	public abstract List findAll();

}