package outbrain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Targeting {

    private List<String> platform; // ["DESKTOP", "MOBILE"]
    private List<String> browsers; // Chrome
    private List<String> operatingSystems; // "MacOs", "Windows"
    private String language; // en
    private Boolean includeCellularNetwork; // en
    private Boolean excludeAdBlockUsers;
    private NativePlacements nativePlacements;
    private Boolean nativePlacementsEnabled;
    private List<String> keywords;
    private Boolean useExtendedNetworkTraffic;



    public List<String> getPlatform() {
        return platform;
    }

    public void setPlatform(List<String> platform) {
        this.platform = platform;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getIncludeCellularNetwork() {
        return includeCellularNetwork;
    }

    public void setIncludeCellularNetwork(Boolean includeCellularNetwork) {
        this.includeCellularNetwork = includeCellularNetwork;
    }

    public Boolean getExcludeAdBlockUsers() {
        return excludeAdBlockUsers;
    }

    public void setExcludeAdBlockUsers(Boolean excludeAdBlockUsers) {
        this.excludeAdBlockUsers = excludeAdBlockUsers;
    }

    public NativePlacements getNativePlacements() {
        return nativePlacements;
    }

    public void setNativePlacements(NativePlacements nativePlacements) {
        this.nativePlacements = nativePlacements;
    }

    public Boolean getNativePlacementsEnabled() {
        return nativePlacementsEnabled;
    }

    public void setNativePlacementsEnabled(Boolean nativePlacementsEnabled) {
        this.nativePlacementsEnabled = nativePlacementsEnabled;
    }

    public List<String> getBrowsers() {
        return browsers;
    }

    public void setBrowsers(List<String> browsers) {
        this.browsers = browsers;
    }

    public List<String> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(List<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Boolean getUseExtendedNetworkTraffic() {
        return useExtendedNetworkTraffic;
    }

    public void setUseExtendedNetworkTraffic(Boolean useExtendedNetworkTraffic) {
        this.useExtendedNetworkTraffic = useExtendedNetworkTraffic;
    }
}
