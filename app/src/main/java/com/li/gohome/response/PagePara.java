package com.li.gohome.response;

public class PagePara {

    private int pageIndex;
    private int pageSize;
    private int sortType;
    private int sortDirection;

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    public int getSortType() {
        return sortType;
    }

    public void setSortDirection(int sortDirection) {
        this.sortDirection = sortDirection;
    }

    public int getSortDirection() {
        return sortDirection;
    }

    public PagePara(int pageIndex, int pageSize, int sortType, int sortDirection) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.sortType = sortType;
        this.sortDirection = sortDirection;
    }

}
