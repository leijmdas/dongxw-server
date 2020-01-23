package com.kunlong.dongxw.util;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.*;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

public class WebFileUtil {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private static String dir = "classpath:/templates";

	public WebFileUtil(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public WebFileUtil() {

	}


	public static String getFileExtByFilename(String filename) {
		if (StringUtils.trimAllWhitespace(filename).indexOf(".") < 0)
			return "";

		String fileExt = filename.substring(filename.lastIndexOf("."));
		return fileExt;
	}


  public static String getFileExt(File file) {
		return getFileExtByFilename(file.getName());
	}


  public String getOutputAttachementFilename(String filename) throws UnsupportedEncodingException {
		String userAgent = this.request.getHeader("User-Agent");
		String new_filename = URLEncoder.encode(filename, "UTF8");
		// 如果没有UA，则默认使用IE的方式进行编码，因为毕竟IE还是占多数的
		String rtn = "filename=\"" + new_filename + "\"";
		if (userAgent != null) {
			userAgent = userAgent.toLowerCase();
			// IE浏览器，只能采用URLEncoder编码
			if (userAgent.indexOf("msie") != -1) {
				rtn = "filename=\"" + new_filename + "\"";
			}
			// Opera浏览器只能采用filename*
			else if (userAgent.indexOf("opera") != -1) {
				rtn = "filename*=UTF-8''" + new_filename;
			}
			// Safari浏览器，只能采用ISO编码的中文输出
			else if (userAgent.indexOf("safari") != -1) {
				rtn = "filename=\"" + new String(filename.getBytes("UTF-8"), "ISO8859-1") + "\"";
			}
			
			// FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出
			else if (userAgent.indexOf("mozilla") != -1) {
				rtn = "filename*=UTF-8''" + new_filename;
			}
		}
		return rtn;
	}


  /**
	 * 导出至Excel
	 * @param templateName
	 * @param params
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void export2Excel(String templateName, Map<String, Object> params, String fileName) throws FileNotFoundException, IOException {
		setExcelHeader(fileName);

		JxlsUtil.exportExcel(resovePath(dir + "/" + templateName), params, this.response.getOutputStream());

	}


  //easyExcel
	public void export2EasyExcel(String fileName, Class<? extends BaseRowModel> clazz, List<? extends BaseRowModel> data) throws IOException {
		setExcelHeader(fileName);
		OutputStream out = response.getOutputStream();

		ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
		Sheet sheet = new Sheet(1, 0, clazz);
		sheet.setSheetName(fileName);
		writer.write(data, sheet);
		writer.finish();


	}

	public File export2EasyExcelFile(String fileName, List<String> titleNames, List<List<Object>> records) throws IOException {

		File file = File.createTempFile(fileName, ".xls");
		try (OutputStream out = new FileOutputStream(file)) {

			ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

			// 设置SHEET
			Sheet sheet = new Sheet(1, 0);
			sheet.setSheetName(fileName);

			// 设置标题
			Table table = new Table(1);
			List<List<String>> titles = new ArrayList<List<String>>();
			for (String name : titleNames) {
				titles.add(Arrays.asList(name));

			}
			table.setHead(titles);

			writer.write1(records, sheet, table);
			writer.finish();
		}
		return file;
	}

	public void export2EasyExcelObject(String fileName, List<String> titleNames, List<List<Object>> records) throws IOException {
		setExcelHeader(fileName);
		OutputStream out = response.getOutputStream();

		ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

		// 设置SHEET
		Sheet sheet = new Sheet(1, 0);
		sheet.setSheetName(fileName);

		// 设置标题
		Table table = new Table(1);
		 //定义Excel正文背景颜色
 		 TableStyle tableStyle = new TableStyle();
 		 tableStyle.setTableContentBackGroundColor(IndexedColors.WHITE);

  		//定义Excel正文字体大小
		Font fontContent = new Font();
		fontContent.setFontHeightInPoints((short) 10);
		fontContent.setBold(false);

 		tableStyle.setTableContentFont(fontContent);
		Font font = new Font();
		font.setFontHeightInPoints((short) 12);
		font.setBold(false);

		tableStyle.setTableHeadFont(font);
 		table.setTableStyle(tableStyle);

		List<List<String>> titles = new ArrayList<List<String>>();
		for (String name : titleNames) {
			titles.add(Arrays.asList(name));
		}
		table.setHead(titles);

		writer.write1(records, sheet, table);
		writer.finish();

	}

	//easyExcel
	public void export2EasyExcel(String fileName, List<String> titleNames, List<List<String>> records) throws IOException {
    setExcelHeader(fileName);
    OutputStream out = response.getOutputStream();

    ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

    // 设置SHEET
    Sheet sheet = new Sheet(1, 0);
    sheet.setSheetName("明细单");

    // 设置标题
    Table table = new Table(1);
    List<List<String>> titles = new ArrayList<List<String>>();
    for(String name:titleNames){
      titles.add(Arrays.asList(name));

    }
    table.setHead(titles);

    writer.write0(records, sheet, table);
    writer.finish();

  }

	public void export2EasyExcel2File(String fileName, List<String> titleNames, List<List<String>> records) throws IOException {
		setExcelHeader(fileName);
		//OutputStream out = response.getOutputStream();
		OutputStream out=new FileOutputStream(new File("c:/expost1.xls"));

		ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

		// 设置SHEET
		Sheet sheet = new Sheet(1, 0);
		sheet.setSheetName("明细单");

		// 设置标题
		Table table = new Table(1);
		List<List<String>> titles = new ArrayList<List<String>>();
		for(String name:titleNames){
			titles.add(Arrays.asList(name));

		}
		table.setHead(titles);

		writer.write0(records, sheet, table);
		writer.finish();

	}

  public void export2Excel(File tplFile, Map<String, Object> params, String fileName) throws IOException {
		setExcelHeader(fileName);
		JxlsUtil.exportExcel(tplFile,  params,this.response.getOutputStream());
	}


  private static String resovePath(String path) {
		return StringUtil.resolveUrl(path);
	}


  private void setExcelHeader(String fileName) throws UnsupportedEncodingException {
		//fileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("content-disposition", "attachment;  filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
		response.setHeader("attachment-name", URLEncoder.encode(fileName,"utf-8"));
		response.setHeader("content-Type", "application/vnd.ms-excel");
	 	response.setContentType("application/msexcel");
	}


  public void saveWorkbook(org.apache.poi.ss.usermodel.Workbook resultWorkbook, String fileName) throws IOException {
		OutputStream os = response.getOutputStream();
		try {
			response.setHeader("content-disposition", "attachment;  filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setContentType("application/msexcel");
			resultWorkbook.write(os);
			os.flush();
		} finally {
			try {
				os.close();
			} catch (Exception e) {
			}
		}
	}


  public void write2Response(File file) throws IOException{
		this.write2Response(new FileInputStream(file));
	}


  public void write2Response(InputStream is) throws IOException{
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		// 获取输入流
		bis = new BufferedInputStream(bis);
		// 输出流
		bos = new BufferedOutputStream(response.getOutputStream());
		try {
			byte[] buff = new byte[2048];
			int bytesRead;
			long len = 0;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
				len += bytesRead;
			}
			// 设置输出长度
			response.setHeader("Content-Length", String.valueOf(len));
			
		} finally {
			// 关闭流
			try {
				bis.close();
			} catch (Exception bisEx) {

			}
			try {
				bos.close();
			} catch (Exception bosEx) {

			}
		}
	}


  public void writeAttachment2Response(String outputFilename,InputStream is) throws IOException{
		
		// 设置文件输出类型
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;" + this.getOutputAttachementFilename(outputFilename));
		// 设置输出长度
		//response.setHeader("Content-Length", String.valueOf(fileLength));
		write2Response(is);
	}


  public void writeAttachment2Response(String outputFilename,File file) throws IOException{
		// 设置文件输出类型
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;" + this.getOutputAttachementFilename(outputFilename));
		write2Response(file);
	}

	public static void writeExcelOneSheetOnceWrite() throws IOException {

		// 生成EXCEL并指定输出路径
		OutputStream out = new FileOutputStream("c:\\exls.xlsx");
		ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

		// 设置SHEET
		Sheet sheet = new Sheet(1, 0);
		sheet.setSheetName("sheet1");

		// 设置标题
		Table table = new Table(1);
		List<List<String>> titles = new ArrayList<List<String>>();
		titles.add(Arrays.asList("用户ID"));
		titles.add(Arrays.asList("名称"));
		titles.add(Arrays.asList("年龄"));
		titles.add(Arrays.asList("生日"));
		table.setHead(titles);

		// 查询数据导出即可 比如说一次性总共查询出100条数据
		List<List<String>> userList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			userList.add(Arrays.asList("ID_" + i, "小明" + i, String.valueOf(i), new Date().toString()));
		}

		writer.write0(userList, sheet, table);
		writer.finish();
	}

	public static void main(String[] args) throws IOException {

		writeExcelOneSheetOnceWrite();
	}

}
