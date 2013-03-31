package studio.hdr.lms.service;

public interface IAdminServce {
	public boolean isAdminExistsByAdminName(String adminName);
	public String getPasswordByName(String adminName);
	public long getAdminIdByAdminName(String adminName);
}
