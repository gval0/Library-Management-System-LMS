package com.library.lms.util;

import com.library.lms.entity.BookEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<BookEntity> searchBook(String search) {
        return (root, query, criteriaBuilder) -> {
            Predicate titlePredicate = criteriaBuilder.like(root.get("title"), getLikePattern(search));
            Predicate authorPredicate = criteriaBuilder.like(root.get("author"), getLikePattern(search));
            Predicate isbnPredicate = criteriaBuilder.like(root.get("isbn"), getLikePattern(search));
            return criteriaBuilder.or(titlePredicate, authorPredicate, isbnPredicate);
        };
    }

    private static String getLikePattern(String value) {
        return "%" + value + "%";
    }
}
