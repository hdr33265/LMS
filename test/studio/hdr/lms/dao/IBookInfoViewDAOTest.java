package studio.hdr.lms.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml", "/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class IBookInfoViewDAOTest {

	@Autowired
	IBookInfoViewDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

//	@Ignore
	@Test
	public void testFindByIdLong() {
		Assert.assertEquals("大学英语4", dao.findById(8).getName());
	}

	@Test
	public void testFindByIdListOfLong() {
		List<Long> ids = new ArrayList<Long>(4);
		ids.add(4l);
		ids.add(8l);
		ids.add(15l);

		System.out.println(dao.findById(ids));
	}

}
