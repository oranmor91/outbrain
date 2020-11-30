package outbrain.api;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import outbrain.dto.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class OutBrainApiImpl implements OutBrainApi {
    private Client client;
    private ObjectMapper mapper;
    private String token;
    private String account;
    private List<CampaignRetrive> campaigns;
    private List<String> newCampaignForDates;
    private final String OB_TOKEN_V1 = "OB-TOKEN-V1";
    private String getCampaignUrl = "https://api.outbrain.com/amplify/v0.1/campaigns/";
    private Set<String> campaignNames;

    public OutBrainApiImpl(String token, String account, String campaignId, List<String> newCampaignForDates) {
        this.client = ClientBuilder.newClient();
        this.mapper = new ObjectMapper();
        this.token = token;
        this.account = account;
        this.campaigns = Collections.singletonList(getCampaign(campaignId));
        this.newCampaignForDates = newCampaignForDates;
        this.campaignNames = new HashSet<>();
    }

    public OutBrainApiImpl(String token, String account, List<String> newCampaignForDates, List<String> lastDuplicationDates) {
        this.client = ClientBuilder.newClient();
        this.mapper = new ObjectMapper();
        this.token = token;
        this.account = account;
        this.campaigns = new ArrayList<>();
        this.campaignNames = new HashSet<>();
        for (String lastDuplicationDate : lastDuplicationDates) {
            CampaignsByDate campaignsByDate = getCampaignsByDate(lastDuplicationDate);
            this.campaigns.addAll(campaignsByDate.getRelevantCampaigns());
            this.campaignNames.addAll(campaignsByDate.getCampaignNames());
        }
        this.newCampaignForDates = newCampaignForDates;
    }

    private CampaignsByDate getCampaignsByDate(String lastDuplicationDate) {
        List<CampaignRetrive> allCampaigns = new ArrayList<>();
        int offset = 0;
        CampaignResponse campaignResponse = getCampaignsResponse(offset);
        allCampaigns.addAll(campaignResponse.getCampaigns());
        offset += campaignResponse.getCount();
        int totalCount = campaignResponse.getTotalCount();

        while (offset < totalCount){
            CampaignResponse response = getCampaignsResponse(offset);
            allCampaigns.addAll(response.getCampaigns());
            offset += campaignResponse.getCount();
        }

        Set<String> campaignNames = allCampaigns.stream().map(Campaign::getName).collect(Collectors.toSet());

        List<CampaignRetrive> relevantCampaigns =
                allCampaigns.stream()
                        .filter(campaignRetrive -> getDateByString(campaignRetrive.getBudget().getStartDate()).equals(lastDuplicationDate) &&
                                !campaignRetrive.getLiveStatus().getOnAirReason().equals("CAMPAIGN_DISABLED") &&
                                !campaignRetrive.getLiveStatus().getOnAirReason().equals("PAUSED"))
                        .collect(Collectors.toList());

        CampaignsByDate campaignsByDate = new CampaignsByDate(campaignNames, relevantCampaigns);
        return campaignsByDate;
    }

    private CampaignResponse getCampaignsResponse(int offset) {
        String getCampaignsByAccountUrl = "https://api.outbrain.com/amplify/v0.1/marketers/" + account + "/campaigns" +
                "?includeArchived=true&fetch=all&extraFields=Locations%2CCampaignOptimization&limit=50&offset=";
        Response response = client.target(getCampaignsByAccountUrl + offset)
                .request(MediaType.APPLICATION_JSON)
                .header("OB-TOKEN-V1", token)
                .get();

        String campaignsInJsonString = response.readEntity(String.class);
        CampaignResponse campaignResponse = null;
        try {
            campaignResponse = mapper.readValue(campaignsInJsonString, CampaignResponse.class);
        } catch (IOException e) {
            System.out.println("error to get campaign: " + e + " " +"campaignsInJsonString:" +  campaignsInJsonString);
        }
        return campaignResponse;
    }

    private String getDateByString(Date campaignDate) {
        String pattern = "yyyy-MM-dd";

        DateFormat df = new SimpleDateFormat(pattern);

        return df.format(campaignDate);
    }

    private CampaignRetrive getCampaign(String campaignId) {

        Response response = client.target(getCampaignUrl+campaignId+"?extraFields=Locations"+"&CampaignOptimization")
                .request(MediaType.APPLICATION_JSON)
                .header(OB_TOKEN_V1, token)
                .get();

        String campaignInJsonString = response.readEntity(String.class);
        CampaignRetrive campaign = null;
        try {
            campaign = mapper.readValue(campaignInJsonString, CampaignRetrive.class);
        } catch (IOException e) {
            System.out.println("error to get campaign: " + e + " " +"campaignInJsonString:" +  campaignInJsonString);
        }
        return campaign;
    }

    private Budget createBudget(Double amount, String pacing, String type, String newCampaignDate) {
        BudgetCreate budgetCreate = new BudgetCreate();
        String budgetName = UUID.randomUUID().toString().replace("-", "");
        budgetCreate.setName(budgetName);
        budgetCreate.setRunForever(true);

        budgetCreate.setAmount(amount);
        budgetCreate.setStartDate(newCampaignDate);
        budgetCreate.setPacing(pacing);
        budgetCreate.setType(type);


        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
             json = ow.writeValueAsString(budgetCreate);
        } catch (IOException e) {
            System.out.println("error to get budgetCreate: " + e + " " +"budgetCreate:" +  budgetCreate);
        }
        Entity payload = Entity.json(json);

        String createBudgetUrl = "https://api.outbrain.com/amplify/v0.1/marketers/" + account + "/budgets?detachedOnly=detachedOnly";
        Response response = client.target(createBudgetUrl)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(OB_TOKEN_V1, token)
                .post(payload);
        String budgetInJsonString = response.readEntity(String.class);
        BudgetRetreive budget = null;
        try {
            budget = mapper.readValue(budgetInJsonString, BudgetRetreive.class);
        } catch (IOException e) {
            System.out.println("error to get budget: " + e + " " +"budgetInJsonString:" +  budgetInJsonString);
        }
        return budget;
    }

    private PromotedLinks getPromotedLinks(String campaignId){
        String getPromotedLinksUrlTerms = "/promotedLinks?enabled=true&limit=100&offset=0&sort=-creationTime&promotedLinkImageWidth=100&promotedLinkImageHeight=100&extraFields=ImageMetaData";
        Response response = client.target(getCampaignUrl+campaignId+getPromotedLinksUrlTerms)
                .request(MediaType.APPLICATION_JSON)
                .header(OB_TOKEN_V1, token)
                .get();

        String promotedLinksInJsonString = response.readEntity(String.class);
        PromotedLinks promotedLinks = null;
        try {
            promotedLinks = mapper.readValue(promotedLinksInJsonString, PromotedLinks.class);
        } catch (IOException e) {
            System.out.println("error to get promotedLinks: " + e + " " +"promotedLinksInJsonString:" +  promotedLinksInJsonString);
        }
        return promotedLinks;
    }

    private CampaignRetrive createCampaign(CampaignRetrive otherCampaign, int countName, String newCampaignDate){
        CampaignCreate campaign = new CampaignCreate();
        Targeting originalTargeting = otherCampaign.getTargeting();

        TargetingCreate targeting = createTargeting((TargetingRetrive) originalTargeting);

        List<String> feeds = otherCampaign.getFeeds();
        Budget budget = createBudget(otherCampaign.getBudget().getAmount(),
                 otherCampaign.getBudget().getPacing(), otherCampaign.getBudget().getType(), newCampaignDate);
        campaign.setBudgetId(budget.getId());
        String newName = createNewName(otherCampaign.getName(), countName);
        campaign.setName(newName);
        campaign.setEnabled(otherCampaign.getEnabled());
        campaign.setCpc(otherCampaign.getCpc());
        campaign.setTargeting(targeting);
        campaign.setSuffixTrackingCode(createSuffixTrackingCode(otherCampaign.getName(), otherCampaign.getSuffixTrackingCode(), newName));
        campaign.setFeeds(feeds);
        campaign.setOnAirType(otherCampaign.getOnAirType());
        campaign.setObjective(otherCampaign.getObjective());


        campaign.setCampaignOptimization(otherCampaign.getCampaignOptimization());

        campaign.setCreativeFormat(otherCampaign.getCreativeFormat());

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(campaign);
        } catch (IOException e) {
            System.out.println("error to get campaign: " + e + " " +"campaign:" +  campaign);
        }
        Entity<String> payload = Entity.json(json);
        String createCampaignUrl = "https://api.outbrain.com/amplify/v0.1/campaigns";
        Response response = client.target(createCampaignUrl+"?extraFields=Locations")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(OB_TOKEN_V1, token)
                .post(payload);
        String campaigntInJsonString = response.readEntity(String.class);
        CampaignRetrive campaignRetreive = null;
        try {
            campaignRetreive = mapper.readValue(campaigntInJsonString, CampaignRetrive.class);
        } catch (IOException e) {
            System.out.println("error to get campaign: " + e + " " +"campaigntInJsonString:" +  campaigntInJsonString);
        }
        return campaignRetreive;
    }

    private String createSuffixTrackingCode(String currentCampaignName, String currentSuffixTrackingCode, String newName) {
        int firstIndex = currentSuffixTrackingCode.indexOf(currentCampaignName);
        int lastCharIndex = firstIndex + currentCampaignName.length();
        return currentSuffixTrackingCode.substring(0, firstIndex) + newName + currentSuffixTrackingCode.substring(lastCharIndex);
    }

    public String createNewName(String currentName , int countName) {
        int newNumber;
        int currentNumber = 0;
        int numOfDigit = getNumOfDigit(currentName);
        String substring = currentName.substring(0, currentName.length() - numOfDigit);
        if (numOfDigit == 0){
            substring += "*";
        }else{
            try {
                currentNumber = Integer.parseInt(currentName.substring(currentName.length() - numOfDigit));
            } catch (NumberFormatException e) {
                System.out.println("error int name ..." + e);
            }
        }
        newNumber = currentNumber + countName;
        String newName = substring + newNumber;
        int anotherCount = 1;
        while (campaignNames.contains(newName)){
            int number = newNumber + anotherCount;
            newName = substring + number;
            anotherCount ++;
        }
        campaignNames.add(newName);
        return newName;
    }

    private int getNumOfDigit(String currentName) {
        int numOfDigit = 1;
        while (numOfDigit <= 5){
            String lastChar = currentName.substring(currentName.length() - numOfDigit, currentName.length() - numOfDigit + 1);
            try {
                Integer.parseInt(lastChar);
            } catch (NumberFormatException e) {
                return numOfDigit - 1;
            }
            if (lastChar.equals("*")){
                return numOfDigit - 1;
            }
            numOfDigit++;
        }

        return 0;
    }

    private PromotedLink createPromotedLink(String campaignId, PromotedLink otherPromotedLink){

        PromotedLink promotedLink = new PromotedLink();
        promotedLink.setText(otherPromotedLink.getText());
        String newUrl = extractUrl(otherPromotedLink.getUrl());
        promotedLink.setUrl(newUrl);
        promotedLink.setSectionName(otherPromotedLink.getSectionName());
        promotedLink.setEnabled(otherPromotedLink.getEnabled());
        OutBrainImageMetadata imageMetadata = new OutBrainImageMetadata();
        imageMetadata.setUrl(otherPromotedLink.getCachedImageUrl());
        imageMetadata.setRequestedImageUrl(otherPromotedLink.getCachedImageUrl());
        imageMetadata.setOriginalImageUrl(otherPromotedLink.getCachedImageUrl());

        promotedLink.setImageMetadata(imageMetadata);


        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(promotedLink);
        } catch (IOException e) {
            System.out.println("error to get promotedLinks: " + e + " " +"promotedLink:" +  promotedLink);
        }
        Entity payload = Entity.json(json);
        String createPromotedLinkUrl = "https://api.outbrain.com/amplify/v0.1/campaigns/" + campaignId + "/promotedLinks";
        Response response = client.target(createPromotedLinkUrl)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(OB_TOKEN_V1, token)
                .post(payload);
        String promotedLinkInJsonString = response.readEntity(String.class);
        PromotedLink prmotdLink = null;
        try {
            prmotdLink = mapper.readValue(promotedLinkInJsonString, PromotedLink.class);
        } catch (IOException e) {
            System.out.println("error to get promotedLinks: " + e + " " +"promotedLinksInJsonString:" +  promotedLinkInJsonString);
        }
        return prmotdLink;
    }

    private String extractUrl(String url) {
        int i = url.indexOf("?");
        return url.substring(0, i);
    }

    private TargetingCreate createTargeting(TargetingRetrive originTargeting) {

        List<Location> locations1 = originTargeting.getLocations();
        String id = locations1.get(0).getId();

        TargetingCreate targeting = new TargetingCreate();
        targeting.setPlatform(originTargeting.getPlatform());

        targeting.setBrowsers(originTargeting.getBrowsers());

        List<String> locations = Collections.singletonList(id);
        targeting.setLocations(locations);

        targeting.setOperatingSystems(originTargeting.getOperatingSystems());

        targeting.setExcludeAdBlockUsers(originTargeting.getExcludeAdBlockUsers());
        return targeting;
    }

    private Campaign duplicateCampaign(CampaignRetrive currentCampaign, int countName, String newCampaignDate){
        PromotedLinks promotedLinks = getPromotedLinks(currentCampaign.getId());
        Campaign newCampaign = createCampaign(currentCampaign, countName, newCampaignDate);
        for (PromotedLink promotedLink : promotedLinks.getPromotedLinks()) {
            createPromotedLink(newCampaign.getId(), promotedLink);
        }
        return newCampaign;
    }

    public List<Campaign> duplicateCampaigns(){
        String pattern = "HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date startTime = new Date();
        String startTimeString = df.format(startTime);
        System.out.println("Start duplication at " + startTimeString);
        System.out.println("----------------------------------------");
        List<Campaign> newCampaigns = new ArrayList<>();
        int numOfDuplication = 1;
        for (CampaignRetrive originalCampaign : campaigns) {
            int countName = 1;
            for (String newCampaignDate : newCampaignForDates) {
                Campaign campaign = duplicateCampaign(originalCampaign, countName, newCampaignDate);
                Date now = new Date();
                String time = df.format(now);
                System.out.println("(" + numOfDuplication + ")" + " Created campaign: " + campaign.getName() + " ,creation time: " + time);
                numOfDuplication ++;
                countName ++;
                newCampaigns.add(campaign);
            }
        }
        return newCampaigns;
    }
}



