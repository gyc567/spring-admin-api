package com.grgbanking.blockchain.controller;

import com.grgbanking.blockchain.entity.Article;
import com.grgbanking.blockchain.service.IArticleService;
import com.grgbanking.blockchain.common.controller.BaseController;
import com.grgbanking.blockchain.vo.MyPage;
import com.grgbanking.blockchain.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Wang Chen Chen
 * @Date: 2018/11/15 14:49
 * @describe：
 * @version: 1.0
 */

@Api(tags = "文章管理")
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController<Article, Long, IArticleService> {

    @GetMapping("/list")
    @Override
    public Result<Page<Article>> findAll(MyPage page) {
        return Result.success(baseService.findAll(page));
    }

}
