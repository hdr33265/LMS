package studio.hdr.lms.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.DoubleField;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wltea.analyzer.lucene.IKAnalyzer;

import studio.hdr.lms.dao.IBookInfoViewDAO;
import studio.hdr.lms.model.view.BookInfoView;

/**
 * 这个类负责与lucene打交道
 * 
 * @author hdr
 * 
 */

@Component("luceneHelper")
public class LuceneHelper {
	private IBookInfoViewDAO bookInfoViewDao;
	private String[] commonFields;
	private BooleanClause.Occur[] commonOccurs;
	public String[] indexPaths = { "../webapps/LMS/index", "WebRoot/index",
			"webapps/LMS/index" };
	// public String indexPath = "WebRoot/index";
	private Analyzer analyzer;
	private IndexSearcher searcher;
	Directory dir = null;

	/**
	 * 初始化的方法，每次系统启动，必须初始化
	 */
	@PostConstruct
	public void init() {
		analyzer = new IKAnalyzer();
		commonFields = new String[] { IBookInfoViewDAO.NAME,
				IBookInfoViewDAO.AUTHOR, IBookInfoViewDAO.DESCRIPTION };
		commonOccurs = new BooleanClause.Occur[] { BooleanClause.Occur.SHOULD,
				BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD };
		try {
			File indexDir = null;
			for (int i = 0; i < indexPaths.length; i++) {
				indexDir = new File(indexPaths[i]);
				if (indexDir.exists())
					break;
			}
			dir = FSDirectory.open(indexDir);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		IndexReader reader = null;
		try {
			reader = DirectoryReader.open(dir);
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		searcher = new IndexSearcher(reader);
	}

	/**
	 * 为图书列表建立索引文件，可根据需要调用
	 */
	public void createIndex() {
		List<BookInfoView> list = bookInfoViewDao.findAll();
		Analyzer analyzer = new IKAnalyzer();
		try {

			IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_40,
					analyzer);
			iwc.setOpenMode(OpenMode.CREATE);
			IndexWriter writer = new IndexWriter(dir, iwc);
			for (BookInfoView b : list) {
				Document doc = new Document();
				doc.add(new LongField("id", b.getId(), Field.Store.YES));
				doc.add(new TextField(IBookInfoViewDAO.NAME, b.getName(),
						Field.Store.NO));
				doc.add(new TextField(IBookInfoViewDAO.AUTHOR, b.getAuthor(),
						Field.Store.NO));
				doc.add(new TextField(IBookInfoViewDAO.BOOK_CLASS, b
						.getBookClass(), Field.Store.NO));
				doc.add(new TextField(IBookInfoViewDAO.PRESS, b.getPress(),
						Field.Store.NO));
				doc.add(new TextField(IBookInfoViewDAO.DESCRIPTION, b
						.getDescription(), Field.Store.NO));
				doc.add(new TextField(IBookInfoViewDAO.LANG, b.getLang(),
						Field.Store.NO));
				doc.add(new DoubleField(IBookInfoViewDAO.PRICE, b.getPrice(),
						Field.Store.NO));
				writer.addDocument(doc);
			}
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 普通查询<br/>
	 * 对查询语句queryString进行查询<br/>
	 * 主要查询书名、作者以及书的描述
	 * 
	 * @param queryString
	 * @return 查询成功则返回图书ID列表，否则返回空
	 */
	public List<Long> commonSearch(String queryString) {

		try {
			Query query = MultiFieldQueryParser.parse(Version.LUCENE_40,
					queryString, commonFields, commonOccurs, analyzer);
			TopDocs results = searcher.search(query, 50);
			ScoreDoc[] hits = results.scoreDocs;
			if (hits.length != 0) {
				List<Long> bis = new ArrayList<Long>(hits.length);
				for (int i = 0; i < hits.length; i++) {
					Document doc = searcher.doc(hits[i].doc);
					bis.add(doc.getField("id").numericValue().longValue());
				}
				return bis;
			} else
				return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 调用lucene的API进行高级查询<br/>
	 * 可以精确到各个字段的查询，进行‘且’、‘或’、‘非’的逻辑组合
	 * 
	 * @param myQuery
	 *            自定义的查询体，可自由设定
	 * @return 成功则图书ID列表，否则返回为空
	 */
	public List<Long> advancedSearch(MyQuery myQuery) {
		List<String> fields = new ArrayList<String>(8);
		List<String> queries = new ArrayList<String>(8);
		if (myQuery.getName() != null) {
			fields.add(IBookInfoViewDAO.NAME);
			queries.add(myQuery.getName());
		}
		if (myQuery.getAuthor() != null) {
			fields.add(IBookInfoViewDAO.AUTHOR);
			queries.add(myQuery.getAuthor());
		}
		if (myQuery.getBookClass() != null) {
			fields.add(IBookInfoViewDAO.BOOK_CLASS);
			queries.add(myQuery.getBookClass());
		}
		if (myQuery.getPress() != null) {
			fields.add(IBookInfoViewDAO.PRESS);
			queries.add(myQuery.getPress());
		}
		if (myQuery.getLang() != null) {
			fields.add(IBookInfoViewDAO.LANG);
			queries.add(myQuery.getLang());
		}
		if (myQuery.getDescription() != null) {
			fields.add(IBookInfoViewDAO.DESCRIPTION);
			queries.add(myQuery.getDescription());
		}
		BooleanClause.Occur[] flags = new BooleanClause.Occur[fields.size()];
		for (int i = 0; i < flags.length; i++) {
			flags[i] = BooleanClause.Occur.MUST;
		}
		String[] fstrs = new String[fields.size()];
		String[] qstrs = new String[fields.size()];
		try {
			Query query = MultiFieldQueryParser.parse(Version.LUCENE_40,
					queries.toArray(qstrs), fields.toArray(fstrs), flags,
					analyzer);
			TopDocs results = searcher.search(query, 10);
			ScoreDoc[] hits = results.scoreDocs;
			List<Long> bis = new ArrayList<Long>(hits.length);
			for (int i = 0; i < hits.length; i++) {
				Document doc = searcher.doc(hits[i].doc);
				bis.add(doc.getField("id").numericValue().longValue());
			}
			return bis;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Autowired
	public void setBookInfoViewDao(IBookInfoViewDAO bookInfoViewDao) {
		this.bookInfoViewDao = bookInfoViewDao;
	}

}
