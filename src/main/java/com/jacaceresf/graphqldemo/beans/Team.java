package com.jacaceresf.graphqldemo.beans;

import io.leangen.graphql.annotations.GraphQLQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @GraphQLQuery(name = "id", description = "A team's id.")
    private Long id;

    @GraphQLQuery
    private String name;

    @GraphQLQuery
    private String city;

    @GraphQLQuery
    private Integer championships;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getChampionships() {
        return championships;
    }

    public void setChampionships(Integer championships) {
        this.championships = championships;
    }

    public Team() {

    }

    public Team(Long id, String name, String city, Integer championships) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.championships = championships;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", championships=" + championships +
                '}';
    }
}
