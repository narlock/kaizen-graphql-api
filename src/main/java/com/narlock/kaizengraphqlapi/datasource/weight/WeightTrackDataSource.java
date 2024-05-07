package com.narlock.kaizengraphqlapi.datasource.weight;

import com.narlock.kaizengraphqlapi.datasource.weight.model.DateWeightEntryResponse;
import com.narlock.kaizengraphqlapi.datasource.weight.model.WeightEntryRequest;
import com.narlock.kaizengraphqlapi.model.weight.WeightEntry;

import java.time.LocalDate;
import java.util.List;

import com.narlock.kaizengraphqlapi.util.InputValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import static com.narlock.kaizengraphqlapi.util.InputValidationUtil.DATE_FORMATTER;

@Component
@RequiredArgsConstructor
public class WeightTrackDataSource {
  private final WebClient weightTrackWebClient;

  public WeightEntry getWeightEntryByDate(String date) {
    InputValidationUtil.isISOLocalDate(date);
    return weightTrackWebClient
        .get()
        .uri(uriBuilder -> uriBuilder.queryParam("date", date).build())
        .retrieve()
        .bodyToMono(WeightEntry.class)
        .block();
  }

  public List<WeightEntry> getWeightEntriesByRange(String startDate, String endDate) {
    InputValidationUtil.areISOLocalDate(startDate, endDate);
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

  public WeightEntry createWeightEntry(Double weight, String date, String meta) {
    InputValidationUtil.isISOLocalDate(date);

    // Construct weight entry request
    WeightEntryRequest requestBody = constructWeightEntryRequest(weight, date, meta);

    return weightTrackWebClient
            .post()
            .uri(uriBuilder -> uriBuilder.build())
            .bodyValue(requestBody)
            .retrieve()
            .bodyToMono(WeightEntry.class)
            .block();
  }

  public WeightEntry updateWeightEntry(Integer id, Double weight, String date, String meta) {
    InputValidationUtil.isISOLocalDate(date);

    // Construct weight entry request
    WeightEntryRequest requestBody = constructWeightEntryRequest(weight, date, meta);

    return weightTrackWebClient
            .put()
            .uri(uriBuilder -> uriBuilder.path("/{id}").build(id))
            .bodyValue(requestBody)
            .retrieve()
            .bodyToMono(WeightEntry.class)
            .block();
  }

  public void deleteWeightEntry(Integer id) {
    weightTrackWebClient
            .delete()
            .uri(uriBuilder -> uriBuilder.path("/{id}").build(id))
            .retrieve()
            .bodyToMono(Void.class)
            .block();
  }

  private WeightEntryRequest constructWeightEntryRequest(Double weight, String date, String meta) {
    return WeightEntryRequest.builder()
            .weight(weight)
            .date(LocalDate.parse(date, DATE_FORMATTER))
            .meta(meta)
            .build();
  }
}
