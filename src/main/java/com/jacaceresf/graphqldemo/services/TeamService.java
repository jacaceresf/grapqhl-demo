package com.jacaceresf.graphqldemo.services;

import com.jacaceresf.graphqldemo.beans.Team;
import com.jacaceresf.graphqldemo.repositories.TeamRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@GraphQLApi
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GraphQLQuery(name = "teams")
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    @GraphQLQuery(name = "team")
    public Optional<Team> getTeamById(@GraphQLArgument(name = "id", description = "Team's id") Long id) {
        return teamRepository.findById(id);
    }

    @GraphQLMutation(name = "saveTeam")
    public Team saveTeam(@GraphQLContext Team team) {
        return teamRepository.save(team);
    }

    @GraphQLQuery(name = "isGreat")
    public boolean isGreat(@GraphQLContext Team team) {
        return team.getChampionships() > 5;
    }
}
