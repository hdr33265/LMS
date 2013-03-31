package studio.hdr.lms.model.view;

import java.util.Date;


/**
 * UserInfoView entity. @author MyEclipse Persistence Tools
 */

public class UserInfoView  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private String mail;
     private String num;
     private String cellphone;
     private Integer grade;
     private String department;
     private String major;
     private String clbumm;
     private Long count;
     private Date birth;


    // Constructors

    /** default constructor */
    public UserInfoView() {
    }

	/** minimal constructor */
    public UserInfoView(String name, String mail, String department, String major) {
        this.name = name;
        this.mail = mail;
        this.department = department;
        this.major = major;
    }
    
    /** full constructor */
    public UserInfoView(String name, String mail, String num, String cellphone, Integer grade, String department, String major, String clbumm, Long count, Date birth) {
        this.name = name;
        this.mail = mail;
        this.num = num;
        this.cellphone = cellphone;
        this.grade = grade;
        this.department = department;
        this.major = major;
        this.clbumm = clbumm;
        this.count = count;
        this.birth = birth;
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

    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNum() {
        return this.num;
    }
    
    public void setNum(String num) {
        this.num = num;
    }

    public String getCellphone() {
        return this.cellphone;
    }
    
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Integer getGrade() {
        return this.grade;
    }
    
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return this.major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }

    public String getClbumm() {
        return this.clbumm;
    }
    
    public void setClbumm(String clbumm) {
        this.clbumm = clbumm;
    }

    public Long getCount() {
        return this.count;
    }
    
    public void setCount(Long count) {
        this.count = count;
    }

    public Date getBirth() {
        return this.birth;
    }
    
    public void setBirth(Date birth) {
        this.birth = birth;
    }
   








}