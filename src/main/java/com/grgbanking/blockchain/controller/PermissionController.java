package com.grgbanking.blockchain.controller;

import com.grgbanking.blockchain.entity.Permission;
import com.grgbanking.blockchain.service.IPermissionService;
import com.grgbanking.blockchain.common.controller.BaseController;
import com.grgbanking.blockchain.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author: Wang Chen Chen
 * @Date: 2018/11/15 14:49
 * @describe：
 * @version: 1.0
 */

@Api(tags = "权限管理")
@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController<Permission, Integer, IPermissionService> {

    @ApiOperation(value = "查询全部权限", notes = "返回结果为树格式")
    @GetMapping("/tree")
    public Result<Set<Permission>> get() {
        return Result.success(baseService.findAllTree());
    }

}
