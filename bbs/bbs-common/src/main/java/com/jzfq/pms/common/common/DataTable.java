
package com.jzfq.pms.common.common;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * DataTables期望的数据格式
 *
 * @author
 */
public class DataTable<T> {
    private static final long serialVersionUID = 1L;

    private Long iTotalRecords;

    private Long iTotalDisplayRecords;

    private List<T> aaData = Lists.newArrayList();

    public Long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(Long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public Long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public List<?> getAaData() {
        return aaData;
    }

    public void setAaData(List<T> aaData) {
        this.aaData = aaData;
    }
}
