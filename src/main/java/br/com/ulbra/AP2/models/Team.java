package br.com.ulbra.AP2.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private Long id;
    private String name;

    @JsonManagedReference
    private List<Player> players;

    public Team(Long id,String name ) {
        this.name = name;
        this.id = id;
        this.players = new ArrayList<>();

    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Player player){
        if(player.getTeam() != null){
            System.out.println("Jogador " + player.getName() + " já está em um time!");
            return;
        }
        players.add(player);
        player.setTeam(this);
    }
}