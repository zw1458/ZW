package com.lanou3g.page.domain;

import java.util.List;

/**
 * Created by dllo on 17/11/17.
 */
public class Page<T> {

    //文档说是必选项
    private int pageNum;   //第几页
    private int pageSize;  //每页显示的条数
    private int totalRecord;//总的记录数

    //计算项
    private int startIndex;  //开始索引
    private int totalPage; //总分页数

    private int start, end;
    //数据
    private List<T> data;




    public Page(int pageNum, int pageSize, int totalRecord, int totalPage) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.start = 1;
        this.end = 10;
        this.totalPage = totalPage;

        if (this.totalPage <= 10) {
            this.end = this.totalPage;
        } else {
            // totalPage = 23
            //3.3 当前页 前4后5
            this.start = this.pageNum - 4;
            this.end = this.pageNum + 5;
            // pageNum = 1
            if (this.start < 1) {
                this.start = 1;
                this.end = 10;
            }
            // pageNum = 23
            if (this.end > this.totalPage) {
                this.end = this.totalPage;
                this.start = this.totalPage - 9;
            }
        }
    }

    public Page(int pageNum, int pageSize, int totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

}




