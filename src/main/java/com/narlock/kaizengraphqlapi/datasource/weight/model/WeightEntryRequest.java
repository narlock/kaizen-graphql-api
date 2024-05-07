package com.narlock.kaizengraphqlapi.datasource.weight.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WeightEntryRequest {
  private Double weight;
  private LocalDate date;
  private String meta;
}
