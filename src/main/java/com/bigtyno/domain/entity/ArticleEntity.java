package com.bigtyno.domain.entity;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;


@Getter
@ToString
// 인덱스 거는 이유 검색 때문
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createAt"),
        @Index(columnList = "createBy")
})
@Entity
@DynamicInsert
@DynamicUpdate
@Where(clause = "deleteYn=false")
public class ArticleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문
    @Setter private String hashtag; // 해시태그

    // 양뱡향 매핑
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @ToString.Exclude
    private final Set<ArticleCommentEntity> articleCommentSet = new LinkedHashSet<>();

    protected ArticleEntity() {}

    private ArticleEntity(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static ArticleEntity of(String title, String content, String hashtag) {
        return new ArticleEntity(title,content,hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleEntity article = (ArticleEntity) o;
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

