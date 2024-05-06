package com.narlock.kaizengraphqlapi.datasource.weight.model;

import com.narlock.kaizengraphqlapi.model.weight.WeightEntry;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class DateWeightEntryResponse {
  private LocalDate startDate;
  private LocalDate endDate;
  private Integer count;
  private List<WeightEntry> entries;
}
