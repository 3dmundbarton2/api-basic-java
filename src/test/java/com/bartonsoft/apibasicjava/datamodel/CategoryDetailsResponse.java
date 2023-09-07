package com.bartonsoft.apibasicjava.datamodel;

import java.util.List;

public class CategoryDetailsResponse
{
    public int CategoryId;
    public String Name;
    public String Path;
    public Boolean CanListAuctions;
    public Boolean CanListClassifieds;
    public Boolean CanRelist;
    public int DefaultDuration;
    public List<Integer> AllowedDurations;
    public Fees Fees;
    public int FreePhotoCount;
    public int MaximumPhotoCount;
    public List<Charity> Charities;
    public List<Promotion> Promotions;
    public List<Object> EmbeddedContentOptions;
    public int MaximumTitleLength;
    public int AreaOfBusiness;
    public int DefaultRelistDuration;
    public Boolean CanHaveSecondCategory;
    public Boolean CanBeSecondCategory;
    public Boolean CanUseCounterOffers;
}







