package studio.hdr.lms.model.view;



/**
 * BookInfoView entity. @author MyEclipse Persistence Tools
 */

public class BookInfoView  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private String author;
     private String bookClass;
     private String press;
     private Long count;
     private Long availableCount;
     private Double price;
     private String description;
     private String lang;


    // Constructors

    /** default constructor */
    public BookInfoView() {
    }

	/** minimal constructor */
    public BookInfoView(String name, String author, String bookClass, String press, Long count, Long availableCount, String lang) {
        this.name = name;
        this.author = author;
        this.bookClass = bookClass;
        this.press = press;
        this.count = count;
        this.availableCount = availableCount;
        this.lang = lang;
    }
    
    /** full constructor */
    public BookInfoView(String name, String author, String bookClass, String press, Long count, Long availableCount, Double price, String description, String lang) {
        this.name = name;
        this.author = author;
        this.bookClass = bookClass;
        this.press = press;
        this.count = count;
        this.availableCount = availableCount;
        this.price = price;
        this.description = description;
        this.lang = lang;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookClass() {
        return this.bookClass;
    }
    
    public void setBookClass(String bookClass) {
        this.bookClass = bookClass;
    }

    public String getPress() {
        return this.press;
    }
    
    public void setPress(String press) {
        this.press = press;
    }

    public Long getCount() {
        return this.count;
    }
    
    public void setCount(Long count) {
        this.count = count;
    }

    public Long getAvailableCount() {
        return this.availableCount;
    }
    
    public void setAvailableCount(Long availableCount) {
        this.availableCount = availableCount;
    }

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLang() {
        return this.lang;
    }
    
    public void setLang(String lang) {
        this.lang = lang;
    }
   








}