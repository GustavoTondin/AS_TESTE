package br.com.ulbra.AP2.controllers;

import br.com.ulbra.AP2.models.Team;
import br.com.ulbra.AP2.services.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/teams")
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    @GetMapping
    public List<Team> getTeams() {
        return this.teamService.getTeams();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Long id) {
        return this.teamService.getTeam(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id){
        this.teamService.deleteTeam(id);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team){
        return this.teamService.createTeam(team);
    }

    @PutMapping("{id}")
    public Team editTeam(@PathVariable Long id, @RequestBody Team team){
        return this.teamService.editTeam(id,team);
    }

}
