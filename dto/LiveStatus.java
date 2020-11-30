package outbrain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
//@JsonDeserialize(using= CustomerDateAndTimeDeserialize.class)
public class LiveStatus {

    private String onAirReason; // "CAMPAIGN_DISABLED"
    private Boolean campaignOnAir;
    private Double amountSpent;
    public void setOnAirReason(String onAirReason) {
        this.onAirReason = onAirReason;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date onAirModificationTime; // "2020-11-09 14:43:41"

    public Boolean getCampaignOnAir() {
        return campaignOnAir;
    }

    public void setCampaignOnAir(Boolean campaignOnAir) {
        this.campaignOnAir = campaignOnAir;
    }

    public Double getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(Double amountSpent) {
        this.amountSpent = amountSpent;
    }

    public Date getOnAirModificationTime() {
        return onAirModificationTime;
    }

    public void setOnAirModificationTime(Date onAirModificationTime) {
        this.onAirModificationTime = onAirModificationTime;
    }

    public String getOnAirReason() {
        return onAirReason;
    }
}
