package outbrain.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignOptimization {

    private String optimizationType;
    private String maxCpcBidPercentage;
    private List<String> conversions;
    private Boolean experimentEnabled;
    private Double controlGroupPercentage;

    public String getOptimizationType() {
        return optimizationType;
    }

    public void setOptimizationType(String optimizationType) {
        this.optimizationType = optimizationType;
    }

    public String getMaxCpcBidPercentage() {
        return maxCpcBidPercentage;
    }

    public void setMaxCpcBidPercentage(String maxCpcBidPercentage) {
        this.maxCpcBidPercentage = maxCpcBidPercentage;
    }

    public List<String> getConversions() {
        return conversions;
    }

    public void setConversions(List<String> conversions) {
        this.conversions = conversions;
    }

    public Boolean getExperimentEnabled() {
        return experimentEnabled;
    }

    public void setExperimentEnabled(Boolean experimentEnabled) {
        this.experimentEnabled = experimentEnabled;
    }

    public Double getControlGroupPercentage() {
        return controlGroupPercentage;
    }

    public void setControlGroupPercentage(Double controlGroupPercentage) {
        this.controlGroupPercentage = controlGroupPercentage;
    }
}
