package com.limbo.sdk_demo.bean;

import java.util.List;

/**
 * Created by wangqi on 2017/11/27.
 */

public class SLABean {

    /**
     * message : {"code":200,"message":"操作成功！","stack":null}
     * rows : [{"arrivalDay":0,"arrivalHour":4,"completeDay":0,"completeHour":6,"contractCode":null,"contractId":null,"hardWareIds":null,"levelName":"T1","responseHour":0,"responseMinute":15,"serviceProviderCode":null,"tcId":null,"tempCategoryId":2,"tempId":"33"},{"arrivalDay":0,"arrivalHour":6,"completeDay":0,"completeHour":12,"contractCode":null,"contractId":null,"hardWareIds":null,"levelName":"T2","responseHour":0,"responseMinute":15,"serviceProviderCode":null,"tcId":null,"tempCategoryId":2,"tempId":"34"},{"arrivalDay":0,"arrivalHour":6,"completeDay":0,"completeHour":12,"contractCode":null,"contractId":null,"hardWareIds":null,"levelName":"T3","responseHour":0,"responseMinute":15,"serviceProviderCode":null,"tcId":null,"tempCategoryId":2,"tempId":"35"},{"arrivalDay":0,"arrivalHour":6,"completeDay":0,"completeHour":12,"contractCode":null,"contractId":null,"hardWareIds":null,"levelName":"T4","responseHour":0,"responseMinute":15,"serviceProviderCode":null,"tcId":null,"tempCategoryId":2,"tempId":"36"}]
     * total : 0
     */

    private MessageBean message;
    private int total;
    private List<RowsBean> rows;

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class MessageBean {
        /**
         * code : 200
         * message : 操作成功！
         * stack : null
         */

        private int code;
        private String message;
        private Object stack;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getStack() {
            return stack;
        }

        public void setStack(Object stack) {
            this.stack = stack;
        }
    }

    public static class RowsBean {
        /**
         * arrivalDay : 0
         * arrivalHour : 4
         * completeDay : 0
         * completeHour : 6
         * contractCode : null
         * contractId : null
         * hardWareIds : null
         * levelName : T1
         * responseHour : 0
         * responseMinute : 15
         * serviceProviderCode : null
         * tcId : null
         * tempCategoryId : 2
         * tempId : 33
         */

        private int arrivalDay;
        private int arrivalHour;
        private int completeDay;
        private int completeHour;
        private Object contractCode;
        private Object contractId;
        private Object hardWareIds;
        private String levelName;
        private int responseHour;
        private int responseMinute;
        private Object serviceProviderCode;
        private String tcId;
        private int tempCategoryId;
        private String tempId;

        public int getArrivalDay() {
            return arrivalDay;
        }

        public void setArrivalDay(int arrivalDay) {
            this.arrivalDay = arrivalDay;
        }

        public int getArrivalHour() {
            return arrivalHour;
        }

        public void setArrivalHour(int arrivalHour) {
            this.arrivalHour = arrivalHour;
        }

        public int getCompleteDay() {
            return completeDay;
        }

        public void setCompleteDay(int completeDay) {
            this.completeDay = completeDay;
        }

        public int getCompleteHour() {
            return completeHour;
        }

        public void setCompleteHour(int completeHour) {
            this.completeHour = completeHour;
        }

        public Object getContractCode() {
            return contractCode;
        }

        public void setContractCode(Object contractCode) {
            this.contractCode = contractCode;
        }

        public Object getContractId() {
            return contractId;
        }

        public void setContractId(Object contractId) {
            this.contractId = contractId;
        }

        public Object getHardWareIds() {
            return hardWareIds;
        }

        public void setHardWareIds(Object hardWareIds) {
            this.hardWareIds = hardWareIds;
        }

        public String getLevelName() {
            return levelName;
        }

        public void setLevelName(String levelName) {
            this.levelName = levelName;
        }

        public int getResponseHour() {
            return responseHour;
        }

        public void setResponseHour(int responseHour) {
            this.responseHour = responseHour;
        }

        public int getResponseMinute() {
            return responseMinute;
        }

        public void setResponseMinute(int responseMinute) {
            this.responseMinute = responseMinute;
        }

        public Object getServiceProviderCode() {
            return serviceProviderCode;
        }

        public void setServiceProviderCode(Object serviceProviderCode) {
            this.serviceProviderCode = serviceProviderCode;
        }

        public String getTcId() {
            return tcId;
        }

        public void setTcId(String tcId) {
            this.tcId = tcId;
        }

        public int getTempCategoryId() {
            return tempCategoryId;
        }

        public void setTempCategoryId(int tempCategoryId) {
            this.tempCategoryId = tempCategoryId;
        }

        public String getTempId() {
            return tempId;
        }

        public void setTempId(String tempId) {
            this.tempId = tempId;
        }
    }
}
