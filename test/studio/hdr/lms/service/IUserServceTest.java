package studio.hdr.lms.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import studio.hdr.lms.dto.MajorDTO;
import studio.hdr.lms.dto.UserDTO;
import studio.hdr.lms.dto.UserInfoDTO;
import studio.hdr.lms.model.User;
import studio.hdr.lms.service.IUserServce;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="txManager", defaultRollback=false)
@ContextConfiguration({"/applicationContext.xml","/beans.xml"})
@Transactional
public class IUserServceTest {

	@Autowired
	private IUserServce userServce;
	@Ignore
	@Test
	public void testGetMajorsFromDeaprtment(){
		System.out.println("*******************");
		List<MajorDTO> majors=userServce.getMajorsByDepartmentId(18);
		for (MajorDTO major : majors) {
			System.out.println(major.getMajorName());
		}
		System.out.println("*******************");
	}
	@Ignore
	@Test
	public void testGetPasswordByName() {
		Assert.assertEquals("a33265", this.userServce.getPasswordByName("hdr33265"));
	}
	@Ignore
	@Test
	public void testGetPasswordByName1() {
		Assert.assertEquals(null, this.userServce.getPasswordByName("hdr332656"));
	}
	@Test
	@Rollback(true)
	public void testChangePassword(){
		Assert.assertEquals("a33265", this.userServce.getPasswordByName("hdr33265"));
		this.userServce.changePasswordByUserId("hdr33265", 1);
		Assert.assertEquals("hdr33265", this.userServce.getPasswordByName("hdr33265"));
	}
	
	@Ignore
	@Test
	public void testGetUserInfoByUserId(){
		UserInfoDTO u=this.userServce.getUserInfoByUserId(1);
		System.out.println(u.getUserName());
	}
	@Ignore
	@Test
	@Rollback(true)
	public void testSaveUser(){
		System.out.println("###################################");
		System.out.println(userServce.getUserIdByUserName("zy"));
		UserDTO userDto = new UserDTO();
		userDto.setUsername("huangdunren4");
		userDto.setPassword("a33265");
		userDto.setCellphone("15273664362");
		userDto.setMail("9565591@sina.com");
		userDto.setSex("男");
		userDto.setQuestion("尼玛");
		userDto.setAnswer("艾玛");

		userDto.setGrade("2009");
		userDto.setDepartment(17);
		userDto.setMajor(03);
		userDto.setClbumm(01);
		userDto.setNum("36");

		userDto.setYear("1990");
		userDto.setMonth("7");
		userDto.setDay("25");

		User user = userServce.transform(userDto);
		userServce.saveUser(user);
		String pwd=userServce.getPasswordByName("huangdunren4");
		Assert.assertEquals(pwd, "a33265");
		 System.out.println("###################################");
	}

}
