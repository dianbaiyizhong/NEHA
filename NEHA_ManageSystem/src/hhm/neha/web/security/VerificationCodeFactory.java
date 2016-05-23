/**
 *
 */
package hhm.neha.web.security;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

/**

 * @comment 验证码生成帮助类
 */
public class VerificationCodeFactory {
	private static final String[] wordArray = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private static final String[] wordNumberArray = {"A","C","D","E","F","G","H","J","K","L","M","N","P","Q","R","S","T","U","V","W","X","Y","2","3","4","5","6","7","8","9"};
	private ByteArrayInputStream image;// 图像
	private String code;// 验证码
	private int width;
	private int height;
	private int type;

	public VerificationCodeFactory(int width, int height, int type) throws IOException {
		this.width = width;
		this.height = height;
		this.type = type;
		init();// 初始化属性
	}

	/*
	 * 取得验证码图片
	 */
	public ByteArrayInputStream getImage() {
		return this.image;
	}

	/*
	 * 取得图片的验证码
	 */
	public String getCode() {
		return this.code;
	}

	private void init() throws IOException {
		// 在内存中创建图象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 生成随机类
		Random random = new Random();
		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 取随机产生的认证码(4位数字)
		switch (type){
		case 1:
			this.setOnlyNumberImage(g, random);
			break;
		case 2:
			this.setOnlyWordImage(g, random);
			break;
		case 3:
			this.setWordNumberImage(g, random);
			break;
		case 4:
			this.setMathImage(g, random);
			break;
		default:
			this.setOnlyNumberImage(g, random);
			break;
		}

		// 图象生效
		g.dispose();
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
		ImageIO.write(image, "JPEG", imageOut);
		imageOut.flush();
		imageOut.close();
		input = new ByteArrayInputStream(output.toByteArray());
		this.image = input;/* 赋值图像 */
	}

	/*
	 * 给定范围获得随机颜色
	 */
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	/**
	 * 纯字母型
	 * @param g
	 * @param random
	 */
	private void setOnlyWordImage(Graphics g, Random random){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int r = random.nextInt(wordArray.length);
			String rand = wordArray[r];
			buffer.append(rand);
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 20 * i + 9, 25);
		}
		// 赋值验证码
		this.code = buffer.toString();
	}
	
	/**
	 * 纯数字型
	 * @param g
	 * @param random
	 */
	private void setOnlyNumberImage(Graphics g, Random random){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int r = random.nextInt(10);
			String rand = String.valueOf(r);
			buffer.append(rand);
			// 赋值验证码
			this.code = buffer.toString();
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 20 * i + 9, 25);
		}
		
	}
	
	/**
	 * 数字与字母混合型 
	 * @param g
	 * @param random
	 */
	private void setWordNumberImage(Graphics g, Random random){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int r = random.nextInt(wordNumberArray.length);
			String rand = wordNumberArray[r];
			buffer.append(rand);
			// 赋值验证码
			this.code = buffer.toString();
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 20 * i + 9, 25);
		}
		
	}
	
	private void setMathImage(Graphics g, Random random) {
		StringBuffer buffer = new StringBuffer();
		int m = random.nextInt(3);
		int a;
		int b;
		switch (m) {
		case 0:
			int _a = random.nextInt(10);
			int _b = random.nextInt(10);
			if (_b > _a) {
				a = _b;
				b = _a;
			} else {
				a = _a;
				b = _b;
			}
			buffer.append(a - b);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(String.valueOf(a), 20 * 0 + 9, 25);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString("-", 20 * 1 + 9, 25);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(String.valueOf(b), 20 * 2 + 9, 25);
			break;
		case 1:
			a = random.nextInt(10);
			b = random.nextInt(10);
			buffer.append(a + b);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(String.valueOf(a), 20 * 0 + 9, 25);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString("+", 20 * 1 + 9, 25);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(String.valueOf(b), 20 * 2 + 9, 25);
			break;
		case 2:
			a = random.nextInt(10);
			b = random.nextInt(10);
			buffer.append(a * b);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(String.valueOf(a), 20 * 0 + 9, 25);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString("×", 20 * 1 + 9, 25);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(String.valueOf(b), 20 * 2 + 9, 25);
			break;
		default:
			a = random.nextInt(10);
			b = random.nextInt(10);
			buffer.append(a + b);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(String.valueOf(a), 20 * 0 + 9, 25);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString("+", 20 * 1 + 9, 25);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(String.valueOf(b), 20 * 2 + 9, 25);
			break;
		}
		g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
		g.drawString("=", 20 * 3 + 9, 25);
		// 赋值验证码
		this.code = buffer.toString();
	}
}
