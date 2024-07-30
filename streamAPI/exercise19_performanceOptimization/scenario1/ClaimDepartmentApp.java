package streamAPI.exercise19_performanceOptimization.scenario1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClaimDepartmentApp {
    
    public List<Claim> filterAndSortClaims(List<Claim> claims, int complexityThreshold, int urgencyThreshold) {
        return claims.stream().filter(claim -> claim.getComplexity() > complexityThreshold && claim.getUrgency() > urgencyThreshold).sorted(Comparator.comparing(Claim::getAmount)).toList();
    }

    public double calculateTotalAmount(List<Claim> claims, int complexityThreshold, int urgencyThreshold) {
        return claims.stream().filter(claim -> claim.getUrgency() < urgencyThreshold && claim.getComplexity() < complexityThreshold).mapToDouble(Claim::getAmount).sum();
    }

    public List<Claim> findMostUrgentClaims(List<Claim> claims, int n) {
        return claims.stream().sorted(Comparator.comparing(Claim::getUrgency)).limit(n).toList();
    }

    public List<Claim> findLeastComplexClaims(List<Claim> claims, int n) {
        return claims.stream().sorted(Comparator.comparing(Claim::getComplexity).reversed()).limit(n).toList();
    }

    public Optional<Claim> findClaimWithHighestAmount(List<Claim> claims) {
        return claims.stream().max(Comparator.comparing(Claim::getAmount));
    }

    public Optional<Claim> findClaimWithLowestUrgency(List<Claim> claims) {
        return claims.stream().min(Comparator.comparing(Claim::getUrgency));
    }

    public Map<Integer, List<Claim>> groupClaimsByComplexity(List<Claim> claims) {
        return claims.stream().collect(Collectors.groupingBy(Claim::getComplexity));
    }

    public Map<Integer, List<Claim>> groupClaimsByUrgency(List<Claim> claims) {
        return claims.stream().collect(Collectors.groupingBy(Claim::getUrgency));
    }

    public Map<Integer, Double> calculateAverageClaimAmount(List<Claim> claims) {
        return claims.stream().collect(Collectors.groupingBy(Claim::getComplexity, Collectors.averagingDouble(Claim::getAmount))).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
