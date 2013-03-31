package studio.hdr.lms.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import studio.hdr.lms.model.Clbumm;
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="txManager", defaultRollback=false)
@ContextConfiguration({"/applicationContext.xml","/beans.xml"})
@Transactional
public class IClbummDAOTest {
	@Autowired
	private IClbummDAO dao;
	
	@Test
	public void testFindByMajorId() {
		List<Clbumm> list=dao.findByMajorId(1);
		System.out.println(list);
	}

}
