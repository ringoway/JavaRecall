package faangschool.hash_map.google_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static HashMap<String, List<WebPage>> webSearch = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage = new WebPage("https://www.faang.school/java-bootcamp/", "Author's Java bootcamp",
                "Bootcamp is an intensive training format through hard work on a project in a team. The main goal is to give each participant the closest possible experience to real life, so that you feel at home at work and receive respect from your colleagues. We have adapted development practices from BigTech companies, implemented advanced development tools from the industry and organized work according to the flexible Scrum methodology. To ensure that there is enough knowledge for this work, we offer lectures, Q&A sessions and workshops, as well as constant support from tech leads in the chat.");
        WebPage webPage1 = new WebPage("https://elbrusboot.camp/", "GET THIS PROFESSION AND CHANGE YOUR LIFE",
                "Bootcamp - This is an intensive format of programming training (daily, from morning to evening, for three months on campus and four in online format) on real projects with employment after training");
        WebPage webPage2 = new WebPage("https://practicum.yandex.ru/catalog/bootcamp/", "Bootcamps almost everywhere there is a free part",
                "Bootcamp are intensive crash courses designed to quickly and efficiently master new skills and knowledge. Our programs are designed for those who want to get results quickly and efficiently. We offer courses in the areas of Data Analysis, Data Scientist, Python Developer, System Analyst. Our experienced teachers will help you learn new skills and give advice on further development.");

        indexingWebPage(webPage);
        indexingWebPage(webPage1);
        indexingWebPage(webPage2);

        System.out.println(searchWebPage("Bootcamp"));

        removeWebPage(webPage1);

        System.out.println(searchWebPage("Bootcamp"));
    }
    public static void indexingWebPage (WebPage webPage) {
        List<String> keywords = List.of(webPage.getContent().split("[\\s,.()]+")); //список слов content - WebPage's
        Set<String> processedKeywords = new HashSet<>(); //это если вдуг будут повторятся слова в content
        for (String s : keywords) {
            if (!processedKeywords.contains(s)) {
                processedKeywords.add(s);

                List<WebPage> webPages = webSearch.get(s);

                if (webPages == null) {
                    webPages = new ArrayList<>();
                    webSearch.put(s, webPages);
                }

                if (!webPages.contains(webPage)) {
                    webPages.add(webPage);
                }
            }
        }
    }
    public static List<WebPage> searchWebPage(String keyword) {
        List<WebPage> webPages = webSearch.get(keyword);
        if (webPages == null) {
            return new ArrayList<>();
        } else {
            return webPages;
        }
    }
    public static void removeWebPage (WebPage webPage) { // не смог понять
        webSearch.remove(webPage);
    }
}
