package com.tlliu.springboot.carolj.domain;

import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

public interface Pageable {
    static Pageable unpaged() {
        return Unpaged.INSTANCE;
    }

    default boolean isPaged(){
        return true;
    }

    default boolean isUnpaged() {
        return !isPaged();
    }

    int getPageNumber();

    int getPageSize();

    long getOffset();

    Sort getSort();

    default Sort getSortOr(Sort sort) {
        Assert.notNull(sort, "Fallback Sort must not be null!");
        return getSort().isSorted() ? getSort() : sort;
    }

    Pageable first();
    
    Pageable next();
    
    Pageable previousOrFirst();
    
    boolean hasPrevious();

    default Optional<Pageable> toOptional(){
        return isUnpaged() ? Optional.empty() : Optional.of(this);
    }
}
