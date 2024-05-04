package com.narlock.kaizengraphqlapi.datasource.profile;

import com.narlock.kaizengraphqlapi.datasource.profile.model.ProfileModel;
import com.narlock.kaizengraphqlapi.model.profile.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

  @Mapping(target = "birthDate", source = "birth_date") // Matching snake_case with camelCase
  @Mapping(target = "imageUrl", source = "image_url") // Matching snake_case with camelCase
  Profile map(ProfileModel profileModel);
}
