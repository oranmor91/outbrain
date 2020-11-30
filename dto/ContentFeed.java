package outbrain.dto;

public class ContentFeed {
    private String url;
    private String syncType; // "AddOnly"

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSyncType() {
        return syncType;
    }

    public void setSyncType(String syncType) {
        this.syncType = syncType;
    }
}
