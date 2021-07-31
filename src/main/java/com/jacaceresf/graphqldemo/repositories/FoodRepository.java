package com.jacaceresf.graphqldemo.repositories;

import com.jacaceresf.graphqldemo.beans.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
