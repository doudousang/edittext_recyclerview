/**
 * Copyright 2019 bejson.com
 */
package com.li.gohome.baen;
import java.util.List;

/**
 * Auto-generated: 2019-11-27 11:22:51
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SearchModel {

    private Head head;
    private List<Data> data;
    public void setHead(Head head) {
        this.head = head;
    }
    public Head getHead() {
        return head;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
    public List<Data> getData() {
        return data;
    }

    public class Head {

        private String auth;
        private String errcode;
        public void setAuth(String auth) {
            this.auth = auth;
        }
        public String getAuth() {
            return auth;
        }

        public void setErrcode(String errcode) {
            this.errcode = errcode;
        }
        public String getErrcode() {
            return errcode;
        }

    }

    public class Data {

        private String code;
        private String word;
        private String type;
        private String price;
        private String zonename;
        private String star;
        private String districtname;
        private String url;
        public void setCode(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }

        public void setWord(String word) {
            this.word = word;
        }
        public String getWord() {
            return word;
        }

        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

        public void setPrice(String price) {
            this.price = price;
        }
        public String getPrice() {
            return price;
        }

        public void setZonename(String zonename) {
            this.zonename = zonename;
        }
        public String getZonename() {
            return zonename;
        }

        public void setStar(String star) {
            this.star = star;
        }
        public String getStar() {
            return star;
        }

        public void setDistrictname(String districtname) {
            this.districtname = districtname;
        }
        public String getDistrictname() {
            return districtname;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        public String getUrl() {
            return url;
        }

    }

}