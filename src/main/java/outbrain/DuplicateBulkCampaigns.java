package outbrain;

import outbrain.api.OutBrainApiImpl;
import outbrain.dto.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DuplicateBulkCampaigns {

    public static void main(String[] args) {
        //TODO: (1) Choose account
        String account = Marketer.OTHER_ACCOUNT;

        //TODO (2) Choose the last duplication date
        List<String> lastDuplicationDates = Arrays.asList("2020-12-02");

        //TODO (3) Choose the start dates for the new campaigns
        List<String> newCampaignForDates = Collections.singletonList("2020-12-03");

        OutBrainApiImpl outBrainApi = new OutBrainApiImpl(Token.TARZO_TOKEN, account, newCampaignForDates, lastDuplicationDates);
        List<Campaign> newCampaigns = outBrainApi.duplicateCampaigns();
        System.out.println("created " + newCampaigns.size() + " campaigns for account: " + account);
        newCampaigns.forEach(newCampaign -> System.out.println(newCampaign.getName()));
    }
}
