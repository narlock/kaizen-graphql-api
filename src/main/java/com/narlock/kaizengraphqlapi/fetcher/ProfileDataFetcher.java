package com.narlock.kaizengraphqlapi.fetcher;

import com.narlock.kaizengraphqlapi.datasource.profile.ProfileDataSource;
import com.narlock.kaizengraphqlapi.model.profile.Profile;
import com.narlock.kaizengraphqlapi.model.profile.RowInfo;
import com.narlock.kaizengraphqlapi.model.profile.input.ProfileInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import java.util.List;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class ProfileDataFetcher {

  private final ProfileDataSource profileDataSource;

  @DgsQuery
  public Profile profile(@InputArgument Integer id) {
    return profileDataSource.getProfileById(id);
  }

  @DgsMutation
  public Profile createProfile(@InputArgument ProfileInput input) {
    return profileDataSource.createProfile(input);
  }

  @DgsMutation
  public Profile updateProfile(@InputArgument ProfileInput input) {
    return profileDataSource.updateProfile(input);
  }

  @DgsMutation
  public Boolean deleteProfile(@InputArgument Integer id) {
    profileDataSource.deleteProfile(id);
    return true;
  }

  @DgsMutation
  public List<RowInfo> createRowInfo(
      @InputArgument Integer profileId,
      @InputArgument Integer rowIndex,
      @InputArgument String widgets) {
    return profileDataSource.createRowInfo(profileId, rowIndex, widgets);
  }

  @DgsMutation
  public List<RowInfo> updateRowInfo(
      @InputArgument Integer profileId,
      @InputArgument Integer rowIndex,
      @InputArgument String widgets) {
    return profileDataSource.updateRowInfo(profileId, rowIndex, widgets);
  }

  @DgsMutation
  public Boolean deleteRowInfo(@InputArgument Integer profileId, @InputArgument Integer rowIndex) {
    profileDataSource.deleteRowInfo(profileId, rowIndex);
    return true;
  }
}
