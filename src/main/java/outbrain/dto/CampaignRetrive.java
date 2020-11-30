package outbrain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignRetrive extends Campaign {

        private TargetingRetrive targeting;

        private int autoExpirationOfAds;

        public TargetingRetrive getTargeting() {
                return targeting;
        }

        public void setTargeting(TargetingRetrive targeting) {
                this.targeting = targeting;
        }

        public int getAutoExpirationOfAds() {
                return autoExpirationOfAds;
        }

        public void setAutoExpirationOfAds(int autoExpirationOfAds) {
                this.autoExpirationOfAds = autoExpirationOfAds;
        }

}
