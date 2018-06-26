package com.limbo.sdk_demo.bean;

/**
 * Created by wangqi on 2018/5/16.
 */

public class PhotoBean {

    /**
     * attachName : 2018051613154148837.jpg
     * msg : 上传成功！
     * name : IMG_20180516_104732.jpg
     * path : /serviceProviderFile/20171026-125548-5/jpg/2018051613154148837.jpg
     * size : 3346.9KB
     * status : 1
     */

    private String attachName;
    private String msg;
    private String name;
    private String path;
    private String size;
    private String status;

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
