package com.zerobase.scraper;

import com.zerobase.dto.CompanyDto;
import com.zerobase.dto.ScrapedResult;

public interface Scraper {
    CompanyDto scrapCompanyByTicker(String ticker);
    ScrapedResult scrap(CompanyDto company);
}
