package com.dp.viking.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(TrainingRatingID.class)
@Table(name = "training_register")
public class TrainingRating  implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "trainingID")
    private Training training;

    @Id
    @ManyToOne
    @JoinColumn(name = "personID")
    private User user;

    private Short rating;

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }
}
