package studio.hdr.lms.service;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import studio.hdr.lms.service.ISearcherServce;
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="txManager", defaultRollback=false)
@ContextConfiguration({"/applicationContext.xml","/beans.xml"})
//@Transactional
public class ISearcherServceTest {
	@Autowired
	ISearcherServce servce;
	@Test
	public void testCommonSearch() {
//		System.out.println("普通查询");
		System.out.println(servce.commonSearch("明"));
	}

	@Test
	@Ignore
	public void testAdvancedSearch() {
		fail("Not yet implemented");
	}

}
