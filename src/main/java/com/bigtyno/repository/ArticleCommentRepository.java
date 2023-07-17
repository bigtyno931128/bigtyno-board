package com.bigtyno.repository;

import com.bigtyno.domain.entity.ArticleCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCommentRepository extends JpaRepository<Long, ArticleCommentEntity> {
}
