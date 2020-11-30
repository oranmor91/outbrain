package outbrain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockedSites {
    private MarketerBlockedSites marketerBlockedSites;

    public MarketerBlockedSites getMarketerBlockedSites() {
        return marketerBlockedSites;
    }

    public void setMarketerBlockedSites(MarketerBlockedSites marketerBlockedSites) {
        this.marketerBlockedSites = marketerBlockedSites;
    }
}
