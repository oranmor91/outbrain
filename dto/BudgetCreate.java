package outbrain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BudgetCreate extends Budget {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String startDate; // "2020-11-09"
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String endDate; // "2020-11-09"

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
