package streamAPI.exercise18_documentation.scenario2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PaperAnalysisApp {
    

    public List<Paper> findTrendingPapers(List<Paper> papers, int year, int topN) {

        return papers.stream().filter(paper -> paper.getYear() >= year).sorted(Comparator.comparing(Paper::getCitations)).limit(topN).toList();
    }

    public List<Integer> findGapInResearch(List<Paper> papers, String keyword) {

        List<Integer> gapList = new ArrayList<>();

        for (int i = 0; i <= 22; i++) {
            gapList.add(2000 + i);
        }

        papers.stream().filter(paper -> paper.getKeywords().contains(keyword)).map(Paper::getYear).forEach(year -> {
            if (gapList.contains(year)) {
                gapList.remove(year);
            }
        });

        return gapList;
    }

    public Map<Integer, List<Paper>> groupPapersByYear(List<Paper> papers) {
        return papers.stream().collect(Collectors.groupingBy(Paper::getYear));
    }

    public Map<String, Long> countPapersByKeyword(List<Paper> papers) {
        return papers.stream().flatMap(paper -> paper.getKeywords().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<String> findMostFrequentAuthors(List<Paper> papers) {
        return papers.stream().flatMap(paper -> paper.getAuthors().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().thenComparing(Map.Entry.<String, Long>comparingByKey(Comparator.naturalOrder()))).map(Map.Entry::getKey).toList();
    }

    public List<Paper> findMostCitedPapers(List<Paper> papers, int topN) {
        return papers.stream().sorted(Comparator.comparing(Paper::getCitations)).limit(topN).toList();
    }

    public Optional<Paper> findPaperByTitle(List<Paper> papers, String title) {
        return papers.stream().filter(paper -> paper.getTitle().matches(title)).findFirst();
    }

    public Optional<String> getFirstAuthor(List<Paper> papers, String title) {
        return papers.stream().filter(paper -> paper.getTitle().matches(title)).flatMap(paper -> paper.getAuthors().stream()).findFirst();
    }

    public Optional<List<String>> getKeywords(List<Paper> papers, String title) {
        return papers.stream().filter(paper -> paper.getTitle().matches(title)).map(paper -> paper.getKeywords()).findFirst();
    }
}
