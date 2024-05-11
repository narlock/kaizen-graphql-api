package com.narlock.kaizengraphqlapi.model.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {
  private Integer id;
  private String username;
  private String birthDate;
  private String imageUrl;
  private Integer xp;
  private Integer numRows;
  private String pin;
  private Health health;
  private List<RowInfo> rows;
}
