package com.gwg.shiro.web.common;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long recordCount = 0L;

    private List<T> items;

    public PageResult(Long recordCount) {
        this.recordCount = recordCount;
    }

    public PageResult(Long recordCount, List<T> items) {
        this.recordCount = recordCount;
        this.items = items;
    }



    public PageResult() {
        super();
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    public List<T> getItems() {
        return items == null? new ArrayList<T>(): items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

}
