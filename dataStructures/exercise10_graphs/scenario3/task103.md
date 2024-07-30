==**Problem 3: Web Crawling**==
	
	**Scenario:** You are building a web crawler for a search engine. The crawler needs to visit each webpage linked from a given webpage.
	
	**Tasks:**
	
	1. **Task:** Design a graph data structure to represent the web, where each node represents a webpage and each edge represents a link.
	    - **Actionable Transparency Instructions:**
	        - Create a function to add a new webpage (node) to the web (graph).
	        - Create a function to add a new link (edge) between two webpages (nodes).
	2. **Task:** Implement a function to visit each webpage linked from a given webpage using depth-first search (DFS) or breadth-first search (BFS).
	    - **Actionable Transparency Instructions:**
	        - Create a function that accepts a webpage (node) as input and visits each linked webpage (connected node).
	        - Test the function with various webpages to ensure it works correctly.
	3. **Task:** Implement a function to find the shortest path between two webpages. This could be used to find the minimum number of clicks required to navigate from one page to another.
	    - **Actionable Transparency Instructions:**
	        - Create a function that accepts two webpages (nodes) as input and returns the shortest path (sequence of links) between them.
	        - Test the function with various pairs of webpages to ensure it works correctly.