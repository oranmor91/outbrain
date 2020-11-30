package outbrain.dto;

import java.util.List;

public class Scheduling {
    private List<Schedule> cpc;
    private List<Schedule> onAir;

    public List<Schedule> getCpc() {
        return cpc;
    }

    public void setCpc(List<Schedule> cpc) {
        this.cpc = cpc;
    }

    public List<Schedule> getOnAir() {
        return onAir;
    }

    public void setOnAir(List<Schedule> onAir) {
        this.onAir = onAir;
    }
}
