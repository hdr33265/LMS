package studio.hdr.lms.dao;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="txManager", defaultRollback=false)
@ContextConfiguration({"/applicationContext.xml","/beans.xml"})
@Transactional
public class IDepartmentDAOTest {
	@Autowired
	private IDepartmentDAO dao;
	@Test
	public void testFindByDepartmentName() {
		Assert.assertEquals(new Integer(17), dao.findByDepartmentName("计算机").getDepartmentId());
//		System.out.println(dao.findByDepartmentName("计算机"));
	}

}
