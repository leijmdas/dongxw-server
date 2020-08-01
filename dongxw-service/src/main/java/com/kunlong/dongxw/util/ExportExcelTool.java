package com.kunlong.dongxw.util;

import com.kunlong.dongxw.report.base.IRptDTO;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName: ExportExcelUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jasper
 * @date 2019年12月4日
 *
 * @param <T>
 */
@Component
public class ExportExcelTool<T extends IRptDTO> {

	// 2007 版本以上 最大支持1048576行
	public final static String EXCEl_FILE_2007 = "2007";
	// 2003 版本 最大支持65536 行
	public final static String EXCEL_FILE_2003 = "2003";

	private String EXCELSUFFIX = ".xlsx";

	/**
	 * <p>
	 * 导出无头部标题行Excel <br>
	 * 时间格式默认：yyyy-MM-dd hh:mm:ss <br>
	 * </p>
	 * 
	 * @param title   表格标题
	 * @param dataset 数据集合
	 * @param out     输出流
	 * @param version 2003 或者 2007，不传时默认生成2003版本
	 */
	public void exportExcel(String title, Collection<T> dataset, OutputStream out, String version) {
		if (StringUtils.isEmpty(version) || EXCEL_FILE_2003.equals(version.trim())) {
			exportExcel2003(title, null, dataset, out, "yyyy-MM-dd HH:mm:ss");
		} else {
			//exportExcel2007(title, null, dataset, out, "yyyy-MM-dd HH:mm:ss");
		}
	}
	/**
	 * 复制文件
	* @Title: copyfile
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param excelFile
	* @param @param filename
	* @param @param position
	* @param @return    参数
	* @return File    返回类型
	* @throws
	 */
	public File copyfile(File targetFile, String keyname, String position) {
		String absolutePath = targetFile.getAbsolutePath();
		File fromFile = new File(position, keyname + EXCELSUFFIX);
		// 生成目标文件
		File file = new File(absolutePath);
		///new CopyFile().copyfile(fromFile, file, true);
		return file;
	}
	/**
	 * 
	* @Title: exportExcel
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param dataset
	* @param @param excelFile
	* @param @param filename
	* @param @param position
	* @param @throws Exception    参数
	* @return void    返回类型
	* @throws
	 */
	public void exportExcel(Collection<T> dataset, File excelFile, String filename, String position) throws Exception {
	//	HashMap<Integer,String> maps=new HashMap<Integer,String>();
		String absolutePath = excelFile.getAbsolutePath();
		File fromFile = new File(position, filename + EXCELSUFFIX);
		// 生成目标文件
		File file = new File(absolutePath);
		//new CopyFile().copyfile(fromFile, file, true);
		FileInputStream fs = new FileInputStream(file); // 获取head.xls
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0); // 获取到工作表，因为一个excel可能有多个工作表
		XSSFRow row = sheet.getRow(0); // 获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值
		System.out.println(sheet.getLastRowNum() + " " + row.getLastCellNum()); // 分别得到最后一行的行号，和一条记录的最后一个单元格
//		int end=row.getLastCellNum();
//		for(int i=0;i<end;i++) {
//			String cellValue=row.getCell(i).getStringCellValue();
//			maps.put(i, cellValue);
//		}
		FileOutputStream out = new FileOutputStream(file); // 向head.xls中写数据
		// 遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();
		int index = sheet.getLastRowNum();
		T t;
		Field[] fields;
		Field field;
		XSSFRichTextString richString;
		Pattern p = Pattern.compile("^//d+(//.//d+)?$");
		Matcher matcher;
		String fieldName;
		String getMethodName;
		XSSFCell cell;
		Class tCls;
		Method getMethod;
		Object value;
		String textValue;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			t = (T) it.next();
			// 利用反射，根据JavaBean属性的先后顺序，动态调用getXxx()方法得到属性值
			fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				cell = row.createCell(i);
				field = fields[i];
				fieldName = field.getName();
				getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				try {
					tCls = t.getClass();
					getMethod = tCls.getMethod(getMethodName, new Class[] {});
					value = getMethod.invoke(t, new Object[] {});
					// 判断值的类型后进行强制类型转换
					textValue = null;
					if (value instanceof Integer) {
						createCell(workbook,row,i,(Integer)value,"###,##0");
					} else if (value instanceof Float) {
						createCell(workbook,row,i,(Float)value,"###,##0.0");
					} else if (value instanceof Double) {
						if(ObjectUtils.isEmpty(value)) {
							value=0.0;
						}
						if((Double)value==1010101010.0) {
					        CellStyle cellStyle=workbook.createCellStyle(); // 创建单元格样式
					        cell=row.createCell(i);  // 创建单元格
							cellStyle.setBorderBottom(BorderStyle.THIN);
							cellStyle.setBorderLeft(BorderStyle.THIN); // 设置边界的类型单元格的左边框
							cellStyle.setBorderRight(BorderStyle.THIN);
							cellStyle.setBorderTop(BorderStyle.THIN);
					        cellStyle.setAlignment(HorizontalAlignment.CENTER);
							cell.setCellValue("/");
							cell.setCellStyle(cellStyle);
						}else {
						createCell(workbook,row,i,(Double)value,"###,##0.0");
						}
						
					} else if (value instanceof Long) {
						cell.setCellValue((Long) value);
					} else if (value instanceof BigDecimal) {
						BigDecimal fenMuZero = new BigDecimal("1010101010");
						if (fenMuZero.compareTo((BigDecimal) value) == 0) {
					        CellStyle cellStyle=workbook.createCellStyle(); // 创建单元格样式
					        cell=row.createCell(i);  // 创建单元格
							cellStyle.setBorderBottom(BorderStyle.THIN);
							cellStyle.setBorderLeft(BorderStyle.THIN); // 设置边界的类型单元格的左边框
							cellStyle.setBorderRight(BorderStyle.THIN);
							cellStyle.setBorderTop(BorderStyle.THIN);
					        cellStyle.setAlignment(HorizontalAlignment.CENTER);
							cell.setCellValue("/");
							cell.setCellStyle(cellStyle);
						} else {
							Double result = ((BigDecimal) value).doubleValue();
							if (ObjectUtils.isEmpty(value)) {
								value = BigDecimal.ZERO;
							}
							createCell(workbook, row, i, result, "###,##0.0");
						}
					}else if (value instanceof Boolean) {
						textValue = "是";
						if (!(Boolean) value) {
							textValue = "否";
						}
					} else if (value instanceof Date) {
						textValue = sdf.format((Date) value);
					} else {
						// 其它数据类型都当作字符串简单处理
						if (value != null) {
							textValue = value.toString();
							cell.setCellValue(textValue);
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} finally {
					// 清理资源
				}
			}
		}
		try {
			out.flush();
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    private static void createCell(Workbook workbook,Row row,int column,Object value,String pattern){
        CellStyle cellStyle=workbook.createCellStyle(); // 创建单元格样式
        Cell cell=row.createCell(column);  // 创建单元格
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN); // 设置边界的类型单元格的左边框
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
		  Font font = workbook.createFont();
			font.setFontName("宋体"); //设置字体
			font.setFontHeightInPoints((short) 11); //设置字号
			font.setBold(true); //设置字体样式 正常显示
        if(value instanceof Integer) {
        	 Integer result=(Integer)value;
        	  cell.setCellValue( result); 
        	  if(result<0) {
        			font.setColor(IndexedColors.RED.getIndex());
        	        cellStyle.setFont(font);
        	  }
        	 
        }else if(value instanceof Double) {
        	Double result=(Double)value;
       	  cell.setCellValue( result); 
       	  if(result<0) {
       			font.setColor(IndexedColors.RED.getIndex());
       	        cellStyle.setFont(font);
       	  }
       	 
       
      }else if(value instanceof BigDecimal) {
        	Double result=((BigDecimal) value).doubleValue();
         	  cell.setCellValue( result); 
         	  if(result<0) {
         			font.setColor(IndexedColors.RED.getIndex());
         	        cellStyle.setFont(font);
         	  }
         	 
         
        }else if(value instanceof Float) {
        	Float result=(Float)value;
      	  cell.setCellValue( result); 
     	  if(result<0) {
     			font.setColor(IndexedColors.RED.getIndex());
     	        cellStyle.setFont(font);
     	  }
        }

        cellStyle.setDataFormat(workbook.createDataFormat().getFormat(pattern));
        cell.setCellStyle(cellStyle);

}
	/**
	 * <p>
	 * 导出带有头部标题行的Excel <br>
	 * 时间格式默认：yyyy-MM-dd hh:mm:ss <br>
	 * </p>
	 * 
	 * @param title   表格标题
	 * @param headers 头部标题集合
	 * @param dataset 数据集合
	 * @param out     输出流
	 * @param version 2003 或者 2007，不传时默认生成2003版本
	 */
	public void exportExcel(String title, String[] headers, Collection<T> dataset, OutputStream out, String version) {
		if (StringUtils.isEmpty(version) || EXCEL_FILE_2003.equals(version.trim())) {
			exportExcel2003(title, headers, dataset, out, "yyyy-MM-dd HH:mm:ss");
		} else {
			//exportExcel2007(title, headers, dataset, out, "yyyy-MM-dd HH:mm:ss");
		}
	}

