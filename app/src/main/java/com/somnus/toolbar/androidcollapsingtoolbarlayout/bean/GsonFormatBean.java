package com.somnus.toolbar.androidcollapsingtoolbarlayout.bean;

import java.util.List;

/**
 * @date： 2016/4/15.
 * @FileName: com.somnus.toolbar.androidcollapsingtoolbarlayout.bean.GsonFormatBean.java
 * @author: Somnus
 * @Description: https://github.com/zzz40500/GsonFormat
 *    快捷键：alt+insert ：  调出generate界面 ，
 *            alt+s     :GsonFormat 界面
 *
 */
public class GsonFormatBean {


    /**
     * success : true
     * msg : 操作成功
     * errorCode : null
     * level : info
     * obj : null
     * result : []
     * attributes : {"isShop":"Y","customersResult":{"code":"207","remarks":null,"createBy":null,"createByName":null,"createDate":"2015-12-24 02:08:54","updateBy":"admin","updateByName":null,"updateDate":"2015-12-24 02:09:42","delFlag":"0","id":"3e7f6b9c-e913-4efa-9588-a22b962761ba","appellation":"张无忌1","sex":"1","birthday":662659200000,"name":null,"interest":null,"pictureUrl":"upload/images/mobile/5d73f36a-4136-4ef8-8a3d-25d26f1b7f55.jpg","tempPictureUrl":null,"grade":"0","status":null,"refereeId":null,"user":null,"comId":null,"hoplink":null,"hoplinkQrCode":"upload/images/hoplink_qr_code/20150824100857HAGZ55SF.png","userType":"8","qq":null,"teacher":null,"version":"Official","lastPayDate":1460454468000,"userTypeStr":"总代","state":"closed","deleted":false,"createDateFormat":"2015-12-24 10:08:54"},"mobile":"14012345601"}
     */

    private boolean success;
    private String msg;
    private Object errorCode;
    private String level;
    private Object obj;
    /**
     * isShop : Y
     * customersResult : {"code":"207","remarks":null,"createBy":null,"createByName":null,"createDate":"2015-12-24 02:08:54","updateBy":"admin","updateByName":null,"updateDate":"2015-12-24 02:09:42","delFlag":"0","id":"3e7f6b9c-e913-4efa-9588-a22b962761ba","appellation":"张无忌1","sex":"1","birthday":662659200000,"name":null,"interest":null,"pictureUrl":"upload/images/mobile/5d73f36a-4136-4ef8-8a3d-25d26f1b7f55.jpg","tempPictureUrl":null,"grade":"0","status":null,"refereeId":null,"user":null,"comId":null,"hoplink":null,"hoplinkQrCode":"upload/images/hoplink_qr_code/20150824100857HAGZ55SF.png","userType":"8","qq":null,"teacher":null,"version":"Official","lastPayDate":1460454468000,"userTypeStr":"总代","state":"closed","deleted":false,"createDateFormat":"2015-12-24 10:08:54"}
     * mobile : 14012345601
     */

