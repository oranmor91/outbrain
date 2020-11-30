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
        String campaignId = "00cdfdeb16bd6275b2e4d920c2db1694d6";

        //TODO (3) Choose the start dates for the new campaigns
        List<String> newCampaignForDates = Arrays.asList("2020-11-29", "2020-11-30");


        OutBrainApiImpl outBrainApi = new OutBrainApiImpl(Token.TARZO_TOKEN, account, campaignId, newCampaignForDates);
        List<Campaign> newCampaigns = outBrainApi.duplicateCampaigns();
        System.out.println(newCampaigns);
    }
}
