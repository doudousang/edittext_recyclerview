/**
 * Copyright 2019 bejson.com
 */
package com.li.gohome.baen;
import java.util.List;

/**
 * Auto-generated: 2019-11-01 15:28:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class TravelTabModel {

    private String url;
    private Params params;
    private List<Tabs> tabs;
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setParams(Params params) {
        this.params = params;
    }
    public Params getParams() {
        return params;
    }

    public void setTabs(List<Tabs> tabs) {
        this.tabs = tabs;
    }
    public List<Tabs> getTabs() {
        return tabs;
    }

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

    }

    public class Extension {

        private String name;
        private String value;
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

    }

    public class Head {

        private String cid;
        private String ctok;
        private String cver;
        private String lang;
        private String sid;
        private String syscode;
        private String auth;
        private List<Extension> extension;
        public void setCid(String cid) {
            this.cid = cid;
        }
        public String getCid() {
            return cid;
        }

        public void setCtok(String ctok) {
            this.ctok = ctok;
        }
        public String getCtok() {
            return ctok;
        }

        public void setCver(String cver) {
            this.cver = cver;
        }
        public String getCver() {
            return cver;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }
        public String getLang() {
            return lang;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }
        public String getSid() {
            return sid;
        }

        public void setSyscode(String syscode) {
            this.syscode = syscode;
        }
        public String getSyscode() {
            return syscode;
        }

        public void setAuth(String auth) {
            this.auth = auth;
        }
        public String getAuth() {
            return auth;
        }

        public void setExtension(List<Extension> extension) {
            this.extension = extension;
        }
        public List<Extension> getExtension() {
            return extension;
        }

    }

    public class Params {

        private int districtId;
        private String groupChannelCode;
        private String type;
        private int lat;
        private int lon;
        private int locatedDistrictId;
        private PagePara pagePara;
        private int imageCutType;
        private Head head;
        private String contentType;
        public void setDistrictId(int districtId) {
            this.districtId = districtId;
        }
        public int getDistrictId() {
            return districtId;
        }

        public void setGroupChannelCode(String groupChannelCode) {
            this.groupChannelCode = groupChannelCode;
        }
        public String getGroupChannelCode() {
            return groupChannelCode;
        }

        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

        public void setLat(int lat) {
            this.lat = lat;
        }
        public int getLat() {
            return lat;
        }

        public void setLon(int lon) {
            this.lon = lon;
        }
        public int getLon() {
            return lon;
        }

        public void setLocatedDistrictId(int locatedDistrictId) {
            this.locatedDistrictId = locatedDistrictId;
        }
        public int getLocatedDistrictId() {
            return locatedDistrictId;
        }

        public void setPagePara(PagePara pagePara) {
            this.pagePara = pagePara;
        }
        public PagePara getPagePara() {
            return pagePara;
        }

        public void setImageCutType(int imageCutType) {
            this.imageCutType = imageCutType;
        }
        public int getImageCutType() {
            return imageCutType;
        }

        public void setHead(Head head) {
            this.head = head;
        }
        public Head getHead() {
            return head;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }
        public String getContentType() {
            return contentType;
        }

    }

    public class Tabs {

        private String labelName;
        private String groupChannelCode;
        public void setLabelName(String labelName) {
            this.labelName = labelName;
        }
        public String getLabelName() {
            return labelName;
        }

        public void setGroupChannelCode(String groupChannelCode) {
            this.groupChannelCode = groupChannelCode;
        }
        public String getGroupChannelCode() {
            return groupChannelCode;
        }

    }

}