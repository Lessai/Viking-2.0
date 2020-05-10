package com.dp.viking.domain.dto;

import com.dp.viking.domain.Training;

import java.util.Date;

public class TrainingDto {

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
    private Long registers;
    private Boolean meRegistred;
    private Boolean isRegistrationOpen;
    private Boolean isFinished;
    private Short myScore;

    public TrainingDto(Training training, Long registers, Boolean meRegistred, Boolean isRegistrationOpen, Boolean isFinished, Short myScore) {
        this.trainingID = training.getTrainingID();
        this.trainingName = training.getTrainingName();
        this.trainingDesc = training.getTrainingDesc();
        this.trainingCateg = training.getTrainingCateg();
        this.trainingSkill = training.getTrainingSkill();
        this.trainingCondType = training.getTrainingCondType();
        this.trainingType = training.getTrainingType();
        this.trainingCapacity = training.getTrainingCapacity();
        this.trainingStartDt = training.getTrainingStartDt();
        this.trainingEndDate = training.getTrainingEndDate();
        this.trainingNrOfSessions = training.getTrainingNrOfSessions();
        this.trainingPrice = training.getTrainingPrice();
        this.picturePath = training.getPicturePath();
        this.registers = registers;
        this.meRegistred = meRegistred;
        this.isRegistrationOpen = isRegistrationOpen;
        this.isFinished = isFinished;
        this.myScore = myScore;
    }

    public Short getMyScore() {
        return myScore;
    }

    public void setMyScore(Short myScore) {
        this.myScore = myScore;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public Long getRegisters() {
        return registers;
    }

    public void setRegisters(Long registers) {
        this.registers = registers;
    }

    public Boolean getRegistrationOpen() {
        return isRegistrationOpen;
    }

    public void setRegistrationOpen(Boolean registrationOpen) {
        isRegistrationOpen = registrationOpen;
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

    public Long getRedisters() {
        return registers;
    }

    public void setRedisters(Long redisters) {
        this.registers = redisters;
    }

    public Boolean getMeRegistred() {
        return meRegistred;
    }

    public void setMeRegistred(Boolean meRegistred) {
        this.meRegistred = meRegistred;
    }

    @Override
    public String toString() {
        return "TrainingDto{" +
                "trainingID=" + trainingID +
                ", trainingName='" + trainingName + '\'' +
                ", trainingDesc='" + trainingDesc + '\'' +
                ", trainingCateg='" + trainingCateg + '\'' +
                ", trainingSkill='" + trainingSkill + '\'' +
                ", trainingCondType='" + trainingCondType + '\'' +
                ", trainingType='" + trainingType + '\'' +
                ", trainingCapacity=" + trainingCapacity +
                ", trainingStartDt=" + trainingStartDt +
                ", trainingEndDate=" + trainingEndDate +
                ", trainingNrOfSessions=" + trainingNrOfSessions +
                ", trainingPrice=" + trainingPrice +
                ", picturePath='" + picturePath + '\'' +
                ", registers=" + registers +
                ", meRegistred=" + meRegistred +
                ", isRegistrationOpen=" + isRegistrationOpen +
                ", isFinished=" + isFinished +
                ", myScore=" + myScore +
                '}';
    }
}
