package com.limbo.sdk_demo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 选择处理企业  实体类
 * <p>
 * Created by Administrator on 2017/9/12.
 */

public class CompanyBean implements Serializable {

    private int total;
    private Message message;//消息对象
    private List<Rows> rows;//用户信息对象

    public int getTotal() {
        return total;
    }

    public Message getMessage() {
        return message;
    }

    public List<Rows> getRows() {
        return rows;
    }

    public class Message implements Serializable {
        private int code;
        private String message;
        private String stack;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStack() {
            return stack;
        }

        public void setStack(String stack) {
            this.stack = stack;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "code=" + code +
                    ", message='" + message + '\'' +
                    ", stack='" + stack + '\'' +
                    '}';
        }
    }

    public static class Rows implements Serializable {
        private String bindFlag;//是否绑定（1是 2否）
        private String companyCode;
        private String serverName;//企业名称

        public void setBindFlag(String bindFlag) {
            this.bindFlag = bindFlag;
        }

        public void setCompanyCode(String companyCode) {
            this.companyCode = companyCode;
        }

        public void setServerName(String serverName) {
            this.serverName = serverName;
        }

        public void setWorkOrderNumber(int workOrderNumber) {
            this.workOrderNumber = workOrderNumber;
        }

        private int workOrderNumber;//工单数

        public String getBindFlag() {
            return bindFlag;
        }

        public String getCompanyCode() {
            return companyCode;
        }

        public String getServerName() {
            return serverName;
        }

        public int getWorkOrderNumber() {
            return workOrderNumber;
        }
    }

}
