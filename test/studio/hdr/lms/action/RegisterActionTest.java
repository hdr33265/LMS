package studio.hdr.lms.action;

import static org.junit.Assert.*;

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
//@Transactional
public class RegisterActionTest {
	@Autowired
	RegisterAction action;

	@Test
	public void testGetMajorsByDepartmentId() {
		System.out.println(action);
		action.setDepartmentId(18);
		action.getMajorsByDepartmentId();
	}

}
