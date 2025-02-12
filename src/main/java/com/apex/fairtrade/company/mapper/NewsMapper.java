package com.apex.fairtrade.company.mapper;

import com.apex.fairtrade.company.entity.Feed;
import com.apex.fairtrade.company.entity.News;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class NewsMapper {
    public News convert(Map<?, ?> map, String symbol) {
        News news = new News();
        news.setTickerSymbol(symbol);
        List<Feed> feeds = new ArrayList<>();
        List<?> feedFromAPI = (List<?>) map.get("feed");
        for(Object obj: feedFromAPI) {
            Map<?, ?> feedMap = (Map<?, ?>) obj;
            Feed feed = new Feed();
            feed.setSummary(String.valueOf(feedMap.get("summary")));
            feed.setTitle(String.valueOf(feedMap.get("title")));
            feed.setUrl(String.valueOf(feedMap.get("url")));
            feed.setTimePublished(String.valueOf(feedMap.get("time_published")));
            feed.setAuthors((List<String>) feedMap.get("authors"));
            feeds.add(feed);
        }
        news.setFeeds(feeds);
        return news;
    }
}
