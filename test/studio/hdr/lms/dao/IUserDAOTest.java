package studio.hdr.lms.dao;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@ContextConfiguration({ "/applicationContext.xml", "/beans.xml" })
@Transactional
public class IUserDAOTest {
	@Autowired
	IUserDAO dao;
	@Test
	@Ignore
	public void testGetUserIdByUserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsUserExistsByUserName() {
		Assert.assertEquals(true, dao.isUserExistsByUserName("hdr33265"));
		Assert.assertEquals(false, dao.isUserExistsByUserName("hdr332656"));
	}

	@Test
	@Ignore
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
