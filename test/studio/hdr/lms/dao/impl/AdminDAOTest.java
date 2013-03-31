package studio.hdr.lms.dao.impl;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import studio.hdr.lms.dao.IAdminDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml", "/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class AdminDAOTest {

	@Autowired
	IAdminDAO dao;

	@Test
	@Ignore
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testDelete() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPasswordByName() {
		String password=dao.getPasswordByAdminName("hdr33265");
		Assert.assertEquals("a33265", password);
	}
	@Test
	public void testGetPasswordByNameNull() {
		String password=dao.getPasswordByAdminName("hdr332656");
		Assert.assertEquals(null, password);
	}

}
