package com.li.gohome.baen;

/**
 * Copyright 2019 aTool.org
 */

/**
 * Auto-generated: 2019-09-12 14:44:4
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool9.com/json2javabean.php
 */
public class GridNav {

    private GridNavItem hotel;
    private GridNavItem flight;
    private GridNavItem travel;

    public void setHotel(GridNavItem hotel) {
        this.hotel = hotel;
    }

    public GridNavItem getHotel() {
        return hotel;
    }

    public void setFlight(GridNavItem flight) {
        this.flight = flight;
    }

    public GridNavItem getFlight() {
        return flight;
    }

    public void setTravel(GridNavItem travel) {
        this.travel = travel;
    }

    public GridNavItem getTravel() {
        return travel;
    }


    public class GridNavItem {
        private String startColor;
        private String endColor;
        private CommonModel mainItem;
        private CommonModel item1;
        private CommonModel item2;
        private CommonModel item3;
        private CommonModel item4;

        public String getStartColor() {
            return startColor;
        }

        public String getEndColor() {
            return endColor;
        }

        public CommonModel getMainItem() {
            return mainItem;
        }

        public CommonModel getItem1() {
            return item1;
        }

        public CommonModel getItem2() {
            return item2;
        }

        public CommonModel getItem3() {
            return item3;
        }

        public CommonModel getItem4() {
            return item4;
        }

        public void setStartColor(String startColor) {
            this.startColor = startColor;
        }

        public void setEndColor(String endColor) {
            this.endColor = endColor;
        }

        public void setMainItem(CommonModel mainItem) {
            this.mainItem = mainItem;
        }

        public void setItem1(CommonModel item1) {
            this.item1 = item1;
        }

        public void setItem2(CommonModel item2) {
            this.item2 = item2;
        }

        public void setItem3(CommonModel item3) {
            this.item3 = item3;
        }

        public void setItem4(CommonModel item4) {
            this.item4 = item4;
        }
    }

}
