package com.bigtyno.domain.entity;

import java.time.LocalDateTime;

public class ArticleEntity {
    private Long id;
    private String title;
    private String content;
    private String hashtag;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    private LocalDateTime removedAt;

}