    private AttributesBean attributes;
    private List<?> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public AttributesBean getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributesBean attributes) {
        this.attributes = attributes;
    }

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }

    public static class AttributesBean {
        private String isShop;
        /**
         * code : 207
         * remarks : null
         * createBy : null
         * createByName : null
         * createDate : 2015-12-24 02:08:54
         * updateBy : admin
         * updateByName : null
         * updateDate : 2015-12-24 02:09:42
         * delFlag : 0
         * id : 3e7f6b9c-e913-4efa-9588-a22b962761ba
         * appellation : 张无忌1
         * sex : 1
         * birthday : 662659200000
         * name : null
         * interest : null
         * pictureUrl : upload/images/mobile/5d73f36a-4136-4ef8-8a3d-25d26f1b7f55.jpg
         * tempPictureUrl : null
         * grade : 0
         * status : null
         * refereeId : null
         * user : null
         * comId : null
         * hoplink : null
         * hoplinkQrCode : upload/images/hoplink_qr_code/20150824100857HAGZ55SF.png
         * userType : 8
         * qq : null
         * teacher : null
         * version : Official
         * lastPayDate : 1460454468000
         * userTypeStr : 总代
         * state : closed
         * deleted : false
         * createDateFormat : 2015-12-24 10:08:54
         */

        private CustomersResultBean customersResult;
        private String mobile;

        public String getIsShop() {
            return isShop;
        }

        public void setIsShop(String isShop) {
            this.isShop = isShop;
        }

        public CustomersResultBean getCustomersResult() {
            return customersResult;
        }

        public void setCustomersResult(CustomersResultBean customersResult) {
            this.customersResult = customersResult;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public static class CustomersResultBean {
            private String code;
            private Object remarks;
            private Object createBy;
            private Object createByName;
            private String createDate;
            private String updateBy;
            private Object updateByName;
            private String updateDate;
            private String delFlag;
            private String id;
            private String appellation;
            private String sex;
            private long birthday;
            private Object name;
            private Object interest;
            private String pictureUrl;
            private Object tempPictureUrl;
            private String grade;
            private Object status;
            private Object refereeId;
            private Object user;
            private Object comId;
            private Object hoplink;
            private String hoplinkQrCode;
            private String userType;
            private Object qq;
            private Object teacher;
            private String version;
            private long lastPayDate;
            private String userTypeStr;
            private String state;
            private boolean deleted;
            private String createDateFormat;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public Object getRemarks() {
                return remarks;
            }

            public void setRemarks(Object remarks) {
                this.remarks = remarks;
            }

            public Object getCreateBy() {
                return createBy;
            }

            public void setCreateBy(Object createBy) {
                this.createBy = createBy;
            }

            public Object getCreateByName() {
                return createByName;
            }

            public void setCreateByName(Object createByName) {
                this.createByName = createByName;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(String updateBy) {
                this.updateBy = updateBy;
            }

            public Object getUpdateByName() {
                return updateByName;
            }

            public void setUpdateByName(Object updateByName) {
                this.updateByName = updateByName;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public String getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(String delFlag) {
                this.delFlag = delFlag;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAppellation() {
                return appellation;
            }

            public void setAppellation(String appellation) {
                this.appellation = appellation;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public Object getInterest() {
                return interest;
            }

            public void setInterest(Object interest) {
                this.interest = interest;
            }

            public String getPictureUrl() {
                return pictureUrl;
            }

            public void setPictureUrl(String pictureUrl) {
                this.pictureUrl = pictureUrl;
            }

            public Object getTempPictureUrl() {
                return tempPictureUrl;
            }

            public void setTempPictureUrl(Object tempPictureUrl) {
                this.tempPictureUrl = tempPictureUrl;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getRefereeId() {
                return refereeId;
            }

            public void setRefereeId(Object refereeId) {
                this.refereeId = refereeId;
            }

            public Object getUser() {
                return user;
            }

            public void setUser(Object user) {
                this.user = user;
            }

            public Object getComId() {
                return comId;
            }

            public void setComId(Object comId) {
                this.comId = comId;
            }

            public Object getHoplink() {
                return hoplink;
            }

            public void setHoplink(Object hoplink) {
                this.hoplink = hoplink;
            }

            public String getHoplinkQrCode() {
                return hoplinkQrCode;
            }

            public void setHoplinkQrCode(String hoplinkQrCode) {
                this.hoplinkQrCode = hoplinkQrCode;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public Object getQq() {
                return qq;
            }

            public void setQq(Object qq) {
                this.qq = qq;
            }

            public Object getTeacher() {
                return teacher;
            }

            public void setTeacher(Object teacher) {
                this.teacher = teacher;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public long getLastPayDate() {
                return lastPayDate;
            }

            public void setLastPayDate(long lastPayDate) {
                this.lastPayDate = lastPayDate;
            }

            public String getUserTypeStr() {
                return userTypeStr;
            }

            public void setUserTypeStr(String userTypeStr) {
                this.userTypeStr = userTypeStr;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }

            public String getCreateDateFormat() {
                return createDateFormat;
            }

            public void setCreateDateFormat(String createDateFormat) {
                this.createDateFormat = createDateFormat;
            }
        }
    }
}
