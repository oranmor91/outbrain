package outbrain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignCreate extends Campaign {

        private TargetingCreate targeting;

        public TargetingCreate getTargeting() {
                return targeting;
        }

        public void setTargeting(TargetingCreate targeting) {
                this.targeting = targeting;
        }
}
