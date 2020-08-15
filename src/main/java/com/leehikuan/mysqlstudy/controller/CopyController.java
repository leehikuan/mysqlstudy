package com.leehikuan.mysqlstudy.controller;

import com.leehikuan.mysqlstudy.service.CopyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leehikuan
 * @create 2020-08-14 23:17
 */
@RestController
@Api(tags = "copy")
public class CopyController {
    @Autowired
    CopyService copyServiceImpl;

    @ApiOperation(value ="拷贝数据" , tags = "copy")
    @GetMapping("/copy")
    boolean copy(){
        return copyServiceImpl.copy();
    }
}
