package com.pulip.summer.core.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PageRequest {
    private int page = 1;
    private int size = 10;
    private List<String> sort;

    public Pageable of() {
        return org.springframework.data.domain.PageRequest.of(page, size, Sort.by(getOrders()));
    }

    private List<Sort.Order> getOrders() {
        List<Sort.Order> orders = new ArrayList<>();
        sort.forEach(s -> orders.add(new Sort.Order(Sort.Direction.ASC, s)));
        return orders;
    }
}
