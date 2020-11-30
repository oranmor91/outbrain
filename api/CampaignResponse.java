package outbrain.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import outbrain.dto.Campaign;
import outbrain.dto.CampaignRetrive;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignResponse {
    private int count;
    private List<CampaignRetrive> campaigns;
    private int totalCount;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CampaignRetrive> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignRetrive> campaigns) {
        this.campaigns = campaigns;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
