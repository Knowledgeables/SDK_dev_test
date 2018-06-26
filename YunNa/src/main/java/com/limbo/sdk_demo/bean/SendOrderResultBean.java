package com.limbo.sdk_demo.bean;

/**
 * Project :  demo_test.
 * Package name: com.limbo.sdk_demo.bean
 * Created by :  benjamin.
 * Created time: 2018/6/26 15:33
 * Changed by :  benjamin.
 * Changed time: 2018/6/26 15:33
 * Class description:
 */
public class SendOrderResultBean {

    /**
     * message : {"code":202,"message":"数据传输错误！"}
     * total : 0.0
     */

    private MessageBean message;
    private double total;

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public static class MessageBean {
        /**
         * code : 202.0
         * message : 数据传输错误！
         */

        private double code;
        private String message;

        public int getCode() {
            return (int)Math.floor(code);
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
