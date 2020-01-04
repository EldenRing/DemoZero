/*
 *
 *      Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lengleng (wangiegie@gmail.com)
 *
 */

package com.me.example.demo.interfaces.dto;

import com.me.example.demo.Infrastructure.common.constants.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 响应信息主体
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //链式 set方法会返回传入值
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    //"返回标记：成功标记=0，失败标记=1"
    private int code;

    @Getter
    @Setter
    private String msg;


    @Getter
    @Setter
    private T data;

    public static <T> Result<T> ok() {
        return restResult(null, CommonConstants.SUCCESS, null);
    }

    public static <T> Result<T> ok(T data) {
        return restResult(data, CommonConstants.SUCCESS, null);
    }

    public static <T> Result<T> ok(T data, String msg) {
        return restResult(data, CommonConstants.SUCCESS, msg);
    }

    public static <T> Result<T> failed() {
        return restResult(null, CommonConstants.FAIL, null);
    }

    public static <T> Result<T> failed(String msg) {
        return restResult(null, CommonConstants.FAIL, msg);
    }

    public static <T> Result<T> failed(T data) {
        return restResult(data, CommonConstants.FAIL, null);
    }

    public static <T> Result<T> failed(T data, String msg) {
        return restResult(data, CommonConstants.FAIL, msg);
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", this.code);
        map.put("msg", this.msg);
        map.put("data", this.data);
        return map;
    }

    private static <T> Result<T> restResult(T data, int code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
