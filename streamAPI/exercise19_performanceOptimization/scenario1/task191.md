Task 1

You are given a list of `Claim` objects. Each `Claim` has a `complexity` (int), `urgency` (int), and `amount` (double).

1. Implement a method `filterAndSortClaims` that filters claims with complexity greater than a given threshold and urgency less than a given threshold, then sorts the remaining claims by amount in descending order. The method should return a list of claims.
    
2. Implement a method `calculateTotalAmount` that calculates the total amount of claims that have complexity less than a given threshold and urgency greater than a given threshold. The method should return the total amount as a double.
    

Example:

Input: List of Claims: [{complexity: 5, urgency: 3, amount: 1000}, {complexity: 2, urgency: 7, amount: 500}, {complexity: 4, urgency: 1, amount: 2000}, {complexity: 3, urgency: 6, amount: 1500}] Complexity Threshold for `filterAndSortClaims`: 4 Urgency Threshold for `filterAndSortClaims`: 2 Complexity Threshold for `calculateTotalAmount`: 3 Urgency Threshold for `calculateTotalAmount`: 5

Output: `filterAndSortClaims`: [{complexity: 4, urgency: 1, amount: 2000}] `calculateTotalAmount`: 1500

Task 2 (Topic: Stream Performance)

1. Implement a method `findMostUrgentClaims` that finds the top N claims with the highest urgency using a parallel stream. The method should return a list of claims.
    
2. Implement a method `findLeastComplexClaims` that finds the bottom N claims with the lowest complexity using a parallel stream. The method should return a list of claims.
    

Example:

Input: List of Claims: [{complexity: 5, urgency: 3, amount: 1000}, {complexity: 2, urgency: 7, amount: 500}, {complexity: 4, urgency: 1, amount: 2000}, {complexity: 3, urgency: 6, amount: 1500}] N for `findMostUrgentClaims`: 2 N for `findLeastComplexClaims`: 2

Output: `findMostUrgentClaims`: [{complexity: 2, urgency: 7, amount: 500}, {complexity: 3, urgency: 6, amount: 1500}] `findLeastComplexClaims`: [{complexity: 2, urgency: 7, amount: 500}, {complexity: 3, urgency: 6, amount: 1500}]

Task 3 (Topic: Optional)

1. Implement a method `findClaimWithHighestAmount` that finds the claim with the highest amount. If no claim exists, return an empty Optional. The method should return an Optional of Claim.
    
2. Implement a method `findClaimWithLowestUrgency` that finds the claim with the lowest urgency. If no claim exists, return an empty Optional. The method should return an Optional of Claim.
    

Example:

Input: List of Claims: [{complexity: 5, urgency: 3, amount: 1000}, {complexity: 2, urgency: 7, amount: 500}, {complexity: 4, urgency: 1, amount: 2000}, {complexity: 3, urgency: 6, amount: 1500}]

Output: `findClaimWithHighestAmount`: Optional[{complexity: 4, urgency: 1, amount: 2000}] `findClaimWithLowestUrgency`: Optional[{complexity: 4, urgency: 1, amount: 2000}]

Task 4 (Topic: Stream Collectors)

1. Implement a method `groupClaimsByComplexity` that groups claims by their complexity level. The method should return a Map where the key is the complexity level and the value is a list of claims.
    
2. Implement a method `groupClaimsByUrgency` that groups claims by their urgency level. The method should return a Map where the key is the urgency level and the value is a list of claims.
    
3. Implement a method `calculateAverageClaimAmount` that calculates the average claim amount for each complexity level. The method should return a Map where the key is the complexity level and the value is the average claim amount.
    

Example:

Input: List of Claims: [{complexity: 5, urgency: 3, amount: 1000}, {complexity: 2, urgency: 7, amount: 500}, {complexity: 4, urgency: 1, amount: 2000}, {complexity: 3, urgency: 6, amount: 1500}]

Output: `groupClaimsByComplexity`: {5: [{complexity: 5, urgency: 3, amount: 1000}], 2: [{complexity: 2, urgency: 7, amount: 500}], 4: [{complexity: 4, urgency: 1, amount: 2000}], 3: [{complexity: 3, urgency: 6, amount: 1500}]} `groupClaimsByUrgency`: {3: [{complexity: 5, urgency: 3, amount: 1000}], 7: [{complexity: 2, urgency: 7, amount: 500}], 1: [{complexity: 4, urgency: 1, amount: 2000}], 6: [{complexity: 3, urgency: 6, amount: 1500}]} `calculateAverageClaimAmount`: {5: 1000.0, 2: 500.0, 4: 2000.0, 3: 1500.0}