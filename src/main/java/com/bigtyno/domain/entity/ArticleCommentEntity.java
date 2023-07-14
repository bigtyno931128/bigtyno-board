package com.bigtyno.domain.entity;

import java.time.LocalDateTime;

public class ArticleCommentEntity {

    private Long id;
    private ArticleEntity article;
    private String content;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    private LocalDateTime removedAt;

}
