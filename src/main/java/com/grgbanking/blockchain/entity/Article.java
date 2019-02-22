package com.grgbanking.blockchain.entity;

import com.grgbanking.blockchain.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_article")
@Data
@EqualsAndHashCode(callSuper = false)
public class Article extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_aid")
    private Long aid;

    @Column(name = "t_cover_image")
    private String coverImage;

    @Column(name = "t_title")
    private String title;

    @Column(name = "t_introduce")
    private String introduce;

    @Column(name = "t_content")
    private String content;

    @Column(name = "t_source")
    private String source;

    @Column(name = "t_total")
    private Integer total;

    @Column(name = "t_weight")
    private Integer weight;

    @Column(name = "t_user_id")
    private String userId;

    @Column(name = "t_category_id")
    private Integer categoryId;

    @Column(name = "t_state")
    private Integer state;


}