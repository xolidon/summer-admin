package com.pulip.summer.core.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PageResponse<T> {
    private List<T> content;
    private long totalCount;
    private int totalPages;
    private int page;
    private int size;
    private boolean hasNext;

    public PageResponse(Page<T> page) {
        this.content = page.getContent();
        this.totalCount = page.getTotalElements();
        this.page = page.getNumber() + 1;
        this.size = page.getSize();
        this.hasNext = page.hasNext();
        this.totalPages = page.getTotalPages();
    }

    public static <T> PageResponse<T> of(Page<T> page) {
        return new PageResponse<>(page);
    }
}
