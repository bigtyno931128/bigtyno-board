package com.bigtyno.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import javax.persistence.*;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createAt"),
        @Index(columnList = "createBy")
})
@Entity
public class ArticleCommentEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false) private ArticleEntity article; //게시글(id)
    @Setter @Column(nullable = false, length = 500) private String content; //본문
    
    protected ArticleCommentEntity() {}

    private ArticleCommentEntity(ArticleEntity article, String content) {
        this.article = article;
        this.content = content;
    }

    public static ArticleCommentEntity of(ArticleEntity article, String content) {
        return new ArticleCommentEntity(article,content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleCommentEntity that = (ArticleCommentEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
