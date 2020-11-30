package outbrain.api;

import outbrain.dto.CampaignRetrive;

import java.util.List;
import java.util.Set;

public class CampaignsByDate {
    private Set<String> campaignNames;
    private List<CampaignRetrive> relevantCampaigns;

    public CampaignsByDate(Set<String> campaignNames, List<CampaignRetrive> relevantCampaigns) {
        this.campaignNames = campaignNames;
        this.relevantCampaigns = relevantCampaigns;
    }

    public Set<String> getCampaignNames() {
        return campaignNames;
    }

    public void setCampaignNames(Set<String> campaignNames) {
        this.campaignNames = campaignNames;
    }

    public List<CampaignRetrive> getRelevantCampaigns() {
        return relevantCampaigns;
    }

    public void setRelevantCampaigns(List<CampaignRetrive> relevantCampaigns) {
        this.relevantCampaigns = relevantCampaigns;
    }
}
