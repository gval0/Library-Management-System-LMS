package com.library.lms.repo;

import com.library.lms.entity.BookEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity> {

    List<BookEntity> findAll(Specification<BookEntity> specification);

}
