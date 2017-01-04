package org.cn.external.weixin.model.message;

import org.cn.external.weixin.utils.XmlElement;

/**
 * 地理位置消息
 * MsgType location
 */
public class LocationMessage extends BaseMessage {
    @XmlElement(name = "Location_X")
    private String locationX; // 地理位置维度
    @XmlElement(name = "Location_Y")
    private String locationY; // 地理位置经度
    @XmlElement(name = "Scale")
    private String scale; // 地图缩放大小
    @XmlElement(name = "Label")
    private String label; // 地理位置信息

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
