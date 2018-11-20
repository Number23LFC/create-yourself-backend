package pl.mgk.hubertrybarczyk.createyourself.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "celebration")
public class Celebration extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    public Celebration() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
