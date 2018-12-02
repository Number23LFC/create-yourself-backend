package pl.mgk.hubertrybarczyk.createyourself.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "isDone")
    private boolean isDone;

    @ManyToOne
    @JoinColumn(name = "objective_id")
    @JsonIgnore
    private Objective objective;

    public Todo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }
}
