package outbrain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromotedLink {

    private String id;
    private String text;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModified;
    private String url;
    private String siteName;
    private String sectionName;
    private String status;
    private Boolean enabled;
    private String cachedImageUrl;
    private String campaignId;
    private Boolean archived;
    private String documentLanguage;
    private OnAirStatus onAirStatus;
    private String baseUrl;
    private String documentId;
    private ApprovalStatus approvalStatus;
    private String imageType;
    private String language;
    private OutBrainImageMetadata imageMetadata;


    // TODO CHECK
    private String imageUrl;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getCachedImageUrl() {
        return cachedImageUrl;
    }

    public void setCachedImageUrl(String cachedImageUrl) {
        this.cachedImageUrl = cachedImageUrl;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getDocumentLanguage() {
        return documentLanguage;
    }

    public void setDocumentLanguage(String documentLanguage) {
        this.documentLanguage = documentLanguage;
    }

    public OnAirStatus getOnAirStatus() {
        return onAirStatus;
    }

    public void setOnAirStatus(OnAirStatus onAirStatus) {
        this.onAirStatus = onAirStatus;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public OutBrainImageMetadata getImageMetadata() {
        return imageMetadata;
    }

    public void setImageMetadata(OutBrainImageMetadata imageMetadata) {
        OutBrainImageMetadata imageMetadata1 = new OutBrainImageMetadata();
        imageMetadata1.setUrl(imageMetadata.getUrl());
        imageMetadata1.setId(imageMetadata.getId());
        imageMetadata1.setOriginalImageUrl(imageMetadata1.getOriginalImageUrl());
        imageMetadata1.setRequestedImageUrl(imageMetadata1.getRequestedImageUrl());
        imageMetadata1.setType(imageMetadata1.getType());
        this.imageMetadata = imageMetadata1;
    }
}




