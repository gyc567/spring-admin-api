package com.grgbanking.blockchain.service.impl;

import com.grgbanking.blockchain.common.service.impl.BaseServiceImpl;
import com.grgbanking.blockchain.entity.Role;
import com.grgbanking.blockchain.repository.RoleRepository;
import com.grgbanking.blockchain.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author: Wang Chen Chen
 * @Date: 2018/11/15 14:27
 * @describe： 角色Service 实现类
 * @version: 1.0
 */

@Slf4j
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer, RoleRepository> implements IRoleService {

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Integer updateUserRole(String uid, Set<Integer> roleIds) {
        Integer deleteInteger = baseRepository.deleteUserRoleAll(uid);
        log.info("用户id为 {} 删除了 {} 条角色.......", uid, deleteInteger);
        roleIds.forEach(roleId -> baseRepository.addUserRole(uid, roleId));
        return 1;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Integer updateRolePermission(Integer rid, Set<Integer> permissionIds) {
        Integer deleteInteger = baseRepository.deleteRolePermissionAll(rid);
        log.info("角色 ID 为 {} 删除了 {} 条权限.......", rid, deleteInteger);
        permissionIds.forEach(pid -> baseRepository.addRolePermission(rid, pid));
        return 1;
    }

    @Override
    public Set<Role> findAllByUserId(String uid) {
        return baseRepository.findAllByUserId(uid);
    }

}
