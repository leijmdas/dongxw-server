package com.kunlong.dongxw.data.domain;

import com.kunlong.dongxw.data.dto.DataRangeDTO;
import org.mybatis.hbatis.orm.criteria.support.query.AbstractQueryParam;
import org.mybatis.hbatis.orm.criteria.support.query.DateRange;

import java.util.HashMap;
import java.util.Map;

public class MakePlanBase extends OrderLineBase {
    OrderLine orderLine;
    DataRangeDTO dtoOrderDate;

    public DataRangeDTO getDtoOrderDate() {
        return dtoOrderDate;
    }

    public void setDtoOrderDate(DataRangeDTO dtoOrderDate) {
        this.dtoOrderDate = dtoOrderDate;
    }


    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }
    public static class QueryParamBase extends AbstractQueryParam<MakePlan> {

        private Map<String, DateRange> dateRanges = new HashMap<String, DateRange>();

        public Map<String, DateRange> getDateRanges() {
            return dateRanges;
        }

        public void setDateRanges(Map<String, DateRange> dateRanges) {
            this.dateRanges = dateRanges;
        }
    }

//<if test="queryParam.dateRanges!=null">
//			<bind name="dr" value="queryParam.dateRanges"/>
//			<bind name="orderDate" value="dr['orderDate']"/>
//			<if test="orderDate!=null"> <!-- 按创建时间 -->
//				<if test="orderDate.startDate!=null">
//    and mp.order_date <![CDATA[>=]]> #{orderDate.startDate}
//				</if>
//				<if test="orderDate.endDate!=null">
//    and mp.order_date <![CDATA[<=]]> #{orderDate.endDate}
//				</if>
//			</if>
//			<bind name="issueDate" value="dr['issueDate']"/>
//			<if test="issueDate!=null"> <!-- 按创建时间 -->
//				<if test="issueDate.startDate!=null">
//    and mp.issue_date <![CDATA[>=]]> #{issueDate.startDate}
//				</if>
//				<if test="issue_date.endDate!=null">
//    and mp.issue_date <![CDATA[<=]]> #{issueDate.endDate}
//				</if>
//			</if>
//			<bind name="rmDate" value="dr['rmDate']"/>
//			<if test="rmDate!=null"> <!-- 按创建时间 -->
//				<if test="rmDate.startDate!=null">
//    and mp.rm_date <![CDATA[>=]]> #{rmDate.startDate}
//				</if>
//				<if test="rmDate.endDate!=null">
//    and mp.rm_date <![CDATA[<=]]> #{rmDate.endDate}
//				</if>
//			</if>
//
//			<bind name="pkgDate" value="dr['pkgDate']"/>
//			<if test="pkgDate!=null"> <!-- 按创建时间 -->
//				<if test="pkgDate.startDate!=null">
//    and mp.pkg_date <![CDATA[>=]]> #{pkgDate.startDate}
//				</if>
//				<if test="pkgDate.endDate!=null">
//    and mp.pkg_date <![CDATA[<=]]> #{pkgDate.endDate}
//				</if>
//			</if>
//			<bind name="planStart" value="dr['planStart']"/>
//			<if test="planStart!=null"> <!-- 按创建时间 -->
//				<if test="planStart.startDate!=null">
//    and mp.plan_start <![CDATA[>=]]> #{planStart.startDate}
//				</if>
//				<if test="planStart.endDate!=null">
//    and mp.plan_start <![CDATA[<=]]> #{planStart.endDate}
//				</if>
//			</if>
//			<bind name="planEnd" value="dr['planEnd']"/>
//			<if test="planEnd!=null"> <!-- 按创建时间 -->
//				<if test="planEnd.startDate!=null">
//    and mp.plan_end <![CDATA[>=]]> #{planEnd.startDate}
//				</if>
//				<if test="planEnd.endDate!=null">
//    and mp.plan_end <![CDATA[<=]]> #{planEnd.endDate}
//				</if>
//			</if>
//
//			<bind name="realEnd" value="dr['realEnd']"/>
//			<if test="realEnd!=null"> <!-- 按创建时间 -->
//				<if test="realEnd.startDate!=null">
//    and mp.real_end <![CDATA[>=]]> #{realEnd.startDate}
//				</if>
//				<if test="realEnd.endDate!=null">
//    and mp.real_end <![CDATA[<=]]> #{realEnd.endDate}
//				</if>
//			</if>
//
//		</if>
}