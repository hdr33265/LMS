package studio.hdr.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import studio.hdr.lms.service.IBorrowServce;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@ContextConfiguration({ "/applicationContext.xml", "/beans.xml" })
@Transactional
public class IBorrowServceTest {
	@Autowired
	IBorrowServce servce;

	@Test
	@Ignore
	public void testGetRecordInfoById() {
		System.out.println(servce.getRecordInfoById(8));
	}
	
	@Test
	public void testGetOrderInfoById(){
		System.out.println(servce.getOrderInfoById(1));
	}
	@Test
	@Rollback(true)
	public void testOrderBook() {
		servce.orderBook(8, 14);
	}
	
	@Test
	@Rollback(true)

	public void testBorrowBook(){
		servce.borrowBook(1, 2);
	}
	
	@Test
	@Rollback(true)
	public void testBorrowBookByOrders(){
		List<Long> list=new ArrayList<Long>();
		list.add(2l);
		list.add(3l);
		servce.borrowBookByOrders(list);
	}


}
