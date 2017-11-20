package com.lanou3g.page.domain;

import java.util.List;

/**
 * Created by dllo on 17/11/17.
 */
public class PageBean<T> {

    private int pageNum;  //第几页
    private int pageSize;  //每页显示的条目数
    private int totalRecord; // 总的记录数


    //计算项
    private int startIndex; //开始索引
    private int totalPage;  //总分页数

    //数据
    private List<T> data;  //分页数据


    //动态显示条  开始  结束
    private int start;
    private int end;

    public PageBean(int pageNum, int pageSize, int totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;


        this.startIndex = (this.pageNum - 1) * this.pageSize;

        if (totalRecord % pageSize == 0) {
            totalPage = totalRecord / pageSize;
        } else {
            totalPage = totalRecord / pageSize + 1;
        }

        //设置动态显示条的默认值
        this.start = 1;
        this.end = 10;

        //初始数据
        if (this.totalPage <= 10) {
            this.end = this.totalPage;
        } else {
            this.start = this.pageNum - 4;
            this.end = this.pageNum + 5;

            if (this.start < 1) {
                this.start = 1;
                this.end = 10;
            }
            if (this.end > this.totalPage) {
                this.end = this.totalPage;
                this.start = this.totalPage - 9;
            }
        }
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

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", startIndex=" + startIndex +
                ", totalPage=" + totalPage +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}





