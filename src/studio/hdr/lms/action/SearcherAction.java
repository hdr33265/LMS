package studio.hdr.lms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studio.hdr.lms.dto.BookInfoDTO;
import studio.hdr.lms.service.ISearcherServce;
import studio.hdr.lms.util.MyQuery;

import com.opensymphony.xwork2.ModelDriven;

@Component("searcherAction")
public class SearcherAction implements ModelDriven<MyQuery> {
	private ISearcherServce searcherServce;
	private MyQuery myQuery;
	private String queryString;
	private List<BookInfoDTO> bookInfos;

	public List<BookInfoDTO> getBookInfos() {
		return bookInfos;
	}

	@Autowired
	public void setSearcherServce(ISearcherServce searcherServce) {
		this.searcherServce = searcherServce;
	}

	public String commonSearch() {
		System.out.println("普通搜索");
		this.bookInfos = searcherServce.commonSearch(queryString);
		return "search";

	}

	public String advanceSearch() {
		this.bookInfos = searcherServce.advancedSearch(myQuery);
		return "search";
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public MyQuery getModel() {
		return myQuery;
	}

}
