package outbrain.dto;

import java.util.List;

public class TrackingPixels {
    private Boolean enabled;
    private List<String> urls;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
