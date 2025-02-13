import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManager {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Policies (HashSet): " + hashSetPolicies);
        System.out.println("All Policies (LinkedHashSet): " + linkedHashSetPolicies);
        System.out.println("All Policies (TreeSet - Sorted by Expiry): " + treeSetPolicies);
    }

    public void displayExpiringSoon() {
        LocalDate today = LocalDate.now();
        System.out.println("Policies Expiring Soon:");
        for (Policy policy : treeSetPolicies) {
            if (ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30) {
                System.out.println(policy);
            }
        }
    }

    public void displayByCoverageType(String coverageType) {
        System.out.println("Policies with Coverage Type: " + coverageType);
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        Set<String> uniquePolicyNumbers = new HashSet<>();
        System.out.println("Duplicate Policies:");
        for (Policy policy : hashSetPolicies) {
            if (!uniquePolicyNumbers.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    public void comparePerformance() {
        int testSize = 10000;
        List<Policy> testPolicies = new ArrayList<>();
        for (int i = 0; i < testSize; i++) {
            testPolicies.add(new Policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i), "Auto", 500.0 + i));
        }

        long start, end;

        // HashSet Performance
        start = System.nanoTime();
        Set<Policy> hashSet = new HashSet<>(testPolicies);
        end = System.nanoTime();
        System.out.println("HashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        hashSet.contains(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        hashSet.remove(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("HashSet Remove Time: " + (end - start) + " ns");

        // LinkedHashSet Performance
        start = System.nanoTime();
        Set<Policy> linkedHashSet = new LinkedHashSet<>(testPolicies);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSet.contains(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSet.remove(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Remove Time: " + (end - start) + " ns");

        // TreeSet Performance
        start = System.nanoTime();
        Set<Policy> treeSet = new TreeSet<>(testPolicies);
        end = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.contains(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.remove(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("TreeSet Remove Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(20), "Health", 1200.0));
        manager.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40), "Auto", 900.0));
        manager.addPolicy(new Policy("P1003", "Charlie", LocalDate.now().plusDays(10), "Home", 800.0));
        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(20), "Health", 1200.0)); // Duplicate

        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayByCoverageType("Health");
        manager.findDuplicatePolicies();
        manager.comparePerformance();
    }
}
