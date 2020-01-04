package com.me.example.demo.service;

import com.me.example.demo.Infrastructure.utils.api.IdWork;
import com.me.example.demo.domain.bo.TestBo;
import com.me.example.demo.repository.mapper.TestMapper;
import com.me.example.demo.repository.po.TestPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Chen Wei
 * @Date: Created in 20:28 2020/1/4
 */
@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;

    public TestBo get(String id) {
        TestBo testBo = new TestBo();
        BeanUtils.copyProperties(testMapper.get(id), testBo);
        return testBo;
    }

    public int create(TestBo testBo) {
        testBo.setId(IdWork.getId());
        TestPo testPo = new TestPo();
        BeanUtils.copyProperties(testBo, testPo);
        return testMapper.create(testPo);
    }
}
