package com.limbo.sdk_demo.bean;

/**
 * Project :  demo_test.
 * Package name: com.limbo.sdk_demo.bean
 * Created by :  benjamin.
 * Created time: 2018/6/26 15:05
 * Changed by :  benjamin.
 * Changed time: 2018/6/26 15:05
 * Class description:
 */
public class CheckSecretBean {

    /**
     * message : {"code":200,"message":"操作成功！"}
     * rows : false
     * total : 0.0
     */

    private MessageBean message;
    private boolean rows;
    private double total;

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public boolean isRows() {
        return rows;
    }

    public void setRows(boolean rows) {
        this.rows = rows;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public static class MessageBean {
        /**
         * code : 200.0
         * message : 操作成功！
         */

        private double code;
        private String message;

        public double getCode() {
            return code;
        }

        public void setCode(double code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
