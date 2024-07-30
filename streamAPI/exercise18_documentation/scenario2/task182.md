Task 1

Given a list of academic papers, each represented as a `Paper` object with properties `title`, `authors`, `year`, `citations`, and `keywords` (a list of strings), implement the following methods:

1. `findTrendingPapers(List<Paper> papers, int year, int topN)`: This method should return the top N papers with the most citations published since the given year. The papers should be returned in descending order of citations. Use Stream API to filter, map, sort, and limit the operations.
    
2. `findGapInResearch(List<Paper> papers, String keyword)`: This method should return a list of years where no papers were published on a given keyword. Assume that years are represented as integers and span from 2000 to 2022.
    

Example:

List<Paper> papers = Arrays.asList(

    new Paper("Title1", Arrays.asList("Author1", "Author2"), 2020, 50, Arrays.asList("AI", "ML")),

    new Paper("Title2", Arrays.asList("Author3", "Author4"), 2021, 100, Arrays.asList("AI", "DL")),

    // more papers...

);

findTrendingPapers(papers, 2020, 2);

// Returns: [Paper("Title2", ..., 100, ...), Paper("Title1", ..., 50, ...)]

findGapInResearch(papers, "DL");

// Returns: [2000, 2001, 2002, ..., 2020]

Task 2 (Topic: Stream Collectors)

Given the same `Paper` object and list of papers, implement the following methods:

1. `groupPapersByYear(List<Paper> papers)`: This method should return a map where each key is a year and the value is a list of papers published in that year.
    
2. `countPapersByKeyword(List<Paper> papers)`: This method should return a map where each key is a keyword and the value is the number of papers that include that keyword in their keywords list.
    

Example:

groupPapersByYear(papers);

// Returns: {2020: [Paper("Title1", ...), ...], 2021: [Paper("Title2", ...), ...], ...}

countPapersByKeyword(papers);

// Returns: {"AI": 2, "ML": 1, "DL": 1, ...}

Task 3 (Topic: Parallel Stream)

Implement the following methods:

1. `findMostFrequentAuthors(List<Paper> papers)`: This method should return a list of authors sorted by the number of papers they have authored. The author who has authored the most papers should be first in the list. If two authors have authored the same number of papers, they should be ordered alphabetically.
    
2. `findMostCitedPapers(List<Paper> papers, int topN)`: This method should return the top N papers with the most citations. The papers should be returned in descending order of citations. This method should use parallel streams to improve performance.
    

Example:

findMostFrequentAuthors(papers);

// Returns: ["Author3", "Author1", "Author2", "Author4"]

findMostCitedPapers(papers, 2);

// Returns: [Paper("Title2", ..., 100, ...), Paper("Title1", ..., 50, ...)]

Task 4 (Topic: Optional)

Implement the following methods:

1. `findPaperByTitle(List<Paper> papers, String title)`: This method should return an Optional that contains the Paper with the given title if it exists, or an empty Optional if it does not.
    
2. `getFirstAuthor(List<Paper> papers, String title)`: This method should return an Optional that contains the first author of the Paper with the given title if it exists, or an empty Optional if it does not.
    
3. `getKeywords(List<Paper> papers, String title)`: This method should return an Optional that contains the list of keywords of the Paper with the given title if it exists, or an empty Optional if it does not.
    

Example:

findPaperByTitle(papers, "Title1");

// Returns: Optional[Paper("Title1", ...)]

getFirstAuthor(papers, "Title1");

// Returns: Optional["Author1"]

getKeywords(papers, "Title1");

// Returns: Optional[["AI", "ML"]]