package com.narlock.kaizengraphqlapi.datasource.profile.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileModel {
  private Integer id;
  private String username;
  private Integer age;
  private String birth_date;
  private String image_url;
  private Integer xp;
  private HealthModel health;
}
