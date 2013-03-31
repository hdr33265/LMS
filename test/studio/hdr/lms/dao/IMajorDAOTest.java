package studio.hdr.lms.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import studio.hdr.lms.model.Department;
import studio.hdr.lms.model.Major;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@ContextConfiguration({ "/applicationContext.xml", "/beans.xml" })
@Transactional
public class IMajorDAOTest {
	@Autowired
	IMajorDAO majorDao;
	@Autowired
	IDepartmentDAO departmentDao;

	@Test
	@Ignore
	public void testFindByDepartmentAndMajorName() {
		Department d = departmentDao.findByDepartmentName("计算机");
		Major m = majorDao.findByDepartmentAndMajorName(d, "计科");
		System.out.println(m.getMajorNum());
	}

	@Test
	public void testFindByDepartmentId() {
		List<Major> list=majorDao.findByDepartmentId(17);
		System.out.println(list);
	}

}
