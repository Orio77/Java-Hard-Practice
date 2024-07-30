- Enhanced task 1 with clear and transparent instruction. Main focus of the task is given by the user topic
    
    - **Task**: Implement a text algorithm, such as Trie or Suffix Tree, to improve search engine query performance. Your goal is to make the search operation as efficient as possible.
    - _Potential input_: A list of words to be inserted into the Trie or Suffix Tree, and a search query. For example: `words = ['hello', 'world', 'hell', 'word', 'help', 'dog', 'cat']`, `query = 'hel'`.
    - _Desired Output_: All words that start with the search query. For example: `['hello', 'hell', 'help']`.
    - _Coach Suggestions_: Start by implementing the Trie or Suffix Tree data structure. Then, insert all the words into the data structure. Finally, implement the search operation that returns all words that start with the search query.
- Enhanced task 2 with clear and transparent instruction. Main focus of the task is given by the user topic
    
    - **Task**: Implement string manipulation techniques to enhance query understanding and relevance. This could include removing punctuation, converting to lowercase, and stemming.
    - _Potential input_: A search query. For example: `query = 'Hello, World!'`.
    - _Desired Output_: The processed search query. For example: `['hello', 'world']`.
    - _Coach Suggestions_: Use built-in string methods to remove punctuation and convert to lowercase. For stemming, you might need to use a library like NLTK.
- Enhanced task 3 with clear and transparent instruction. Main focus of the task is given by the user topic
    
    - **Task**: Implement the Rabin-Karp algorithm for efficient text search. Your goal is to find all occurrences of a pattern in a text.
    - _Potential input_: A text and a pattern. For example: `text = 'hello world', pattern = 'lo'`.
    - _Desired Output_: All starting indices of the pattern in the text. For example: `[3]`.
    - _Coach Suggestions_: The Rabin-Karp algorithm uses hashing to find the pattern in the text. Start by computing the hash of the pattern and the hash of the first window of the text. Then, slide the window through the text, updating the hash and checking for a match at each step.