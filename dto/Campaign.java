package outbrain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Campaign {

        private String id;
        private String name;
        private Boolean enabled;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private Date creationTime;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private Date lastModified;


//        private String creationTime;
//        private String lastModified;

        private Double cpc;
        private Boolean autoArchived;
        private Double minimumCpc;
        private String currency;
        private Targeting targeting;
        private String marketerId;
        private List<String> feeds;
        private String contentType;
        private BudgetRetreive budget;
        private String suffixTrackingCode;
        private Object prefixTrackingCode;
        private LiveStatus liveStatus;
        private Boolean readonly;
        private String startHour; // 12:00 AM
        private List<ContentFeed> contentFeeds;
        private String onAirType;
        private String objective; // Awareness
        private String creativeFormat; // Standard
        private Boolean isDynamicRetargeting; // false

        private String budgetId;
        private TrackingPixels trackingPixels;
        private Scheduling scheduling;

        private CampaignOptimization campaignOptimization;
        private BlockedSites blockedSites;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Boolean getEnabled() {
                return enabled;
        }

        public void setEnabled(Boolean enabled) {
                this.enabled = enabled;
        }

        public Date getCreationTime() {
                return creationTime;
        }

        public void setCreationTime(Date creationTime) {
                this.creationTime = creationTime;
        }

        public Date getLastModified() {
                return lastModified;
        }

        public void setLastModified(Date lastModified) {
                this.lastModified = lastModified;
        }

        public Double getCpc() {
                return cpc;
        }

        public void setCpc(Double cpc) {
                this.cpc = cpc;
        }

        public Boolean getAutoArchived() {
                return autoArchived;
        }

        public void setAutoArchived(Boolean autoArchived) {
                this.autoArchived = autoArchived;
        }

        public Double getMinimumCpc() {
                return minimumCpc;
        }

        public void setMinimumCpc(Double minimumCpc) {
                this.minimumCpc = minimumCpc;
        }

        public String getCurrency() {
                return currency;
        }

        public void setCurrency(String currency) {
                this.currency = currency;
        }

        public Targeting getTargeting() {
                return targeting;
        }

        public void setTargeting(Targeting targeting) {
                this.targeting = targeting;
        }

        public String getMarketerId() {
                return marketerId;
        }

        public void setMarketerId(String marketerId) {
                this.marketerId = marketerId;
        }

        public List<String> getFeeds() {
                return feeds;
        }

        public void setFeeds(List<String> feeds) {
                this.feeds = feeds;
        }

        public String getContentType() {
                return contentType;
        }

        public void setContentType(String contentType) {
                this.contentType = contentType;
        }

        public BudgetRetreive getBudget() {
                return budget;
        }

        public void setBudget(BudgetRetreive budget) {
                this.budget = budget;
        }

        public String getSuffixTrackingCode() {
                return suffixTrackingCode;
        }

        public void setSuffixTrackingCode(String suffixTrackingCode) {
                this.suffixTrackingCode = suffixTrackingCode;
        }

        public Object getPrefixTrackingCode() {
                return prefixTrackingCode;
        }

        public void setPrefixTrackingCode(Object prefixTrackingCode) {
                this.prefixTrackingCode = prefixTrackingCode;
        }

        public LiveStatus getLiveStatus() {
                return liveStatus;
        }

        public void setLiveStatus(LiveStatus liveStatus) {
                this.liveStatus = liveStatus;
        }

        public Boolean getReadonly() {
                return readonly;
        }

        public void setReadonly(Boolean readonly) {
                this.readonly = readonly;
        }

        public String getStartHour() {
                return startHour;
        }

        public void setStartHour(String startHour) {
                this.startHour = startHour;
        }

        public List<ContentFeed> getContentFeeds() {
                return contentFeeds;
        }

        public void setContentFeeds(List<ContentFeed> contentFeeds) {
                this.contentFeeds = contentFeeds;
        }

        public String getOnAirType() {
                return onAirType;
        }

        public void setOnAirType(String onAirType) {
                this.onAirType = onAirType;
        }

        public String getObjective() {
                return objective;
        }

        public void setObjective(String objective) {
                this.objective = objective;
        }

        public String getCreativeFormat() {
                return creativeFormat;
        }

        public void setCreativeFormat(String creativeFormat) {
                this.creativeFormat = creativeFormat;
        }

        public Boolean getIsDynamicRetargeting() {
                return isDynamicRetargeting;
        }

        public void setDynamicRetargeting(Boolean dynamicRetargeting) {
                isDynamicRetargeting = dynamicRetargeting;
        }

        public Boolean getDynamicRetargeting() {
                return isDynamicRetargeting;
        }

        public String getBudgetId() {
                return budgetId;
        }

        public void setBudgetId(String budgetId) {
                this.budgetId = budgetId;
        }

        public TrackingPixels getTrackingPixels() {
                return trackingPixels;
        }

        public void setTrackingPixels(TrackingPixels trackingPixels) {
                this.trackingPixels = trackingPixels;
        }

        public Scheduling getScheduling() {
                return scheduling;
        }

        public void setScheduling(Scheduling scheduling) {
                this.scheduling = scheduling;
        }

        public CampaignOptimization getCampaignOptimization() {
                return campaignOptimization;
        }

        public void setCampaignOptimization(CampaignOptimization campaignOptimization) {
                this.campaignOptimization = campaignOptimization;
        }

        public BlockedSites getBlockedSites() {
                return blockedSites;
        }

        public void setBlockedSites(BlockedSites blockedSites) {
                this.blockedSites = blockedSites;
        }

//        public String getCreationTime() {
//                return creationTime;
//        }
//
//        public void setCreationTime(String creationTime) {
//                this.creationTime = creationTime;
//        }
//
//        public String getLastModified() {
//                return lastModified;
//        }
//
//        public void setLastModified(String lastModified) {
//                this.lastModified = lastModified;
//        }
}
