package com.narlock.kaizengraphqlapi.model.profile.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileInput {
    private Integer profileId;
    private String username;
    private Integer age;
    private String birthDate;
    private String imageUrl;
    private Integer xp;
    private Integer numRows;
    private String pin;
    private Double height;
    private Double weight;
    private Double goalWeight;
    private Double goalWater;
}
