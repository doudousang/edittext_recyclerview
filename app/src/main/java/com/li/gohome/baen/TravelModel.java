/**
 * Copyright 2019 bejson.com
 */
package com.li.gohome.baen;
import java.util.List;

/**
 * Auto-generated: 2019-11-01 14:20:25
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class TravelModel {

    private int totalCount;
    private List<ResultList> resultList;

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getTotalCount() {
        return totalCount;
    }

    public void setResultList(List<ResultList> resultList) {
        this.resultList = resultList;
    }
    public List<ResultList> getResultList() {
        return resultList;
    }


    public class CoverImage {

        private String dynamicUrl;
        private String originalUrl;
        public void setDynamicUrl(String dynamicUrl) {
            this.dynamicUrl = dynamicUrl;
        }
        public String getDynamicUrl() {
            return dynamicUrl;
        }

        public void setOriginalUrl(String originalUrl) {
            this.originalUrl = originalUrl;
        }
        public String getOriginalUrl() {
            return originalUrl;
        }

    }

    public class Author {

        private int authorId;
        private String nickName;
        private String clientAuth;
        private String jumpUrl;
        private CoverImage coverImage;
        private int identityType;
        private String tag;
        public void setAuthorId(int authorId) {
            this.authorId = authorId;
        }
        public int getAuthorId() {
            return authorId;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }
        public String getNickName() {
            return nickName;
        }

        public void setClientAuth(String clientAuth) {
            this.clientAuth = clientAuth;
        }
        public String getClientAuth() {
            return clientAuth;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }
        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setCoverImage(CoverImage coverImage) {
            this.coverImage = coverImage;
        }
        public CoverImage getCoverImage() {
            return coverImage;
        }

        public void setIdentityType(int identityType) {
            this.identityType = identityType;
        }
        public int getIdentityType() {
            return identityType;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
        public String getTag() {
            return tag;
        }

    }

    public class Images {

        private long imageId;
        private String dynamicUrl;
        private String originalUrl;
        private int width;
        private int height;
        private int mediaType;
        private double lat;
        private double lon;
        private boolean isWaterMarked;
        public void setImageId(long imageId) {
            this.imageId = imageId;
        }
        public long getImageId() {
            return imageId;
        }

        public void setDynamicUrl(String dynamicUrl) {
            this.dynamicUrl = dynamicUrl;
        }
        public String getDynamicUrl() {
            return dynamicUrl;
        }

        public void setOriginalUrl(String originalUrl) {
            this.originalUrl = originalUrl;
        }
        public String getOriginalUrl() {
            return originalUrl;
        }

        public void setWidth(int width) {
            this.width = width;
        }
        public int getWidth() {
            return width;
        }

        public void setHeight(int height) {
            this.height = height;
        }
        public int getHeight() {
            return height;
        }

        public void setMediaType(int mediaType) {
            this.mediaType = mediaType;
        }
        public int getMediaType() {
            return mediaType;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
        public double getLat() {
            return lat;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }
        public double getLon() {
            return lon;
        }

        public void setIsWaterMarked(boolean isWaterMarked) {
            this.isWaterMarked = isWaterMarked;
        }
        public boolean getIsWaterMarked() {
            return isWaterMarked;
        }

    }

    public class Urls {

        private String version;
        private String appUrl;
        private String h5Url;
        private String wxUrl;
        public void setVersion(String version) {
            this.version = version;
        }
        public String getVersion() {
            return version;
        }

        public void setAppUrl(String appUrl) {
            this.appUrl = appUrl;
        }
        public String getAppUrl() {
            return appUrl;
        }

        public void setH5Url(String h5Url) {
            this.h5Url = h5Url;
        }
        public String getH5Url() {
            return h5Url;
        }

        public void setWxUrl(String wxUrl) {
            this.wxUrl = wxUrl;
        }
        public String getWxUrl() {
            return wxUrl;
        }

    }

    public class Tags {

        private long tagId;
        private String tagName;
        private int tagLevel;
        private long parentTagId;
        private int source;
        private int sortIndex;
        public void setTagId(long tagId) {
            this.tagId = tagId;
        }
        public long getTagId() {
            return tagId;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }
        public String getTagName() {
            return tagName;
        }

        public void setTagLevel(int tagLevel) {
            this.tagLevel = tagLevel;
        }
        public int getTagLevel() {
            return tagLevel;
        }

        public void setParentTagId(long parentTagId) {
            this.parentTagId = parentTagId;
        }
        public long getParentTagId() {
            return parentTagId;
        }

        public void setSource(int source) {
            this.source = source;
        }
        public int getSource() {
            return source;
        }

        public void setSortIndex(int sortIndex) {
            this.sortIndex = sortIndex;
        }
        public int getSortIndex() {
            return sortIndex;
        }

    }

    public class Topics {

        private int topicId;
        private String topicName;
        private int level;
        public void setTopicId(int topicId) {
            this.topicId = topicId;
        }
        public int getTopicId() {
            return topicId;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }
        public String getTopicName() {
            return topicName;
        }

        public void setLevel(int level) {
            this.level = level;
        }
        public int getLevel() {
            return level;
        }

    }

    public class PoiExt {

        private String h5Url;
        private String appUrl;
        public void setH5Url(String h5Url) {
            this.h5Url = h5Url;
        }
        public String getH5Url() {
            return h5Url;
        }

        public void setAppUrl(String appUrl) {
            this.appUrl = appUrl;
        }
        public String getAppUrl() {
            return appUrl;
        }

    }

    public class Pois {

        private int poiType;
        private long poiId;
        private String poiName;
        private long businessId;
        private int districtId;
        private PoiExt poiExt;
        private int source;
        private int isMain;
        private boolean isInChina;
        private String countryName;
        public void setPoiType(int poiType) {
            this.poiType = poiType;
        }
        public int getPoiType() {
            return poiType;
        }

        public void setPoiId(long poiId) {
            this.poiId = poiId;
        }
        public long getPoiId() {
            return poiId;
        }

        public void setPoiName(String poiName) {
            this.poiName = poiName;
        }
        public String getPoiName() {
            return poiName;
        }

        public void setBusinessId(long businessId) {
            this.businessId = businessId;
        }
        public long getBusinessId() {
            return businessId;
        }

        public void setDistrictId(int districtId) {
            this.districtId = districtId;
        }
        public int getDistrictId() {
            return districtId;
        }

        public void setPoiExt(PoiExt poiExt) {
            this.poiExt = poiExt;
        }
        public PoiExt getPoiExt() {
            return poiExt;
        }

        public void setSource(int source) {
            this.source = source;
        }
        public int getSource() {
            return source;
        }

        public void setIsMain(int isMain) {
            this.isMain = isMain;
        }
        public int getIsMain() {
            return isMain;
        }

        public void setIsInChina(boolean isInChina) {
            this.isInChina = isInChina;
        }
        public boolean getIsInChina() {
            return isInChina;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }
        public String getCountryName() {
            return countryName;
        }

    }

    public class ShareInfo {

        private String imageUrl;
        private String shareTitle;
        private String shareContent;
        private String platForm;
        private String token;
        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
        public String getImageUrl() {
            return imageUrl;
        }

        public void setShareTitle(String shareTitle) {
            this.shareTitle = shareTitle;
        }
        public String getShareTitle() {
            return shareTitle;
        }

        public void setShareContent(String shareContent) {
            this.shareContent = shareContent;
        }
        public String getShareContent() {
            return shareContent;
        }

        public void setPlatForm(String platForm) {
            this.platForm = platForm;
        }
        public String getPlatForm() {
            return platForm;
        }

        public void setToken(String token) {
            this.token = token;
        }
        public String getToken() {
            return token;
        }

    }

    public class Article {

        private long articleId;
        private int productType;
        private int sourceType;
        private String articleTitle;
        private Author author;
        private List<Images> images;
        private boolean hasVideo;
        private int readCount;
        private int likeCount;
        private int commentCount;
        private int shareCount;
        private List<Urls> urls;
        private List<Tags> tags;
        private List<Topics> topics;
        private List<Pois> pois;
        private String publishTime;
        private String publishTimeDisplay;
        private String shootTime;
        private String shootTimeDisplay;
        private int level;
        private String distanceText;
        private boolean isLike;
        private int imageCounts;
        private boolean isCollected;
        private int collectCount;
        private int articleStatus;
        private String poiName;
        private ShareInfo shareInfo;
        private String currentDate;
        public void setArticleId(long articleId) {
            this.articleId = articleId;
        }
        public long getArticleId() {
            return articleId;
        }

        public void setProductType(int productType) {
            this.productType = productType;
        }
        public int getProductType() {
            return productType;
        }

        public void setSourceType(int sourceType) {
            this.sourceType = sourceType;
        }
        public int getSourceType() {
            return sourceType;
        }

        public void setArticleTitle(String articleTitle) {
            this.articleTitle = articleTitle;
        }
        public String getArticleTitle() {
            return articleTitle;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }
        public Author getAuthor() {
            return author;
        }

        public void setImages(List<Images> images) {
            this.images = images;
        }
        public List<Images> getImages() {
            return images;
        }

        public void setHasVideo(boolean hasVideo) {
            this.hasVideo = hasVideo;
        }
        public boolean getHasVideo() {
            return hasVideo;
        }

        public void setReadCount(int readCount) {
            this.readCount = readCount;
        }
        public int getReadCount() {
            return readCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }
        public int getLikeCount() {
            return likeCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }
        public int getCommentCount() {
            return commentCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }
        public int getShareCount() {
            return shareCount;
        }

        public void setUrls(List<Urls> urls) {
            this.urls = urls;
        }
        public List<Urls> getUrls() {
            return urls;
        }

        public void setTags(List<Tags> tags) {
            this.tags = tags;
        }
        public List<Tags> getTags() {
            return tags;
        }

        public void setTopics(List<Topics> topics) {
            this.topics = topics;
        }
        public List<Topics> getTopics() {
            return topics;
        }

        public void setPois(List<Pois> pois) {
            this.pois = pois;
        }
        public List<Pois> getPois() {
            return pois;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }
        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTimeDisplay(String publishTimeDisplay) {
            this.publishTimeDisplay = publishTimeDisplay;
        }
        public String getPublishTimeDisplay() {
            return publishTimeDisplay;
        }

        public void setShootTime(String shootTime) {
            this.shootTime = shootTime;
        }
        public String getShootTime() {
            return shootTime;
        }

        public void setShootTimeDisplay(String shootTimeDisplay) {
            this.shootTimeDisplay = shootTimeDisplay;
        }
        public String getShootTimeDisplay() {
            return shootTimeDisplay;
        }

        public void setLevel(int level) {
            this.level = level;
        }
        public int getLevel() {
            return level;
        }

        public void setDistanceText(String distanceText) {
            this.distanceText = distanceText;
        }
        public String getDistanceText() {
            return distanceText;
        }

        public void setIsLike(boolean isLike) {
            this.isLike = isLike;
        }
        public boolean getIsLike() {
            return isLike;
        }

        public void setImageCounts(int imageCounts) {
            this.imageCounts = imageCounts;
        }
        public int getImageCounts() {
            return imageCounts;
        }

        public void setIsCollected(boolean isCollected) {
            this.isCollected = isCollected;
        }
        public boolean getIsCollected() {
            return isCollected;
        }

        public void setCollectCount(int collectCount) {
            this.collectCount = collectCount;
        }
        public int getCollectCount() {
            return collectCount;
        }

        public void setArticleStatus(int articleStatus) {
            this.articleStatus = articleStatus;
        }
        public int getArticleStatus() {
            return articleStatus;
        }

        public void setPoiName(String poiName) {
            this.poiName = poiName;
        }
        public String getPoiName() {
            return poiName;
        }

        public void setShareInfo(ShareInfo shareInfo) {
            this.shareInfo = shareInfo;
        }
        public ShareInfo getShareInfo() {
            return shareInfo;
        }

        public void setCurrentDate(String currentDate) {
            this.currentDate = currentDate;
        }
        public String getCurrentDate() {
            return currentDate;
        }

    }

    public class ResultList {

        private int type;
        private Article article;
        public void setType(int type) {
            this.type = type;
        }
        public int getType() {
            return type;
        }

        public void setArticle(Article article) {
            this.article = article;
        }
        public Article getArticle() {
            return article;
        }

    }

}