package com.grgbanking.blockchain.service;

import com.grgbanking.blockchain.common.service.IBaseService;
import com.grgbanking.blockchain.entity.Article;
import com.grgbanking.blockchain.vo.MyPage;
import org.springframework.data.domain.Page;

/**
 * @author: Wang Chen Chen
 * @Date: 2018/11/15 14:24
 * @describe：
 * @version: 1.0
 */

public interface IArticleService extends IBaseService<Article, Long> {

    // 根据类目分页
    Page<Article> findAll(MyPage page);



}
