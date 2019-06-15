package pl.mgk.hubertrybarczyk.createyourself.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "isDone")
    @JsonProperty
    private boolean isDone;


    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
