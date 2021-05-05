package io.sowmoussa.ipl.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.sowmoussa.ipl.model.Team;
import io.sowmoussa.ipl.repository.MatchRepository;
import io.sowmoussa.ipl.repository.TeamRepository;

@RestController
public class TeamController {
    
    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    
    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = this.teamRepository.findByTeamName(teamName);

        Pageable pageable = PageRequest.of(0, 4);

        team.setMatches(this.matchRepository.getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, pageable));

        return team;
    }
}
