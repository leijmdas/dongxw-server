package com.kunlong.dongxw.util;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Hashtable;

/**
 * 二维码生成
 * 
 * @author zz
 *
 */
public class QRCodeGenerator {
	private static final String CHARSET = "utf-8";
	private static final String FORMAT_NAME = "PNG";
	// 二维码尺寸
	private int width = 256;
	private int height = 256;

	private Color bg = Color.WHITE;

	private BufferedImage logo;
	private int logoWidth;
	private int logoHeight;

	private boolean drawLogoAreaShape = false;

	private int padding = 10;

	public QRCodeGenerator() {
		this(null);
	}

	public QRCodeGenerator(BufferedImage logo) {
		this.logo = logo;
		if (logo != null) {
			this.logoWidth = logo.getWidth();
			this.logoHeight = logo.getHeight();
		}
	}

	public QRCodeGenerator(BufferedImage logo, int width, int height) {
		this(logo);
		this.width = width;
		this.height = height;

	}

	private BitMatrix getBitMatrixWithoutBlank(BitMatrix bitMatrix) {
		int[] rec = bitMatrix.getEnclosingRectangle();
		int resWidth = rec[2];
		int resHeight = rec[3];
		BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
		resMatrix.clear();
		for (int i = 0; i < resWidth; i++) {
			for (int j = 0; j < resHeight; j++) {
				if (bitMatrix.get(i + rec[0], j + rec[1])) {
					resMatrix.set(i, j);
				}
			}
		}
		return resMatrix;
	}

	/**
	 * 生成二维码
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public BufferedImage encodeQR(String content) throws Exception {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		MultiFormatWriter mfWriter = new MultiFormatWriter();

		BitMatrix bitMatrix = mfWriter.encode(content, BarcodeFormat.QR_CODE, this.width, this.height, hints);

		BitMatrix resMatrix = getBitMatrixWithoutBlank(bitMatrix);

		// 2
		int width = resMatrix.getWidth();

		int height = resMatrix.getHeight();

		int imgWidth = width + 2 * padding;
		int imgHeight = height + 2 * padding;
		BufferedImage image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);

		for (int x = 0; x < imgWidth; x++) {

			for (int y = 0; y < imgHeight; y++) {

				image.setRGB(x, y, bg.getRGB());

			}

		}
		for (int x = 0; x < width; x++) {

			for (int y = 0; y < height; y++) {
				int pointX = x + padding;
				int pointY = y + padding;

				image.setRGB(pointX, pointY, resMatrix.get(x, y) == true ?

						Color.BLACK.getRGB() : Color.WHITE.getRGB());

			}

		}
		if (logo != null) {
			this.insertImage(image);
		}
		return image;
	}

	public void writeQR(String content, OutputStream out) throws Exception {
		BufferedImage image = this.encodeQR(content);
		ImageIO.write(image, FORMAT_NAME, out);
	}

	public BufferedImage resizeImage(BufferedImage img, int w, int h) {
		BufferedImage tag = new BufferedImage(w, h, img.getType());
		Graphics2D g = tag.createGraphics();
		g.drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
		g.dispose();
		return tag;
	}

	/**
	 * 限定区域缩放大小
	 * 
	 * @param srcWidth
	 * @param srcHeight
	 * @param tarWidth
	 * @param tarHeight
	 * @return
	 */
	private Integer[] getZoomSize(int srcWidth, int srcHeight, int tarWidth, int tarHeight) {
		int currentWidth = srcWidth;
		int currentHeight = srcHeight;
		if (srcWidth > tarWidth) {
			currentWidth = tarWidth;
			currentHeight = (currentWidth * srcHeight) / srcWidth;
			return getZoomSize(currentWidth, currentHeight, tarWidth, tarHeight);
		}
		if (srcHeight > tarHeight) {
			currentHeight = tarHeight;
			currentWidth = srcWidth * (currentHeight / srcHeight);
			return getZoomSize(currentWidth, currentHeight, tarWidth, tarHeight);
		}
		return new Integer[] { currentWidth, currentHeight };

	}

	private BufferedImage getResizeLogo() {
		BufferedImage logoImg = logo;
		int width = logo.getWidth();
		int height = logo.getHeight();
		if (this.logoWidth != width || this.logoHeight != height) { // 指定了logo尺寸
			Integer[] roomedSize = this.getZoomSize(logo.getWidth(), logo.getHeight(), logoWidth, logoHeight);

			width = roomedSize[0];
			height = roomedSize[1];

			logoImg = resizeImage(logo, width, height);
		}
		return logoImg;
	}

	private void insertImage(BufferedImage source) throws Exception {

		BufferedImage logoImg = getResizeLogo();
		int width = logoImg.getWidth();
		int height = logoImg.getHeight();
		Graphics2D graph = source.createGraphics();
		int x = (source.getWidth() - width) / 2;
		int y = (source.getHeight() - height) / 2;

		graph.setColor(bg);
		if (drawLogoAreaShape) {
			graph.fillRoundRect(x - 2, y - 2, width + 4, height + 4, 5, 5);
		}
		graph.drawImage(logoImg, x, y, width, height, null);

		graph.dispose();
	}

	public InputStream getInputStream(BufferedImage img) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(img, FORMAT_NAME, os);
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		return is;
	}

	public void setBg(Color bg) {
		this.bg = bg;
	}

	public void setLogoWidth(int logoWidth) {
		this.logoWidth = logoWidth;
	}

	public void setLogoHeight(int logoHeight) {
		this.logoHeight = logoHeight;
	}

	public void setDrawLogoAreaShape(boolean drawLogoAreaShape) {
		this.drawLogoAreaShape = drawLogoAreaShape;
	}

	public static byte[] genQR(String text,String ext) throws Exception {
		QRCodeGenerator gen = new QRCodeGenerator();
		BufferedImage img = gen.encodeQR(text);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		ImageIO.write(img, ext == null? "PNG":ext, out);
		
		return out.toByteArray();
	}

	public static void main(String[] args) throws FileNotFoundException, Exception {

		// BufferedImage logo = ImageIO.read(new File("E:/apps/tmp/baidu.png"));
		QRCodeGenerator c2 = new QRCodeGenerator();
		c2.setLogoWidth(50);
		c2.setLogoHeight(50);
		c2.setDrawLogoAreaShape(true);
		c2.writeQR("http://192.168.121.38:9009/public/qr/redirect", new FileOutputStream(new File("E:/apps/tmp/2.jpg")));
	}
}
