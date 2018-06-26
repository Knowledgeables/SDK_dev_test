package com.limbo.sdk_demo.bean;

/**
 * Project :  demo_test.
 * Package name: com.limbo.sdk_demo.bean
 * Created by :  benjamin.
 * Created time: 2018/6/26 14:56
 * Changed by :  benjamin.
 * Changed time: 2018/6/26 14:56
 * Class description:
 */
public class AppKeyBean {

    /**
     * key1 : {"appKey":"业主端key","appSectet":"业主端密钥"}
     * key2 : {"appKey":"服务商端key","appSectet":"服务商端密钥"}
     */

    private Key1Bean key1;
    private Key2Bean key2;

    public Key1Bean getKey1() {
        return key1;
    }

    public void setKey1(Key1Bean key1) {
        this.key1 = key1;
    }

    public Key2Bean getKey2() {
        return key2;
    }

    public void setKey2(Key2Bean key2) {
        this.key2 = key2;
    }

    public static class Key1Bean {
        /**
         * appKey : 业主端key
         * appSectet : 业主端密钥
         */

        private String appKey;
        private String appSectet;


        public Key1Bean(String appKey, String appSectet) {
            this.appKey = appKey;
            this.appSectet = appSectet;
        }

        public String getAppKey() {
            return appKey;
        }

        public void setAppKey(String appKey) {
            this.appKey = appKey;
        }

        public String getAppSectet() {
            return appSectet;
        }

        public void setAppSectet(String appSectet) {
            this.appSectet = appSectet;
        }
    }

    public static class Key2Bean {
        /**
         * appKey : 服务商端key
         * appSectet : 服务商端密钥
         */

        private String appKey;
        private String appSectet;

        public Key2Bean(String appKey, String appSectet) {
            this.appKey = appKey;
            this.appSectet = appSectet;
        }

        public String getAppKey() {
            return appKey;
        }

        public void setAppKey(String appKey) {
            this.appKey = appKey;
        }

        public String getAppSectet() {
            return appSectet;
        }

        public void setAppSectet(String appSectet) {
            this.appSectet = appSectet;
        }
    }
}
