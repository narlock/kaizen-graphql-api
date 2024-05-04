package com.narlock.kaizengraphqlapi.fetcher;

import com.narlock.kaizengraphqlapi.datasource.profile.ProfileDataSource;
import com.narlock.kaizengraphqlapi.model.profile.Profile;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class ProfileDataFetcher {

  private final ProfileDataSource profileDataSource;

  @DgsQuery
  public Profile profile(@InputArgument Integer id) {
    return profileDataSource.getProfileById(id);
  }
}
