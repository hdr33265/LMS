package studio.hdr.lms.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaImageFactory {

	private static String s = "012345678901234567890123456789ABCDEFGHIJKLMNPQRSTUVWXYZ012345678901234567890123456789abcdefghijkmnpqrstuvwxyz";

	private static CaptchaImageFactory factory;

	private static int width = 60;

	private static int height = 20;

	private static Random random;
	
	private String captchaString;
	
	private int length=4;

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		CaptchaImageFactory.width = width;
	}

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		CaptchaImageFactory.height = height;
	}

	public static CaptchaImageFactory getFactory() {
		if (factory == null){
			random=new Random();
			factory = new CaptchaImageFactory();
		}
		return factory;
	}

	public BufferedImage getCaptchaImage() {
		BufferedImage captchaImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		Graphics2D g2 = (Graphics2D) captchaImage.getGraphics();

		g2.setFont(new Font("Times New Roman",Font.BOLD,20));
		Color bgColor = getRandColor(220, 250);
		g2.setBackground(bgColor);
		g2.fillRect(0, 0, width, height);

		g2.draw3DRect(0, 0, width - 1, height - 1, true);
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g2.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g2.drawLine(x, y, x + xl, y + yl);
		}

		char rand;
		for (int i = 0; i < captchaString.length(); i++) {
			rand=captchaString.charAt(i);
			// 将认证码显示到图象中
			g2.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g2.drawString(String.valueOf(rand), 13 * i + 6, 16);
		}
		g2.drawOval(0, 12, 60, 11);
		g2.dispose();
		return captchaImage;
	}

	private Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	public String getCaptchaString() {
		StringBuffer strbuf=new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			strbuf.append(s.charAt(random.nextInt(s.length())));
		}
		this.setCaptchaString(strbuf.toString());
		return captchaString;
	}

	public void setCaptchaString(String captchaString) {
		this.captchaString = captchaString;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
