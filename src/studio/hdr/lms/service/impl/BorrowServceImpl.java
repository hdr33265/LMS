package studio.hdr.lms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dao.IBookDAO;
import studio.hdr.lms.dao.IOrderDAO;
import studio.hdr.lms.dao.IOrderInfoViewDAO;
import studio.hdr.lms.dao.IRecordDAO;
import studio.hdr.lms.dao.IRecordInfoViewDAO;
import studio.hdr.lms.dao.IUserDAO;
import studio.hdr.lms.dto.OrderInfoDTO;
import studio.hdr.lms.dto.RecordInfoDTO;
import studio.hdr.lms.model.Book;
import studio.hdr.lms.model.Order;
import studio.hdr.lms.model.Record;
import studio.hdr.lms.model.User;
import studio.hdr.lms.model.view.OrderInfoView;
import studio.hdr.lms.model.view.RecordInfoView;
import studio.hdr.lms.service.IBorrowServce;
import studio.hdr.lms.util.DateHelper;

@Component("borrowServce")
public class BorrowServceImpl implements IBorrowServce {

	private IRecordInfoViewDAO recordInfoDao;
	private IOrderInfoViewDAO orderInfoDao;
	private IOrderDAO orderDao;
	private IUserDAO userDao;
	private IBookDAO bookDao;
	private IRecordDAO  recordDao;

	@Autowired
	public void setRecordDao(IRecordDAO recordDao){
		this.recordDao=recordDao;
	}
	
	@Autowired
	public void setOrderInfoDao(IOrderInfoViewDAO orderInfoDao) {
		this.orderInfoDao = orderInfoDao;
	}

	@Autowired
	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setBookDao(IBookDAO bookDao) {
		this.bookDao = bookDao;
	}

	public List<RecordInfoDTO> getRecordInfoById(long userId) {
		List<RecordInfoDTO> dtoList = new ArrayList<RecordInfoDTO>();
		List<RecordInfoView> list = recordInfoDao.findByUserId(userId);
		if (list == null)
			return null;
		for (RecordInfoView recordInfo : list) {
			RecordInfoDTO recordInfoDTO = new RecordInfoDTO();
			recordInfoDTO.setAuthor(recordInfo.getAuthor());
			recordInfoDTO.setName(recordInfo.getBookName());
			recordInfoDTO.setBookClass(recordInfo.getBookClass());
			recordInfoDTO.setPress(recordInfo.getPress());
			recordInfoDTO.setPrice(recordInfo.getPrice());
			recordInfoDTO.setId(recordInfo.getBookId());

			recordInfoDTO.setBorrowDate(DateHelper.formatDate(recordInfo
					.getDate()));
			recordInfoDTO.setDeadline(DateHelper.formatDate(DateHelper
					.getDeadline(recordInfo.getDate(), 3)));
			dtoList.add(recordInfoDTO);
		}
		return dtoList;
	}

	@Autowired
	public void setRecordInfoDao(IRecordInfoViewDAO recordInfoDao) {
		this.recordInfoDao = recordInfoDao;
	}

	public boolean orderBook(long userId, long bookId) {
		User user = userDao.findById(userId);
		Book book = bookDao.findById(bookId);
		Order order = new Order();
		order.setBook(book);
		order.setUser(user);
		orderDao.save(order);
		return true;
	}
	
	
	public boolean borrowBook(long userId,long bookId){
		User user = userDao.findById(userId);
		Book book = bookDao.findById(bookId);
		return this.borrowBook(user, book);
	}

	@Autowired
	public void setOrderDao(IOrderDAO orderDao) {
		this.orderDao = orderDao;
	}

	public List<OrderInfoDTO> getOrderInfoById(long userId) {

		List<OrderInfoView> list = orderInfoDao.findByUserId(userId);
		if (list.size() > 0) {
			List<OrderInfoDTO> dtoList = new ArrayList<OrderInfoDTO>();
			for (OrderInfoView orderInfo : list) {
				OrderInfoDTO dto = new OrderInfoDTO();
				dto.setAuthor(orderInfo.getAuthor());
				dto.setName(orderInfo.getBookName());
				dto.setBookClass(orderInfo.getBookClass());
				dto.setPress(orderInfo.getPress());
				dto.setPrice(orderInfo.getPrice());
				dto.setId(orderInfo.getId());

				dto.setOrderDate(DateHelper.formatDate(orderInfo.getDate()));
				dto.setDeadline(DateHelper.formatDate(DateHelper.getDeadline(
						orderInfo.getDate(), 3)));
				dtoList.add(dto);
			}
			return dtoList;
		} else
			return null;
	}

	public boolean borrowBook(User user,Book book){
		Record record=new Record();
		record.setUser(user);
		record.setBook(book);
		recordDao.save(record);
		return true;
	}
	
	public boolean borrowBookByOrder(long orderId) {
		Order order=orderDao.findById(orderId);
		this.borrowBook(order.getUser(), order.getBook());
		orderDao.delete(order);
		return true;
	}

	public boolean borrowBookByOrders(List<Long> orders) {
		List<Order> orderList=orderDao.findById(orders);
		for (Order order : orderList) {
			orderDao.delete(order);
			this.borrowBook(order.getUser(),order.getBook());
		}
		return true;
	}

}
