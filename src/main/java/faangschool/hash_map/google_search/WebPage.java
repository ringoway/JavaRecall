package faangschool.hash_map.google_search;

import faangschool.hash_map.cache_cache.WeatherData;

import java.util.Objects;

public class WebPage {
    private String url;
    private String title;
    private String content;


    public WebPage(String url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        WebPage webPage = (WebPage) obj;
        return Objects.equals(url, webPage.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
    @Override
    public String toString() {
        return "WebPage{" + '\n' +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
