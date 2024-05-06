package com.narlock.kaizengraphqlapi.model.weight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeightEntry {
  private Integer id;
  private Double weight;
  private String date;
  private String meta;
}
