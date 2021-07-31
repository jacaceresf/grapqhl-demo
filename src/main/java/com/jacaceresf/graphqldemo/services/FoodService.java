package com.jacaceresf.graphqldemo.services;


import com.jacaceresf.graphqldemo.beans.Food;
import com.jacaceresf.graphqldemo.repositories.FoodRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@GraphQLApi
public class FoodService {

    private final FoodRepository foodRepository;

    private final List<String> goodFood = Arrays.asList("Avocado", "Spam");

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    /**
     * Read all foods.
     *
     * @return All foods.
     */
    @GraphQLQuery(name = "foods")
    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    /**
     * Read food by id.
     *
     * @param id
     * @return
     */
    @GraphQLQuery(name = "food")
    public Optional<Food> getFoodById(@GraphQLArgument(name = "id") Long id) {
        return foodRepository.findById(id);
    }

    @GraphQLQuery(name = "isGood")
    public boolean isGood(@GraphQLContext Food food) {
        return goodFood.contains(food.getName());
    }

    /**
     * Saves a food record.
     *
     * @param food
     * @return
     */
    @GraphQLMutation(name = "saveFood")
    public Food saveFood(@GraphQLArgument(name = "food") Food food) {
        return foodRepository.save(food);
    }

}
