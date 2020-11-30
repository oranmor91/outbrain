package outbrain.dto;

import java.util.List;

public class PromotedLinks {

    private List<PromotedLink> promotedLinks;
    private int totalCount;
    private int count;

    public List<PromotedLink> getPromotedLinks() {
        return promotedLinks;
    }

    public void setPromotedLinks(List<PromotedLink> promotedLinks) {
        this.promotedLinks = promotedLinks;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
