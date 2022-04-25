package com.bd.assignment3.batch;

import com.bd.assignment3.research.Research;
import lombok.Data;

import java.util.List;

@Data
public class ApiResDto {
    private int currentCount;
    private List<Research> data;
    private int matchCount;
    private int page;
    private int perPage;
    private int totalCount;
}
