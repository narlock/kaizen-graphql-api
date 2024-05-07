package com.narlock.kaizengraphqlapi.model.checklist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Checklist {
  private String name;
  private Integer profileId;
  private String repeatEvery;
}
