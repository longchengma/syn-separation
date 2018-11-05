package com.home.spring.aop;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by li.ma on 2018/9/8.
 */
public class MenuInfoResponseBO {
    private static final long serialVersionUID = -6404613495597746508L;
    private String id;
    private String menu_name;
    private String menu_img;
    private String description;
    private String menu_url;
    private String parent_id;
    private String platform;
    private String order_by;
    private String create_time;
    private String status;

    public MenuInfoResponseBO(String menu_url, String menu_name) {
        this.menu_url = menu_url;
        this.menu_name = menu_name;
    }

    public MenuInfoResponseBO() {

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenu_name() {
        return this.menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_img() {
        return this.menu_img;
    }

    public void setMenu_img(String menu_img) {
        this.menu_img = menu_img;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMenu_url() {
        return this.menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOrder_by() {
        return this.order_by;
    }

    public void setOrder_by(String order_by) {
        this.order_by = order_by;
    }

    public String getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
