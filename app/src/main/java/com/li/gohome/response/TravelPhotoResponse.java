/**
 * Copyright 2019 bejson.com
 */
package com.li.gohome.response;

/**
 * Auto-generated: 2019-11-06 17:40:29
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class TravelPhotoResponse {

    private int districtId;
    private String groupChannelCode;
    private String type;
    private int lat;
    private int lon;
    private int locatedDistrictId;
    private PagePara pagePara;
    private int imageCutType;
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

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public TravelPhotoResponse(int districtId, String groupChannelCode, String type,
                               int lat, int lon, int locatedDistrictId, PagePara pagePara,
                               int imageCutType, String contentType) {
        this.districtId = districtId;
        this.groupChannelCode = groupChannelCode;
        this.type = type;
        this.lat = lat;
        this.lon = lon;
        this.locatedDistrictId = locatedDistrictId;
        this.pagePara = pagePara;
        this.imageCutType = imageCutType;
        this.contentType = contentType;

    }

}