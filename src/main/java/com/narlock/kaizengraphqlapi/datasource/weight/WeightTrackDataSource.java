package com.narlock.kaizengraphqlapi.datasource.weight;

import com.narlock.kaizengraphqlapi.datasource.weight.model.DateWeightEntryResponse;
import com.narlock.kaizengraphqlapi.model.weight.WeightEntry;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class WeightTrackDataSource {
  private final WebClient weightTrackWebClient;

  public WeightEntry getWeightEntryByDate(String date) {
    return weightTrackWebClient
        .get()
        .uri(uriBuilder -> uriBuilder.queryParam("date", date).build())
        .retrieve()
        .bodyToMono(WeightEntry.class)
        .block();
  }

  public List<WeightEntry> getWeightEntriesByRange(String startDate, String endDate) {
    DateWeightEntryResponse response =
        weightTrackWebClient
            .get()
            .uri(
                uriBuilder ->
                    uriBuilder
                        .path("/range")
                        .queryParam("startDate", startDate)
                        .queryParam("endDate", endDate)
                        .build())
            .retrieve()
            .bodyToMono(DateWeightEntryResponse.class)
            .block();
    return response.getEntries();
  }
}
