package studio.hdr.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dao.IAdminDAO;
import studio.hdr.lms.service.IAdminServce;
@Component
public class AdminServceImpl implements IAdminServce{

	private IAdminDAO adminDao;
	@Autowired
	public void setAdminDao(IAdminDAO adminDao) {
		this.adminDao = adminDao;
	}

	public boolean isAdminExistsByAdminName(String adminName) {
		return this.adminDao.isUserExistsByAdminName(adminName);
	}

	public String getPasswordByName(String adminName) {
		return this.adminDao.getPasswordByAdminName(adminName);
	}

	public long getAdminIdByAdminName(String adminName) {
		return this.adminDao.getAdminIdByAdminName(adminName);
	}

}
