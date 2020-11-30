package outbrain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Schedule {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String startDay;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String endDay;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer startHour;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer endHour;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double cpcAdjustment;

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    public Double getCpcAdjustment() {
        return cpcAdjustment;
    }

    public void setCpcAdjustment(Double cpcAdjustment) {
        this.cpcAdjustment = cpcAdjustment;
    }
}
