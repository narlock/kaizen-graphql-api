package com.narlock.kaizengraphqlapi.datasource.habit;

import com.narlock.kaizengraphqlapi.model.habit.Habit;
import com.narlock.kaizengraphqlapi.model.habit.HabitEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HabitDataSource {
    private final WebClient habitWebClient;

    public Habit createHabit(String name, Integer profileId) {
        Habit habit = Habit.builder().name(name).profileId(profileId).build();
        return habitWebClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/habit").build())
                .bodyValue(habit)
                .retrieve()
                .bodyToMono(Habit.class)
                .block();
    }

    public HabitEntry createHabitEntry(String name, Integer profileId, String date) {
        HabitEntry habitEntry = HabitEntry.builder().name(name).profileId(profileId).date(date).build();
        return habitWebClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/habit-entry").build())
                .bodyValue(habitEntry)
                .retrieve()
                .bodyToMono(HabitEntry.class)
                .block();
    }

    public List<Habit> getHabitsForProfile(Integer profileId) {
        return habitWebClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/habit")
                        .queryParam("profileId", profileId)
                        .build())
                .retrieve()
                .bodyToFlux(Habit.class)
                .collectList()
                .block();
    }

    public Integer getHabitStreak(String name, Integer profileId) {
        Habit habit = Habit.builder().name(name).profileId(profileId).build();
        return habitWebClient
                .method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder.path("/habit/streak").build())
                .bodyValue(habit)
                .retrieve()
                .bodyToMono(Integer.class)
                .block();
    }

    public List<String> getCompletedDatesForHabit(String name, Integer profileId) {
        return habitWebClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/habit-entry")
                        .queryParam("name", name)
                        .queryParam("profileId", profileId).build())
                .retrieve()
                .bodyToFlux(String.class)
                .collectList()
                .block();
    }

    public String getHabitByDate(String name, Integer profileId, String date) {
        List<String> dates = habitWebClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/habit-entry")
                        .queryParam("name", name)
                        .queryParam("profileId", profileId).build())
                .retrieve()
                .bodyToFlux(String.class)
                .collectList()
                .block();
        return dates.get(0);
    }

    public Boolean deleteHabit(String name, Integer profileId) {
        habitWebClient
                .delete()
                .uri(uriBuilder -> uriBuilder.path("/habit")
                        .queryParam("name", name)
                        .queryParam("profileId", profileId).build())
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
