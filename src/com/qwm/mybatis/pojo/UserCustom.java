package com.qwm.mybatis.pojo;
/**
 * @author：qiwenming
 * @date：2018/1/6 0006
 * @description：
 * 自定义的user扩展类
 */
public class UserCustom extends User {
    private Float price;//商品价格
    private String itemName;//商品名称

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
