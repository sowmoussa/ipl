package io.sowmoussa.ipl.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.sowmoussa.ipl.model.Team;
import io.sowmoussa.ipl.repository.MatchRepository;
import io.sowmoussa.ipl.repository.TeamRepository;

@RestController
@CrossOrigin // allows others domain to make a call to this api
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

        team.setMatches(this.matchRepository.findLatestMatchesbyTeam(teamName, 4));

        return team;
    }
}
