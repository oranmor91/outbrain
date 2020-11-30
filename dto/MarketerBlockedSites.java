package outbrain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarketerBlockedSites {
    private List<BlockedPublisher> blockedPublishers;
    private List<BlockedSection> blockedSections;

    public List<BlockedPublisher> getBlockedPublishers() {
        return blockedPublishers;
    }

    public void setBlockedPublishers(List<BlockedPublisher> blockedPublishers) {
        this.blockedPublishers = blockedPublishers;
    }

    public List<BlockedSection> getBlockedSections() {
        return blockedSections;
    }

    public void setBlockedSections(List<BlockedSection> blockedSections) {
        this.blockedSections = blockedSections;
    }
}
