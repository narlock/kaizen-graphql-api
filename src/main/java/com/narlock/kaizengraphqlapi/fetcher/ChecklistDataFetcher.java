package com.narlock.kaizengraphqlapi.fetcher;

import com.narlock.kaizengraphqlapi.datasource.checklist.ChecklistDataSource;
import com.narlock.kaizengraphqlapi.model.checklist.Checklist;
import com.narlock.kaizengraphqlapi.model.checklist.ChecklistItem;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class ChecklistDataFetcher {
  private final ChecklistDataSource checklistDataSource;

  @DgsQuery
  public Checklist checklist(@InputArgument String name, @InputArgument Integer profileId) {
    return checklistDataSource.getChecklist(name, profileId);
  }

  @DgsQuery
  public ChecklistItem checklistItem(@InputArgument Integer id) {
    return checklistDataSource.getChecklistItem(id);
  }
}