package com.kunlong.dongxw.consts;
/**
 * 
 * @className: DongxwConsts
 * @description: 应用基本配置常量 
 * @author ljm
 * @date 2018年4月18日  
 *
 */
public class DongxwConsts {


	protected static String[] MYBATIS_MAPPER_LOCATIONS = new String[]
	{
			"classpath*:/mapper/*.xml",
			"classpath*:/mapper/dongxw/*.xml"
	};

	protected static String MYBATIS_BASE_PACKAGE = "com.kunlong.dongxw.data.dao,com.kunlong.data.dao";


}