	/**
	 * <p>
	 * 通用Excel导出方法,利用反射机制遍历对象的所有字段，将数据写入Excel文件中 <br>
	 * 此版本生成2007以上版本的文件 (文件后缀：xlsx)
	 * </p>
	 * 
	 * @param title   表格标题名
	 * @param headers 表格头部标题集合
	 * @param dataset 需要显示的数据集合,集合中一定要放置符合JavaBean风格的类的对象。此方法支持的
	 *                JavaBean属性的数据类型有基本数据类型及String,Date
	 * @param out     与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern 如果有时间数据，设定输出格式。默认为"yyyy-MM-dd hh:mm:ss"
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void exportExcel2007(String title, String[] headers, Collection<T> dataset, OutputStream out,
								String pattern, XSSFWorkbook workbook) {

		// 声明一个工作薄
		//XSSFWorkbook workbook = new XSSFWorkbook();
		// 生成一个表格
		XSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(20);
		// 生成一个样式
		XSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(new XSSFColor(java.awt.Color.gray));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setAlignment(HorizontalAlignment.CENTER);
		// 生成一个字体
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontName("宋体");
		font.setColor(new XSSFColor(java.awt.Color.BLACK));
		font.setFontHeightInPoints((short) 11);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		XSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE));
		style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style2.setBorderBottom(BorderStyle.THIN);
		style2.setBorderLeft(BorderStyle.THIN);
		style2.setBorderRight(BorderStyle.THIN);
		style2.setBorderTop(BorderStyle.THIN);
		style2.setAlignment(HorizontalAlignment.CENTER);
		style2.setVerticalAlignment(VerticalAlignment.CENTER);
		// 生成另一个字体
		XSSFFont font2 = workbook.createFont();
		//font2.setBold(true);
		// 把字体应用到当前的样式
		style2.setFont(font2);

		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		XSSFCell cellHeader;
		for (int i = 0; i < headers.length; i++) {
			cellHeader = row.createCell(i);
			cellHeader.setCellStyle(style);
			cellHeader.setCellValue(new XSSFRichTextString(headers[i]));
		}

		// 遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();
		int index = 0;
		T t;

		XSSFRichTextString richString;
		Pattern p = Pattern.compile("^//d+(//.//d+)?$");
		Matcher matcher;

		Method getMethod;

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			t = (T) it.next();
			// 利用反射，根据JavaBean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[]  fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				boolean isStatic = Modifier.isStatic(field.getModifiers());
				if(isStatic){
					continue;
				}

				String fieldName = field.getName();
				String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				try {

					Class  tCls = t.getClass();
					try {
						getMethod = tCls.getMethod(getMethodName, new Class[]{});
					}catch (java.lang.NoSuchMethodException e){
						continue;
					}
					XSSFCell cell = row.createCell(i);
					cell.setCellStyle(style2);
					 ;
					Object value = getMethod.invoke(t, new Object[] {});
					// 判断值的类型后进行强制类型转换
					String textValue = null;
					if (value instanceof Integer) {
						cell.setCellValue((Integer) value);
					} else if (value instanceof Float) {
						textValue = String.valueOf((Float) value);
						cell.setCellValue(textValue);
					} else if (value instanceof Double) {
						textValue = String.valueOf((Double) value);
						cell.setCellValue(textValue);
					} else if (value instanceof Long) {
						cell.setCellValue((Long) value);
					}
					if (value instanceof Boolean) {
							textValue = (Boolean) value?"是":"否";

					} else if (value instanceof Date) {
						textValue = sdf.format((Date) value);
					} else if (value instanceof BigDecimal){
						Double result = ((BigDecimal) value).doubleValue();
						if (ObjectUtils.isEmpty(value)) {
							value = BigDecimal.ZERO;
						}
						//createCell(workbook, row, i, result, "###,##0.00");
						cell.setCellValue(result);
					}
					else {
						// 其它数据类型都当作字符串简单处理
						if (value != null) {
							textValue = value.toString();
						}
					}
					if (textValue != null) {
						matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							richString = new XSSFRichTextString(textValue);
							cell.setCellValue(richString);
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} finally {
					// 清理资源
				}
			}
		}
		try {
			 workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * 通用Excel导出方法,利用反射机制遍历对象的所有字段，将数据写入Excel文件中 <br>
	 * 此方法生成2003版本的excel,文件名后缀：xls <br>
	 * </p>
	 * 
	 * @param title   表格标题名
	 * @param headers 表格头部标题集合
	 * @param dataset 需要显示的数据集合,集合中一定要放置符合JavaBean风格的类的对象。此方法支持的
	 *                JavaBean属性的数据类型有基本数据类型及String,Date
	 * @param out     与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern 如果有时间数据，设定输出格式。默认为"yyyy-MM-dd hh:mm:ss"
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void exportExcel2003(String title, String[] headers, Collection<T> dataset, OutputStream out,
			String pattern) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(20);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setAlignment(HorizontalAlignment.CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontName("宋体");
		font.setColor(HSSFColor.WHITE.index);
		font.setFontHeightInPoints((short) 11);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.WHITE.index);
		style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style2.setBorderBottom(BorderStyle.THIN);
		style2.setBorderLeft(BorderStyle.THIN);
		style2.setBorderRight(BorderStyle.THIN);
		style2.setBorderTop(BorderStyle.THIN);
		style2.setAlignment(HorizontalAlignment.CENTER);
		style2.setVerticalAlignment(VerticalAlignment.CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBold(true);
		// 把字体应用到当前的样式
		style2.setFont(font2);

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		HSSFCell cellHeader;
		for (int i = 0; i < headers.length; i++) {
			cellHeader = row.createCell(i);
			cellHeader.setCellStyle(style);
			cellHeader.setCellValue(new HSSFRichTextString(headers[i]));
		}

		// 遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();
		int index = 0;
		T t;
		Field[] fields;
		Field field;
		HSSFRichTextString richString;
		Pattern p = Pattern.compile("^//d+(//.//d+)?$");
		Matcher matcher;
		String fieldName;
		String getMethodName;
		HSSFCell cell;
		Class tCls;
		Method getMethod;
		Object value;
		String textValue;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			t = (T) it.next();
			// 利用反射，根据JavaBean属性的先后顺序，动态调用getXxx()方法得到属性值
			fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(style2);
				field = fields[i];
				fieldName = field.getName();
				getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				try {
					tCls = t.getClass();
					getMethod = tCls.getMethod(getMethodName, new Class[] {});
					value = getMethod.invoke(t, new Object[] {});
					// 判断值的类型后进行强制类型转换
					textValue = null;
					if (value instanceof Integer) {
						cell.setCellValue((Integer) value);
					} else if (value instanceof Float) {
						textValue = String.valueOf((Float) value);
						cell.setCellValue(textValue);
					} else if (value instanceof Double) {
						textValue = String.valueOf((Double) value);
						cell.setCellValue(textValue);
					} else if (value instanceof Long) {
						cell.setCellValue((Long) value);
					}
					if (value instanceof Boolean) {
						textValue = "是";
						if (!(Boolean) value) {
							textValue = "否";
						}
					} else if (value instanceof Date) {
						textValue = sdf.format((Date) value);
					} else {
						// 其它数据类型都当作字符串简单处理
						if (value != null) {
							textValue = value.toString();
						}
					}
					if (textValue != null) {
						matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							richString = new HSSFRichTextString(textValue);
							cell.setCellValue(richString);
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} finally {
					// 清理资源
				}
			}
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	* @Title: exportExcel
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param workbook
	* @param @param monthlyPurchaseDetailsPoList    参数
	* @return void    返回类型
	* @throws
	 */
	public void exportExcel(XSSFWorkbook workbook, Collection<T> dataset,OutputStream out) {
		XSSFSheet sheet = workbook.getSheetAt(0); // 获取到工作表，因为一个excel可能有多个工作表
		XSSFRow row = sheet.getRow(0); // 获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值
		System.out.println(sheet.getLastRowNum() + " " + row.getLastCellNum()); // 分别得到最后一行的行号，和一条记录的最后一个单元格
		Iterator<T> it = dataset.iterator();
		int index = sheet.getLastRowNum();
		T t;
		Field[] fields;
		Field field;
		XSSFRichTextString richString;
		Pattern p = Pattern.compile("^//d+(//.//d+)?$");
		Matcher matcher;
		String fieldName;
		String getMethodName;
		XSSFCell cell;
		Class tCls;
		Method getMethod;
		Object value;
		String textValue;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			t = (T) it.next();
			// 利用反射，根据JavaBean属性的先后顺序，动态调用getXxx()方法得到属性值
			fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				cell = row.createCell(i);
				field = fields[i];
				fieldName = field.getName();
				getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				try {
					tCls = t.getClass();
					getMethod = tCls.getMethod(getMethodName, new Class[] {});
					value = getMethod.invoke(t, new Object[] {});
					// 判断值的类型后进行强制类型转换
					textValue = null;
					if (value instanceof Integer) {
						cell.setCellValue((Integer) value);
					} else if (value instanceof Float) {
						textValue = String.valueOf((Float) value);
						cell.setCellValue(textValue);
					} else if (value instanceof Double) {
						textValue = String.valueOf((Double) value);
						cell.setCellValue(textValue);
					} else if (value instanceof Long) {
						cell.setCellValue((Long) value);
					}else if (value instanceof Boolean) {
						textValue = "是";
						if (!(Boolean) value) {
							textValue = "否";
						}
					} else if (value instanceof Date) {
						textValue = sdf.format((Date) value);
					} else {
						// 其它数据类型都当作字符串简单处理
						if (value != null) {
							textValue = value.toString();
						}
					}
					if (textValue != null) {
						matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							richString = new XSSFRichTextString(textValue);
							cell.setCellValue(richString);
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} finally {
					// 清理资源
				}
			
			}
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setCellObjectValue(Workbook workbook,Row row,int column,Object value) {
		if (value instanceof Integer) {
			createCell(workbook,row,column,(Integer)value,"###,##0");
		} else if (value instanceof Float) {
			createCell(workbook,row,column,(Float)value,"###,##0.0");
		} else if (value instanceof Double) {

			if(ObjectUtils.isEmpty(value)) {
				value=0.0;
			}
			if((Double)value==1010101010.0) {
				CellStyle cellStyle=workbook.createCellStyle(); // 创建单元格样式
				Cell cell=row.createCell(column);  // 创建单元格
				cellStyle.setBorderBottom(BorderStyle.THIN);
				cellStyle.setBorderLeft(BorderStyle.THIN); // 设置边界的类型单元格的左边框
				cellStyle.setBorderRight(BorderStyle.THIN);
				cellStyle.setBorderTop(BorderStyle.THIN);
				cellStyle.setAlignment(HorizontalAlignment.CENTER);
				cell.setCellValue("/");
				cell.setCellStyle(cellStyle);
			}else {
				createCell(workbook,row,column,(Double)value,"###,##0.0");
			}
		} else if(value instanceof BigDecimal) {

			BigDecimal fenMuZero = new BigDecimal("1010101010");
			if (fenMuZero.compareTo((BigDecimal) value) == 0) {
				CellStyle cellStyle=workbook.createCellStyle(); // 创建单元格样式
				Cell cell=row.createCell(column);  // 创建单元格
				cellStyle.setBorderBottom(BorderStyle.THIN);
				cellStyle.setBorderLeft(BorderStyle.THIN); // 设置边界的类型单元格的左边框
				cellStyle.setBorderRight(BorderStyle.THIN);
				cellStyle.setBorderTop(BorderStyle.THIN);
				cellStyle.setAlignment(HorizontalAlignment.CENTER);
				cell.setCellValue("/");
				cell.setCellStyle(cellStyle);
			} else {
				BigDecimal result=((BigDecimal) value);
				if(ObjectUtils.isEmpty(value)) {
					result=BigDecimal.ZERO;
				}
				createCell(workbook,row,column,result,"###,##0.0");
			}


		} else if (value instanceof String) {
			String result = (String)value;
			row.createCell(column).setCellValue(result);
		}
	}

	/**
	 * <p>
	 * 通用Excel导出方法,利用反射机制遍历对象的所有字段，将数据写入Excel文件中 <br>
	 * 此版本生成2007以上版本的文件 (文件后缀：xlsx)
	 * </p>
	 *
	 * @param title   表格标题名
	 * @param headers 表格头部标题集合
	 * @param dataset 需要显示的数据集合,集合中一定要放置符合JavaBean风格的类的对象。此方法支持的
	 *                JavaBean属性的数据类型有基本数据类型及String,Date
	 * @param out     与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern 如果有时间数据，设定输出格式。默认为"yyyy-MM-dd hh:mm:ss"
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void myExportExcel2008(String title, String[] headers, Collection<T> dataset, OutputStream out,
								String pattern ) {
		// 声明一个工作薄
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 生成一个表格
		XSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(20);
		// 生成一个样式
		XSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(new XSSFColor(java.awt.Color.gray));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setAlignment(HorizontalAlignment.CENTER);
		// 生成一个字体
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontName("宋体");
		font.setColor(new XSSFColor(java.awt.Color.BLACK));
		font.setFontHeightInPoints((short) 11);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		XSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE));
		style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style2.setBorderBottom(BorderStyle.THIN);
		style2.setBorderLeft(BorderStyle.THIN);
		style2.setBorderRight(BorderStyle.THIN);
		style2.setBorderTop(BorderStyle.THIN);
		style2.setAlignment(HorizontalAlignment.CENTER);
		style2.setVerticalAlignment(VerticalAlignment.CENTER);
		// 生成另一个字体
		XSSFFont font2 = workbook.createFont();
		//font2.setBold(true);
		// 把字体应用到当前的样式
		style2.setFont(font2);

		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		XSSFCell cellHeader;
		for (int i = 0; i < headers.length; i++) {
			cellHeader = row.createCell(i);
			cellHeader.setCellStyle(style);
			cellHeader.setCellValue(new XSSFRichTextString(headers[i]));
		}

		// 遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();
		int index = 0;
		T t;
		Field[] fields;
		Field field;
		XSSFRichTextString richString;
		Pattern p = Pattern.compile("^//d+(//.//d+)?$");
		Matcher matcher;
		String fieldName;
		String getMethodName;
		XSSFCell cell;
		Class tCls;
		Method getMethod;
		Object value;
		String textValue;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			t = (T) it.next();
			// 利用反射，根据JavaBean属性的先后顺序，动态调用getXxx()方法得到属性值
			fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(style2);
				field = fields[i];
				fieldName = field.getName();
				getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				try {
					tCls = t.getClass();
					getMethod = tCls.getMethod(getMethodName, new Class[] {});
					value = getMethod.invoke(t, new Object[] {});
					// 判断值的类型后进行强制类型转换
					textValue = null;
					if (value instanceof Integer) {
						cell.setCellValue((Integer) value);
					} else if (value instanceof Float) {
						textValue = String.valueOf((Float) value);
						cell.setCellValue(textValue);
					} else if (value instanceof Double) {
						textValue = String.valueOf((Double) value);
						cell.setCellValue(textValue);
					} else if (value instanceof Long) {
						cell.setCellValue((Long) value);
					}
					if (value instanceof Boolean) {
						textValue = "是";
						if (!(Boolean) value) {
							textValue = "否";
						}
					} else if (value instanceof Date) {
						textValue = sdf.format((Date) value);
					} else if (value instanceof BigDecimal){
						Double result = ((BigDecimal) value).doubleValue();
						if (ObjectUtils.isEmpty(value)) {
							value = BigDecimal.ZERO;
						}
						//createCell(workbook, row, i, result, "###,##0.00");
						cell.setCellValue(result);
					}
					else {
						// 其它数据类型都当作字符串简单处理
						if (value != null) {
							textValue = value.toString();
						}
					}
					if (textValue != null) {
						matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							richString = new XSSFRichTextString(textValue);
							cell.setCellValue(richString);
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} finally {
					// 清理资源
				}
			}
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				workbook.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void exportExcel2020(String title, String[] headers, Collection<T> dataset, OutputStream out,
								String pattern,XSSFWorkbook workbook ) {
		// 声明一个工作薄
		//XSSFWorkbook workbook = new XSSFWorkbook();
		// 生成一个表格
		XSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(20);
		// 生成一个样式
		XSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(new XSSFColor(java.awt.Color.gray));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setAlignment(HorizontalAlignment.CENTER);
		// 生成一个字体
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontName("宋体");
		font.setColor(new XSSFColor(java.awt.Color.BLACK));
		font.setFontHeightInPoints((short) 11);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		XSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE));
		style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style2.setBorderBottom(BorderStyle.THIN);
		style2.setBorderLeft(BorderStyle.THIN);
		style2.setBorderRight(BorderStyle.THIN);
		style2.setBorderTop(BorderStyle.THIN);
		style2.setAlignment(HorizontalAlignment.CENTER);
		style2.setVerticalAlignment(VerticalAlignment.CENTER);
		// 生成另一个字体
		XSSFFont font2 = workbook.createFont();
		//font2.setBold(true);
		// 把字体应用到当前的样式
		style2.setFont(font2);
		// 报价样式
		XSSFCellStyle style3 = workbook.createCellStyle();
		style3.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE));
		style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style3.setBorderBottom(BorderStyle.THIN);
		style3.setBorderLeft(BorderStyle.THIN);
		style3.setBorderRight(BorderStyle.THIN);
		style3.setBorderTop(BorderStyle.THIN);
		style3.setAlignment(HorizontalAlignment.CENTER);
		style3.setVerticalAlignment(VerticalAlignment.CENTER);
		XSSFFont font3 = workbook.createFont();
		font3.setBold(true);
		font3.setFontName("宋体");
		font3.setColor(new XSSFColor(java.awt.Color.RED));
		font3.setFontHeightInPoints((short) 11);
		style3.setFont(font3);
		// 测算样式
		XSSFCellStyle style4 = workbook.createCellStyle();
		style4.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE));
		style4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style4.setBorderBottom(BorderStyle.THIN);
		style4.setBorderLeft(BorderStyle.THIN);
		style4.setBorderRight(BorderStyle.THIN);
		style4.setBorderTop(BorderStyle.THIN);
		style4.setAlignment(HorizontalAlignment.CENTER);
		style4.setVerticalAlignment(VerticalAlignment.CENTER);
		XSSFFont font4 = workbook.createFont();
		font4.setBold(true);
		font4.setFontName("宋体");
		font4.setColor(new XSSFColor(java.awt.Color.BLUE));
		font4.setFontHeightInPoints((short) 11);
		style4.setFont(font4);

		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		XSSFCell cellHeader;
		for (int i = 0; i < headers.length; i++) {
			cellHeader = row.createCell(i);
			cellHeader.setCellStyle(style);
			cellHeader.setCellValue(new XSSFRichTextString(headers[i]));
		}

		// 遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();
		int index = 0;
		T t;
		Field[] fields;
		Field field;
		XSSFRichTextString richString;
		Pattern p = Pattern.compile("^//d+(//.//d+)?$");
		Matcher matcher;
		String fieldName;
		String getMethodName;
		XSSFCell cell;
		Class tCls;
		Method getMethod;
		Object value;
		String textValue;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			t = (T) it.next();
			// 利用反射，根据JavaBean属性的先后顺序，动态调用getXxx()方法得到属性值
			fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				cell = row.createCell(i);
				if(i>=16 && i<=37) {
					cell.setCellStyle(style3);
				}else if(i>37 && i<fields.length-1) {
					cell.setCellStyle(style4);
				}else {
					cell.setCellStyle(style2);
				}
				field = fields[i];
				fieldName = field.getName();
				getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				try {
					tCls = t.getClass();
					getMethod = tCls.getMethod(getMethodName, new Class[] {});
					value = getMethod.invoke(t, new Object[] {});
					// 判断值的类型后进行强制类型转换
					textValue = null;
					if (value instanceof Integer) {
						cell.setCellValue((Integer) value);
					} else if (value instanceof Float) {
						textValue = String.valueOf((Float) value);
						cell.setCellValue(textValue);
					} else if (value instanceof Double) {
						textValue = String.valueOf((Double) value);
						cell.setCellValue(textValue);
					} else if (value instanceof Long) {
						cell.setCellValue((Long) value);
					}
					if (value instanceof Boolean) {
						textValue = "是";
						if (!(Boolean) value) {
							textValue = "否";
						}
					} else if (value instanceof Date) {
						textValue = sdf.format((Date) value);
					} else if (value instanceof BigDecimal){
						Double result = ((BigDecimal) value).doubleValue();
						if (ObjectUtils.isEmpty(value)) {
							value = BigDecimal.ZERO;
						}
						//createCell(workbook, row, i, result, "###,##0.00");
						cell.setCellValue(result);
					}
					else {
						// 其它数据类型都当作字符串简单处理
						if (value != null) {
							textValue = value.toString();
						}
					}
					if (textValue != null) {
						matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							richString = new XSSFRichTextString(textValue);
							cell.setCellValue(richString);
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} finally {
					// 清理资源
				}
			}
		}
	}


	/**
	 * <p>
	 * 通用Excel导出方法,利用反射机制遍历对象的所有字段，将数据写入Excel文件中 <br>
	 * 此版本生成2007以上版本的文件 (文件后缀：xlsx)
	 * </p>
	 *
	 * @param title   表格标题名
	 * @param headers 表格头部标题集合
	 * @param dsList 需要显示的数据集合,集合中一定要放置符合JavaBean风格的类的对象。此方法支持的
	 *                JavaBean属性的数据类型有基本数据类型及String,Date
	 * @param out     与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern 如果有时间数据，设定输出格式。默认为"yyyy-MM-dd hh:mm:ss"
	 */
	void erpBuildTitle(XSSFWorkbook workbook,XSSFRow row, String[] headers){
		// 生成一个样式
		XSSFCellStyle titleStyle = workbook.createCellStyle();
		// 设置这些样式
		titleStyle.setFillForegroundColor(new XSSFColor(java.awt.Color.LIGHT_GRAY));
		titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		titleStyle.setBorderBottom(BorderStyle.THIN);
		titleStyle.setBorderLeft(BorderStyle.THIN);
		titleStyle.setBorderRight(BorderStyle.THIN);
		titleStyle.setBorderTop(BorderStyle.THIN);
		titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		titleStyle.setAlignment(HorizontalAlignment.CENTER);
		titleStyle.setWrapText(true);
		// 生成一个字体
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontName("宋体");
		font.setColor(new XSSFColor(java.awt.Color.BLACK));
		font.setFontHeightInPoints((short) 11);
		// 把字体应用到当前的样式
		titleStyle.setFont(font);

		for (int i = 0; i < headers.length; i++) {
			XSSFCell cellHeader = row.createCell(i);
			cellHeader.setCellStyle(titleStyle);
			cellHeader.setCellValue(new XSSFRichTextString(headers[i]));
		}

	}

	XSSFCellStyle erpBuildRowStyle( XSSFWorkbook workbook ) {


		return  erpBuildRowStyle(workbook,HorizontalAlignment.LEFT);
	}
	XSSFCellStyle erpBuildRowStyleNum( XSSFWorkbook workbook ) {


		return  erpBuildRowStyle(workbook,HorizontalAlignment.CENTER);
	}
	String[] noHeader = {"no record!"};

	XSSFCellStyle erpBuildRowStyle ( XSSFWorkbook workbook, HorizontalAlignment ha ) {
		// 生成并设置另一个样式
		XSSFCellStyle rowStyle = workbook.createCellStyle();
		rowStyle.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE));
		rowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		rowStyle.setBorderBottom(BorderStyle.THIN);
		rowStyle.setBorderLeft(BorderStyle.THIN);
		rowStyle.setBorderRight(BorderStyle.THIN);
		rowStyle.setBorderTop(BorderStyle.THIN);
		rowStyle.setAlignment(ha);
		rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);

		// 生成另一个字体
		XSSFFont rowFnt = workbook.createFont();
		// 把字体应用到当前的样式
		rowStyle.setFont(rowFnt);

		return  rowStyle;
	}
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Pattern p = Pattern.compile("^//d+(//.//d+)?$");
	public void erpExportExcel(OutputStream out, String sheetTitle,  List<T> contentList)
			throws IOException, InvocationTargetException, IllegalAccessException {

		// 声明一个工作薄
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			String[] headers = contentList.size() > 0 ? contentList.get(0).getHeaders() : noHeader;

			// 生成一个表格
			XSSFSheet sheet = workbook.createSheet(sheetTitle);
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth(16);

			// 产生表格标题行
			XSSFRow row = sheet.createRow(0);
			erpBuildTitle(workbook, row, headers);
			if(contentList.size()==0){
				workbook.write(out);
				return;
			}

			// 生成并设置另一个样式
			XSSFCellStyle rowStyle = erpBuildRowStyle(workbook);
			XSSFCellStyle rowStyleNum = erpBuildRowStyleNum(workbook);
			XSSFCellStyle[] rowStyles = {rowStyle, rowStyleNum};

			int index = 0;
			for (T content : contentList) {
				index++;
				row = sheet.createRow(index);

				Integer valueNum = 0;
				// 利用反射，根据JavaBean属性的先后顺序，动态调用getXxx()方法得到属性值
				Field[] fields = content.getClass().getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {

					Field field = fields[i];
					if (Modifier.isStatic(field.getModifiers())
							|| Modifier.isTransient(field.getModifiers())) {
						continue;
					}

					Method method;
					try {
						String fieldName = field.getName();
						String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
						method = content.getClass().getMethod(getMethodName, new Class[]{});
					} catch (java.lang.NoSuchMethodException e) {
						continue;
					}

					Object value = method.invoke(content, new Object[]{});
					valueNum = buildCell(row, rowStyles, valueNum, value);
				}
			}

			workbook.write(out);
		}
	}

	Integer buildCell(XSSFRow row, XSSFCellStyle[] rowStyles, Integer valueNum, Object value) {
		if (value == null) {
			value = "";

		}

		if (value instanceof Map) {
			for (Object obj : ((Map) value).values()) {
				valueNum = buildCell(row, rowStyles, valueNum, obj);
			}
		} else {

			XSSFCell cell = row.createCell(valueNum++);
			cell.setCellStyle(rowStyles[1]);
			// 判断值的类型后进行强制类型转换
			String textValue = null;
			if (value instanceof Integer ) {
				cell.setCellValue((Integer) value);
			} else if (value instanceof Float) {
				textValue = String.valueOf((Float) value);
				cell.setCellValue(textValue);
			} else if (value instanceof Double) {
				textValue = String.valueOf((Double) value);
				cell.setCellValue(textValue);
			} else if (value instanceof Long) {
				cell.setCellValue((Long) value);
			}
			if (value instanceof Boolean) {
				textValue = (Boolean) value ? "是" : "否";

			} else if (value instanceof Date) {
				textValue = sdf.format((Date) value);
			} else if (value instanceof BigDecimal) {
				Double result = ((BigDecimal) value).doubleValue();
				if (ObjectUtils.isEmpty(value)) {
					value = BigDecimal.ZERO;
				}
				//createCell(workbook, row, i, result, "###,##0.00");
				cell.setCellValue(result);
			} else {
				cell.setCellStyle(rowStyles[0]);
				// 其它数据类型都当作字符串简单处理
				if (value != null) {
					textValue = value.toString();
				}
			}

			if (textValue != null) {
				Matcher matcher = p.matcher(textValue);
				if (matcher.matches()) {
					// 是数字当作double处理
					cell.setCellValue(Double.parseDouble(textValue));
				} else {
					XSSFRichTextString richString = new XSSFRichTextString(textValue);
					cell.setCellValue(richString);
					cell.setCellStyle(rowStyles[0]);
				}
			}
		}
		return valueNum;
	}
}
