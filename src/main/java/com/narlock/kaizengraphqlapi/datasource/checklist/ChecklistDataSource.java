package com.narlock.kaizengraphqlapi.datasource.checklist;

import com.narlock.kaizengraphqlapi.model.checklist.Checklist;
import com.narlock.kaizengraphqlapi.model.checklist.ChecklistItem;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class ChecklistDataSource {
  private final WebClient checklistWebClient;

  public Checklist createChecklist(String name, Integer profileId, String repeatEvery) {
    Checklist requestBody =
        Checklist.builder().name(name).profileId(profileId).repeatEvery(repeatEvery).build();
    return checklistWebClient
        .post()
        .uri(uriBuilder -> uriBuilder.path("/checklist").build())
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(Checklist.class)
        .block();
  }

  public Checklist getChecklist(String name, Integer profileId) {
    return checklistWebClient
        .get()
        .uri(
            uriBuilder ->
                uriBuilder
                    .path("/checklist")
                    .queryParam("name", name)
                    .queryParam("profileId", profileId)
                    .build())
        .retrieve()
        .bodyToMono(Checklist.class)
        .block();
  }

  public Checklist updateChecklistRepeat(String name, Integer profileId, String repeatEvery) {
    return checklistWebClient
        .patch()
        .uri(
            uriBuilder ->
                uriBuilder
                    .path("/checklist")
                    .queryParam("name", name)
                    .queryParam("profileId", profileId)
                    .queryParam("repeatEvery", repeatEvery)
                    .build())
        .retrieve()
        .bodyToMono(Checklist.class)
        .block();
  }

  public void deleteChecklist(String name, Integer profileId) {
    checklistWebClient
        .delete()
        .uri(
            uriBuilder ->
                uriBuilder
                    .path("/checklist")
                    .queryParam("name", name)
                    .queryParam("profileId", profileId)
                    .build())
        .retrieve()
        .bodyToMono(Void.class)
        .block();
  }

  public ChecklistItem createChecklistItem(ChecklistItem requestBody) {
    return checklistWebClient
        .post()
        .uri(uriBuilder -> uriBuilder.path("/checklist-item").build())
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(ChecklistItem.class)
        .block();
  }

  public ChecklistItem updateChecklistItem(Integer id, ChecklistItem requestBody) {
    return checklistWebClient
        .put()
        .uri(uriBuilder -> uriBuilder.path("/checklist-item/{id}").build(id))
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(ChecklistItem.class)
        .block();
  }

  public ChecklistItem updateChecklistStreak(Integer id) {
    return checklistWebClient
        .patch()
        .uri(uriBuilder -> uriBuilder.path("/checklist-item/{id}/streak").build(id))
        .retrieve()
        .bodyToMono(ChecklistItem.class)
        .block();
  }

  public void deleteChecklistItem(Integer id) {
    checklistWebClient
        .delete()
        .uri(uriBuilder -> uriBuilder.path("/checklist-item/{id}").build(id))
        .retrieve()
        .bodyToMono(Void.class)
        .block();
  }

  public List<ChecklistItem> getChecklistItemsByChecklistName(String checklistName) {
    return checklistWebClient
        .get()
        .uri(
            uriBuilder ->
                uriBuilder.path("/checklist").queryParam("checklistName", checklistName).build())
        .retrieve()
        .bodyToFlux(ChecklistItem.class)
        .collectList()
        .block();
  }

  public ChecklistItem getChecklistItem(Integer id) {
    return checklistWebClient
        .get()
        .uri(uriBuilder -> uriBuilder.path("/checklist-item/{id}").build(id))
        .retrieve()
        .bodyToMono(ChecklistItem.class)
        .block();
  }
}