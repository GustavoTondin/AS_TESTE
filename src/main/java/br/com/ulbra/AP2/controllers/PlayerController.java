package br.com.ulbra.AP2.controllers;

import br.com.ulbra.AP2.models.Player;
import br.com.ulbra.AP2.services.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(){
        return this.playerService.getPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Long id){
        return this.playerService.getPlayer(id);
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player){
        return this.playerService.createPlayer(player);
    }

    @DeleteMapping("{id}")
    public void deletePlayer(@PathVariable Long id){
        this.playerService.deletePlayer(id);
    }

    @PutMapping("{id}")
    public Player editPlayer(@PathVariable Long id, @RequestBody Player player){
        return this.playerService.editPlayer(id, player);
    }

    @PutMapping("/{playerId}/team/{teamId}")
    public Player assignTeamToPlayer(@PathVariable Long playerId, @PathVariable Long teamId) {
        return playerService.assignTeamToPlayer(playerId, teamId);
    }



}
