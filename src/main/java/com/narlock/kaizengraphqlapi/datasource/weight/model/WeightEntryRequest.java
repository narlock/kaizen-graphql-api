package com.narlock.kaizengraphqlapi.datasource.weight.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WeightEntryRequest {
    private Double weight;
    private LocalDate date;
    private String meta;
}
