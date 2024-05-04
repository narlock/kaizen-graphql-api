package com.narlock.kaizengraphqlapi.model.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {
  private Integer id;
  private String username;
  private Integer age;
  private String birthDate;
  private String imageUrl;
  private Integer xp;
  private Health health;
}
