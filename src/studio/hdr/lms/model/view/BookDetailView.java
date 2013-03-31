package studio.hdr.lms.model.view;



/**
 * BookDetailView entity. @author MyEclipse Persistence Tools
 */

public class BookDetailView  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private String author;
     private String bookClass;
     private String press;
     private Double price;
     private String description;
     private String state;
     private Long borrowCount;
     private String borrower;
     private String lang;


    // Constructors

    /** default constructor */
    public BookDetailView() {
    }

	/** minimal constructor */
    public BookDetailView(String name, String author, String bookClass, String press, String state, String borrower, String lang) {
        this.name = name;
        this.author = author;
        this.bookClass = bookClass;
        this.press = press;
        this.state = state;
        this.borrower = borrower;
        this.lang = lang;
    }
    
    /** full constructor */
    public BookDetailView(String name, String author, String bookClass, String press, Double price, String description, String state, Long borrowCount, String borrower, String lang) {
        this.name = name;
        this.author = author;
        this.bookClass = bookClass;
        this.press = press;
        this.price = price;
        this.description = description;
        this.state = state;
        this.borrowCount = borrowCount;
        this.borrower = borrower;
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

    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public Long getBorrowCount() {
        return this.borrowCount;
    }
    
    public void setBorrowCount(Long borrowCount) {
        this.borrowCount = borrowCount;
    }

    public String getBorrower() {
        return this.borrower;
    }
    
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getLang() {
        return this.lang;
    }
    
    public void setLang(String lang) {
        this.lang = lang;
    }
   








}