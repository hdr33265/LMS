package studio.hdr.lms.service;

import java.util.List;

import studio.hdr.lms.dto.OrderInfoDTO;
import studio.hdr.lms.dto.RecordInfoDTO;

public interface IBorrowServce {
	public List<RecordInfoDTO> getRecordInfoById(long userId);
	public List<OrderInfoDTO> getOrderInfoById(long userId);
	public boolean orderBook(long userId,long bookId);
	public boolean borrowBook(long userId, long bookId);
	public boolean borrowBookByOrder(long orderId);
	public boolean borrowBookByOrders(List<Long> orders);
}
