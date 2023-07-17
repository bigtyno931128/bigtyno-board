package com.bigtyno.repository;

import com.bigtyno.domain.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Long , ArticleEntity> {
}
