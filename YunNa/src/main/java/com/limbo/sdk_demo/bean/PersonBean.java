package com.limbo.sdk_demo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 发起人 实体类
 * <p>
 * Created by Administrator on 2017/9/13.
 */

public class PersonBean implements Serializable {

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
    }

    public class Rows implements Serializable {
        private String avatar;//头像
        private String employeeId;//员工id
        private String departmentName;//部门名称
        private String mobilePhone;//手机号
        private String name;//名称
        private String serviceProviderCode;//公司code
        private String userGroupName;//只有未绑定企业的联系人才有此职能名称
        private int totalWorkNum;
        private int workNum;

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setServiceProviderCode(String serviceProviderCode) {
            this.serviceProviderCode = serviceProviderCode;
        }

        public void setUserGroupName(String userGroupName) {
            this.userGroupName = userGroupName;
        }

        public int getTotalWorkNum() {
            return totalWorkNum;
        }

        public void setTotalWorkNum(int totalWorkNum) {
            this.totalWorkNum = totalWorkNum;
        }

        public int getWorkNum() {
            return workNum;
        }

        public void setWorkNum(int workNum) {
            this.workNum = workNum;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public String getServiceProviderCode() {
            return serviceProviderCode;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public String getUserGroupName() {
            return userGroupName;
        }
    }


}
