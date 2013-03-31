package studio.hdr.lms.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import studio.hdr.lms.util.CaptchaImageFactory;

import com.opensymphony.xwork2.ActionSupport;

@Component("imageAction")
@Scope("prototype")
public class ImageAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String captcha;
	private boolean isCaptchaRight;

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	/**
	 * 检查验证码是否输入正确
	 * */
	public String validateCode() throws IOException {

		String randCode = (String) request.getSession().getAttribute(
				"captchaString");

		if (randCode.equalsIgnoreCase(captcha)) {
			this.isCaptchaRight=true;
		} else {
			this.isCaptchaRight=false;
		}
		return "captcha";
	}

	/**
	 * 执行登陆的业务处理
	 * 
	 * @param request
	 *            :发送上来的请求
	 * @return destJsp：目标URL
	 */
	public String execute() {
		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String captchaString = CaptchaImageFactory.getFactory()
				.getCaptchaString();
		request.getSession().setAttribute("captchaString", captchaString);
		BufferedImage image = CaptchaImageFactory.getFactory()
				.getCaptchaImage();
		// 将认证码存入SESSION
		request.getSession().setAttribute("captcha", captchaString);
		// 图象生效
		ServletOutputStream output;
		try {
			output = response.getOutputStream();
			ImageIO.write(image, "JPEG", output);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean getIsCaptchaRight() {
		return isCaptchaRight;
	}

	public void setCaptchaRight(boolean isCaptchaRight) {
		this.isCaptchaRight = isCaptchaRight;
	}

}