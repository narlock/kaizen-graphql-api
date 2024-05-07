package com.narlock.kaizengraphqlapi.fetcher;

import com.narlock.kaizengraphqlapi.datasource.weight.WeightTrackDataSource;
import com.narlock.kaizengraphqlapi.model.weight.WeightEntry;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import java.util.List;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class WeightTrackDataFetcher {
  private final WeightTrackDataSource weightTrackDataSource;

  @DgsQuery
  public WeightEntry weightEntry(@InputArgument String date) {
    return weightTrackDataSource.getWeightEntryByDate(date);
  }

  @DgsQuery
  public List<WeightEntry> weightEntriesByRange(
      @InputArgument String startDate, @InputArgument String endDate) {
    return weightTrackDataSource.getWeightEntriesByRange(startDate, endDate);
  }

  @DgsMutation
  public WeightEntry createWeightEntry(@InputArgument Double weight, @InputArgument String date, @InputArgument String meta) {
    return weightTrackDataSource.createWeightEntry(weight, date, meta);
  }

  @DgsMutation
  public WeightEntry updateWeightEntryById(@InputArgument Integer id, @InputArgument Double weight, @InputArgument String date, @InputArgument String meta) {
    return weightTrackDataSource.updateWeightEntry(id, weight, date, meta);
  }

  @DgsMutation
  public Boolean deleteWeightEntryById(@InputArgument Integer id) {
    weightTrackDataSource.deleteWeightEntry(id);
    return true;
  }
}
