package com.example.demo.common.model;

/**
 * @auther suijinchi
 * @description
 * @date 2022/3/18
 */
public class ResultDataModel<T> extends ResultModel<T> {

    private static final long serialVersionUID = 8775508366956939838L;

    public ResultDataModel() {
        super();
    }

    public ResultDataModel(T data) {
        super(data);
    }

}
