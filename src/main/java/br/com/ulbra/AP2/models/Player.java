package br.com.ulbra.AP2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Player {
    private Long id;
    private String name;

    @JsonIgnoreProperties({"players"})
    private Team team;

    public Player(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
