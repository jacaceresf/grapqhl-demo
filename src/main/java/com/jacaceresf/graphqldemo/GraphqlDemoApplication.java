package com.jacaceresf.graphqldemo;

import com.jacaceresf.graphqldemo.beans.Food;
import com.jacaceresf.graphqldemo.beans.Team;
import com.jacaceresf.graphqldemo.services.FoodService;
import com.jacaceresf.graphqldemo.services.TeamService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class GraphqlDemoApplication {

    /**
     * To initialize app with sample data.
     *
     * @param foodService
     * @return
     */
    @Bean
    ApplicationRunner init(FoodService foodService, TeamService teamService) {

        return args -> {
            Stream.of("Pizza", "Spam", "Eggs", "Avocado", "Burger").forEach(
                    name -> {
                        Food food = new Food();
                        food.setName(name);
                        foodService.saveFood(food);
                    }
            );
            foodService.getFoods().forEach(System.out::println);

            Stream.of(new Team(null, "Los Angeles Lakers", "Los Angeles", 17),
                    new Team(null, "Boston Celtics", "Boston", 17),
                    new Team(null, "Golden State Warriors", "Oakland", 6),
                    new Team(null, "Chicago Bulls", "Chicago", 6)).forEach(
                    teamService::saveTeam
            );

            teamService.getTeams().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(GraphqlDemoApplication.class, args);
    }

}
