package com.dp.viking.domain;

import com.dp.viking.domain.employee.Employee;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*CREATE TABLE viking_oltp.training
		(
		trainingID bigint not null Primary KEY
		,trainingName varchar(250)
        ,trainingDesc varchar(500)
        ,trainingCateg varchar(250)
        ,trainingSkill varchar(250)
        ,trainingCondType varchar(50)
        ,trainingType varchar(50)
        ,trainingCapacity int
        ,trainingStartDt date
        ,trainingEndDate date
        ,trainingNrOfSessions int
        ,trainingPrice double
		);*/
@Entity
@Table(name = "training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainingID;
    private  String trainingName;
    private String trainingDesc;
    private String trainingCateg;
    private String trainingSkill;
    private String trainingCondType;
    private String trainingType;
    private Integer trainingCapacity;
    private Date trainingStartDt;
    private Date trainingEndDate;
    private Integer trainingNrOfSessions;
    private Double trainingPrice;
    private String picturePath;

    @ManyToMany
    @JoinTable(
            name = "training_register",
            joinColumns = {@JoinColumn(name = "trainingID")},
            inverseJoinColumns = {@JoinColumn(name = "personID")}
    )
    private Set<User> register = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "training_likes",
            joinColumns = {@JoinColumn(name = "trainingID")},
            inverseJoinColumns = {@JoinColumn(name = "personID")}
    )
    private Set<User> likes = new HashSet<>();

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TrainingRating> trainingRatings;

    public Training() {
    }

    public Long getTrainingID() {
        return trainingID;
    }

    public void setTrainingID(Long trainingID) {
        this.trainingID = trainingID;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingDesc() {
        return trainingDesc;
    }

    public void setTrainingDesc(String trainingDesc) {
        this.trainingDesc = trainingDesc;
    }

    public String getTrainingCateg() {
        return trainingCateg;
    }

    public void setTrainingCateg(String trainingCateg) {
        this.trainingCateg = trainingCateg;
    }

    public String getTrainingSkill() {
        return trainingSkill;
    }

    public void setTrainingSkill(String trainingSkill) {
        this.trainingSkill = trainingSkill;
    }

    public String getTrainingCondType() {
        return trainingCondType;
    }

    public void setTrainingCondType(String trainingCondType) {
        this.trainingCondType = trainingCondType;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public Integer getTrainingCapacity() {
        return trainingCapacity;
    }

    public void setTrainingCapacity(Integer trainingCapacity) {
        this.trainingCapacity = trainingCapacity;
    }

    public Date getTrainingStartDt() {
        return trainingStartDt;
    }

    public void setTrainingStartDt(Date trainingStartDt) {
        this.trainingStartDt = trainingStartDt;
    }

    public Date getTrainingEndDate() {
        return trainingEndDate;
    }

    public void setTrainingEndDate(Date trainingEndDate) {
        this.trainingEndDate = trainingEndDate;
    }

    public Integer getTrainingNrOfSessions() {
        return trainingNrOfSessions;
    }

    public void setTrainingNrOfSessions(Integer trainingNrOfSessions) {
        this.trainingNrOfSessions = trainingNrOfSessions;
    }

    public Double getTrainingPrice() {
        return trainingPrice;
    }

    public void setTrainingPrice(Double trainingPrice) {
        this.trainingPrice = trainingPrice;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Set<User> getRegister() {
        return register;
    }

    public void setRegister(Set<User> register) {
        this.register = register;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }
}
