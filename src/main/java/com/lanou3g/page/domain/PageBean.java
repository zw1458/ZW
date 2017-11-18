package com.lanou3g.page.domain;

import java.util.List;

/**
 * Created by dllo on 17/11/17.
 */
public class PageBean {

    private boolean hasPrePage;

    /** 是否有下一页 */
    private boolean hasNextPage;

    /** 每页的数量 */
    private int everyPage;

    /** 总页数 */
    private int totalPage;

    /** 当前页*/
    private int currentPage;

    /** 起始点 */
    private int beginIndex;

    /** 总记录数*/
    private int totalCount;

    /**
     * @return totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount 要设置的 totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /** The default constructor */
    public PageBean(){

    }

    /** construct the page by everyPage
     * @param everyPage
     * */
    public PageBean(int everyPage){
        this.everyPage = everyPage;
    }

    /** The whole constructor */
    public PageBean(boolean hasPrePage, boolean hasNextPage,
                    int everyPage, int totalPage,
                    int currentPage, int beginIndex, int totalCount) {
        this.hasPrePage = hasPrePage;
        this.hasNextPage = hasNextPage;
        this.everyPage = everyPage;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.beginIndex = beginIndex;
        this.totalCount = totalCount;
    }

    /**
     * @return
     * Returns the beginIndex.
     */
    public int getBeginIndex() {
        return beginIndex;
    }

    /**
     * @param beginIndex
     * The beginIndex to set.
     */
    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    /**
     * @return
     * Returns the currentPage.
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage
     * The currentPage to set.
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return
     * Returns the everyPage.
     */
    public int getEveryPage() {
        return everyPage;
    }

    /**
     * @param everyPage
     * The everyPage to set.
     */
    public void setEveryPage(int everyPage) {
        this.everyPage = everyPage;
    }

    /**
     * @return
     * Returns the hasNextPage.
     */
    public boolean getHasNextPage() {
        return hasNextPage;
    }

    /**
     * @param hasNextPage
     * The hasNextPage to set.
     */
    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    /**
     * @return
     * Returns the hasPrePage.
     */
    public boolean getHasPrePage() {
        return hasPrePage;
    }

    /**
     * @param hasPrePage
     * The hasPrePage to set.
     */
    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    /**
     * @return Returns the totalPage.
     *
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * @param totalPage
     * The totalPage to set.
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}





