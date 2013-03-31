package studio.hdr.lms.service;

import java.util.List;

import studio.hdr.lms.dto.BookInfoDTO;
import studio.hdr.lms.util.MyQuery;

public interface ISearcherServce {
	public List<BookInfoDTO> commonSearch(String queryString);
	public List<BookInfoDTO> advancedSearch(MyQuery myQuery);
}
