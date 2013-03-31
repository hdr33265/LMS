package studio.hdr.lms.util;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import studio.hdr.lms.model.view.BookInfoView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml", "/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class LuceneHelperTest {
	@Autowired
	private   LuceneHelper helper;
	@Ignore
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		helper=new LuceneHelper();
//		helper.indexPath="WebRoot/index";
//		System.out.println(helper.indexPath);
//		helper.init();
//		
	}

	@Test
	@Ignore
	public void testInitIndex() {
		helper.createIndex();
	}
	@Test
	public void commonSearch(){
		List<Long> list=helper.commonSearch("历史");
		for (Long id : list) {
			System.out.println(id);
		}
	}
	
	@Test
	@Ignore
	public void testAdvancedSearch() {
		MyQuery myQuery=new MyQuery();

		myQuery.setLang("中文");
		List<Long> list=helper.advancedSearch(myQuery);
		System.out.println("命中数:"+list.size());
		for (Long id : list) {
			System.out.println(id);
		}
		
	}

}
