package com.narlock.kaizengraphqlapi.datasource.checklist;

import com.narlock.kaizengraphqlapi.model.checklist.Checklist;
import com.narlock.kaizengraphqlapi.model.checklist.ChecklistItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class ChecklistDataSource {
    private final WebClient checklistWebClient;

    public Checklist getChecklist(String name, Integer profileId) {
        return checklistWebClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/checklist")
                        .queryParam("name", name)
                        .queryParam("profileId", profileId)
                        .build())
                .retrieve()
                .bodyToMono(Checklist.class)
                .block();
    }

    public ChecklistItem getChecklistItem(Integer id) {
        return checklistWebClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/checklist-item/{id}")
                        .build(id))
                .retrieve()
                .bodyToMono(ChecklistItem.class)
                .block();
    }
}
