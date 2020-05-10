package com.dp.viking.domain.dto;

public class TrainingForecastDto {
    private String trainingSkill;
    private Double lRange;
    private Double uRange;
    private Integer registrationQty;
    private Double totalCost;
    private Double totalCostK;
    private Double avgCost;
    private Double avgPrice;
    private Double registrationPerc;

    public Double getRegistrationPerc() {
        return registrationPerc;
    }

    public void setRegistrationPerc(Double registrationPerc) {
        this.registrationPerc = registrationPerc;
    }

    public Double getTotalCostK() {
        return totalCostK;
    }

    public void setTotalCostK(Double totalCostK) {
        this.totalCostK = totalCostK;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Double getAvgCost() {
        return avgCost;
    }

    public void setAvgCost(Double avgCost) {
        this.avgCost = avgCost;
    }

    public String getTrainingSkill() {
        return trainingSkill;
    }

    public void setTrainingSkill(String trainingSkill) {
        this.trainingSkill = trainingSkill;
    }

    public Double getlRange() {
        return lRange;
    }

    public void setlRange(Double lRange) {
        this.lRange = lRange;
    }

    public Double getuRange() {
        return uRange;
    }

    public void setuRange(Double uRange) {
        this.uRange = uRange;
    }

    public Integer getRegistrationQty() {
        return registrationQty;
    }

    public void setRegistrationQty(Integer registrationQty) {
        this.registrationQty = registrationQty;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public TrainingForecastDto(String trainingSkill, Double lRange, Double uRange, Integer registrationQty, Double totalCost, Double avgPrice) {
        this.trainingSkill = trainingSkill;
        this.lRange = lRange;
        this.uRange = uRange;
        this.registrationQty = registrationQty;
        this.totalCost = totalCost;
        this.avgPrice = avgPrice;
    }

    public TrainingForecastDto(String trainingSkill, Double lRange, Double uRange, Double avgPrice) {
        this.trainingSkill = trainingSkill;
        this.lRange = lRange;
        this.uRange = uRange;
        this.avgPrice = avgPrice;
    }

    @Override
    public String toString() {
        return "TrainingForecastDto{" +
                "trainingSkill='" + trainingSkill + '\'' +
                ", lRange=" + lRange +
                ", uRange=" + uRange +
                ", registrationQty=" + registrationQty +
                ", totalCost=" + totalCost +
                ", totalCostK=" + totalCostK +
                ", avgCost=" + avgCost +
                ", avgPrice=" + avgPrice +
                ", registrationPerc=" + registrationPerc +
                '}';
    }
}

