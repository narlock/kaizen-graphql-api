package com.narlock.kaizengraphqlapi.datasource.profile;

import com.narlock.kaizengraphqlapi.datasource.profile.model.ProfileModel;
import com.narlock.kaizengraphqlapi.model.profile.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class ProfileDatasource {

  private final WebClient profileWebClient;
  private final ProfileMapper profileMapper;

  public Profile getProfileById(int id) {
    ProfileModel profileModel =
        profileWebClient
            .get()
            .uri(uriBuilder -> uriBuilder.path("/{id}").build(id))
            .retrieve()
            .bodyToMono(ProfileModel.class)
            .block();
    return profileMapper.map(profileModel);
  }
}
