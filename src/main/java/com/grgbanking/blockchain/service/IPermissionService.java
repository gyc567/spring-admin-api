package com.grgbanking.blockchain.service;

import com.grgbanking.blockchain.common.service.IBaseService;
import com.grgbanking.blockchain.entity.Permission;

import java.util.Set;

/**
 * @author: Wang Chen Chen
 * @Date: 2018/11/15 14:24
 * @describe：
 * @version: 1.0
 */

public interface IPermissionService extends IBaseService<Permission, Integer> {

    Set<Permission> findAllByUserId(String uid);

    Set<Integer> findPermissionByRoleId(Integer rid);

    // 以树节点展示
    Set<Permission> findAllTree();
}
