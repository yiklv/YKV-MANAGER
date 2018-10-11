package com.yiklv.travel.index.entity;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: SpotKeyWordBean
 * @Package com.yiklv.travel.index.entity
 * @Description: 景点关键词实体bean
 * @author: yanguo
 * @date: 2018/8/18 10:23
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class SpotKeyWordBean implements Serializable {
    private static final long serialVersionUID = 525261091421747923L;

    private String keyId;

    private String keyName;

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    @Override
    public String toString() {
        return "SpotKeyWordBean{" +
                "keyId='" + keyId + '\'' +
                ", keyName='" + keyName + '\'' +
                '}';
    }
}
