package com.kunlong.dongxw.data.domain;


import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.DateRange;
import org.mybatis.hbatis.orm.criteria.support.query.SortOrders;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * OrderMaster 客户订单
 * @author generator
 * @date 2020年01月03日
 */
public class OrderMasterBase implements Serializable {

	private static final long serialVersionUID = 1L;

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	BigDecimal totalMoney = BigDecimal.ZERO;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// ==== 自定义属性 ====
	Customer customer;

	public OrderMaster getOrderMasterParent() {
		return orderMasterParent;
	}

	public void setOrderMasterParent(OrderMaster orderMasterParent) {
		this.orderMasterParent = orderMasterParent;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	OrderMaster orderMasterParent;

	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}

	String createByName;
	public static class QueryParam extends AbstractQueryParam<OrderMaster> {
		public QueryParam() {
			this.setSortOrders(new SortOrders<OrderMaster>(OrderMaster.EntityNode.INSTANCE));
		}


		private Map<String, DateRange> dateRanges = new HashMap<String, DateRange>();

		public Map<String, DateRange> getDateRanges() {
			return dateRanges;
		}

		public void setDateRanges(Map<String, DateRange> dateRanges) {
			this.dateRanges = dateRanges;
		}
	}

//
//	<if test="queryParam.dateRanges!=null">
//			<bind name="dr" value="queryParam.dateRanges"/>
//			<bind name="orderDate" value="dr['orderDate']"/>
//			<bind name="customerIssueDate" value="dr['customerIssueDate']"/>
//			<bind name="checkDate" value="dr['checkDate']"/>
//			<bind name="factroyIssueDate" value="dr['factroyIssueDate']"/>
//			<if test="orderDate!=null"> <!-- 按创建时间 -->
//				<if test="orderDate.startDate!=null">
//	and om.order_date <![CDATA[>=]]> #{orderDate.startDate}
//				</if>
//				<if test="dr['orderDate'].endDate!=null">
//	and om.order_date <![CDATA[<=]]> #{orderDate.endDate}
//				</if>
//			</if>
//
//			<if test="customerIssueDate!=null"> <!-- 按创建时间 -->
//				<if test="customerIssueDate.startDate!=null">
//	and om.customer_issue_date <![CDATA[>=]]> #{customerIssueDate.startDate}
//				</if>
//				<if test="dr['customerIssueDate'].endDate!=null">
//	and om.customer_issue_date <![CDATA[<=]]> #{customerIssueDate.endDate}
//				</if>
//			</if>
//			<if test="checkDate!=null"> <!-- 按创建时间 -->
//				<if test="checkDate.startDate!=null">
//	and om.check_date <![CDATA[>=]]> #{checkDate.startDate}
//				</if>
//				<if test="dr['checkDate'].endDate!=null">
//	and om.check_date <![CDATA[<=]]> #{checkDate.endDate}
//				</if>
//			</if>
//			<if test="factroyIssueDate!=null"> <!-- 按创建时间 -->
//				<if test="factroyIssueDate.startDate!=null">
//	and om.factroy_issue_date <![CDATA[>=]]> #{factroyIssueDate.startDate}
//				</if>
//				<if test="dr['factroyIssueDate'].endDate!=null">
//	and om.factroy_issue_date <![CDATA[<=]]> #{factroyIssueDate.endDate}
//				</if>
//			</if>
//
//
//		</if>
}