package outbrain;

import outbrain.api.OutBrainApiImpl;
import outbrain.dto.Campaign;
import outbrain.dto.Marketer;
import outbrain.dto.Token;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DuplicateCampaign {

    public static void main(String[] args) {

        //TODO: (1) Choose account
        String account = Marketer.ENGLISH_ACCOUNT;

        //TODO (2) Choose the last duplication date
        String campaignId = "00b33e0c9a46357a59429ab380fd6b5a87";

        //TODO (3) Choose the start dates for the new campaigns
        List<String> newCampaignForDates = Arrays.asList("2020-12-01"/*, "2020-11-30"*/);


        OutBrainApiImpl outBrainApi = new OutBrainApiImpl(Token.TARZO_TOKEN, account, campaignId, newCampaignForDates);
        List<Campaign> newCampaigns = outBrainApi.duplicateCampaigns();
        System.out.println(newCampaigns);
    }
}
