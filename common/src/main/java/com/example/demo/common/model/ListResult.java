package com.example.demo.common.model;

import java.util.List;

/**
 * @auther suijinchi
 * @description List类型数据
 * @date 2022/3/18
 */
public class ListResult<D> extends Model {

    private List<D> data;

    public List<D> getData() {
        return data;
    }

    public void setData(List<D> data) {
        this.data = data;
    }

}
