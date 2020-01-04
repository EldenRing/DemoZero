package com.me.example.demo.interfaces.controller;

import com.me.example.demo.domain.bo.TestBo;
import com.me.example.demo.interfaces.dto.Result;
import com.me.example.demo.interfaces.dto.TestDto;
import com.me.example.demo.service.TestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Chen Wei
 * @Date: Created in 20:22 2020/1/4
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result<?> get(@PathVariable String id) {
        return Result.ok(testService.get(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result<?> create(@RequestBody TestDto testDto) {
        TestBo testBo = new TestBo();
        BeanUtils.copyProperties(testDto, testBo);
        int i = testService.create(testBo);
        if (i == 0) {
            return Result.failed();
        }
        return Result.ok();
    }
}
