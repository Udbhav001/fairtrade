package com.apex.fairtrade.company.service;

import com.apex.fairtrade.company.entity.News;
import com.apex.fairtrade.company.mapper.NewsMapper;
import com.apex.fairtrade.company.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.Map;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Value("${company.news.apiUrl}")
    String apiUrl;

    @Value("${company.news.apiKey}")
    String apiKey;

    RestClient restClient = RestClient.builder().build();

    @Autowired
    NewsRepository newsRepository;

    public News getNews(String symbol) {
        Optional<News> newsFromDB = newsRepository.findByTickerSymbol(symbol);
        return newsFromDB.orElse(null);
    }

    public News addNews(String symbol) {
        Optional<News> newsFromDB = newsRepository.findByTickerSymbol(symbol);
        if (newsFromDB.isPresent())
            return newsFromDB.get();

        String url = apiUrl + symbol + "&apikey=" + apiKey;

        Map<?, ?> newMap = restClient.get().uri(url).retrieve().body(Map.class);

        News news = null;
        if (newMap != null) {
            news = newsMapper.convert(newMap, symbol);
            newsRepository.save(news);
        }
        return news;
    }
}
