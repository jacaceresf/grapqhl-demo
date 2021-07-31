package com.jacaceresf.graphqldemo.services;


import com.jacaceresf.graphqldemo.beans.Food;
import com.jacaceresf.graphqldemo.repositories.FoodRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GraphQLQuery(name = "foods")
    public List<Food> getFoods() {
        return foodRepository.findAll();
    }
}
