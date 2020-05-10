package com.dp.viking.domain.dto;

public class TrainingInfoDto {
    private String trainingSkill;
    private Long nrOfRegistred;
    private Double avgPrice;

    public String getTrainingSkill() {
        return trainingSkill;
    }

    public void setTrainingSkill(String trainingSkill) {
        this.trainingSkill = trainingSkill;
    }

    public Long getNrOfRegistred() {
        return nrOfRegistred;
    }

    public void setNrOfRegistred(Long nrOfRegistred) {
        this.nrOfRegistred = nrOfRegistred;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public TrainingInfoDto(String trainingSkill, Long nrOfRegistred, Double avgPrice) {
        this.trainingSkill = trainingSkill;
        this.nrOfRegistred = nrOfRegistred;
        this.avgPrice = avgPrice;
    }

    @Override
    public String toString() {
        return "TrainingForecastDto{" +
                "trainingSkill='" + trainingSkill + '\'' +
                ", nrOfRegistred=" + nrOfRegistred +
                ", avgPrice=" + avgPrice +
                '}';
    }
}
