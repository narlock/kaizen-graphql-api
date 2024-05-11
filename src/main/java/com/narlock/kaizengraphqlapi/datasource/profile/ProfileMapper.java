package com.narlock.kaizengraphqlapi.datasource.profile;

import com.narlock.kaizengraphqlapi.datasource.profile.model.ProfileModel;
import com.narlock.kaizengraphqlapi.datasource.profile.model.RowInfoModel;
import com.narlock.kaizengraphqlapi.model.profile.Profile;
import com.narlock.kaizengraphqlapi.model.profile.RowInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

  @Mapping(target = "id", source = "profileModel.profile.id")
  @Mapping(target = "username", source = "profileModel.profile.username")
  @Mapping(target = "birthDate", source = "profileModel.profile.birthDate")
  @Mapping(target = "imageUrl", source = "profileModel.profile.imageUrl")
  @Mapping(target = "xp", source = "profileModel.profile.xp")
  @Mapping(target = "numRows", source = "profileModel.profile.numRows")
  @Mapping(target = "pin", source = "profileModel.profile.pin")
  @Mapping(target = "health", source = "health")
  @Mapping(target = "rows", source = "rowInfoList")
  Profile map(ProfileModel profileModel);

  default List<RowInfo> mapRowInfoList(List<RowInfoModel> rowInfoModels) {
    return rowInfoModels.stream().map(this::mapRowInfo).collect(Collectors.toList());
  }

  RowInfo mapRowInfo(RowInfoModel rowInfoModel);
}
