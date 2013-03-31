package studio.hdr.lms.dao;

import static org.junit.Assert.*;

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
public class ISimpleBookDetailViewDAOTest {
	
	@Autowired
	ISimpleBookDetailViewDAO dao;
	
	@Ignore
	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByBookInfoId() {
		dao.findByBookInfoId(14l);
	}

}
