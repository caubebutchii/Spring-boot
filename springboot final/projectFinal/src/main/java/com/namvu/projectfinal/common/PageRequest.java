package com.namvu.projectfinal.common;

import lombok.Data;

import java.awt.print.Pageable;

@Data
public class PageRequest {
    private int page = 0;
    private int size = 5;

    public Pageable getPageable()
    {
        return org.springframework.data.domain.PageRequest.of(page, size);
    }
}
