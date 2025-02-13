import java.util.*;
import java.time.LocalDate;

class Policy {
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

    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public LocalDate getExpiryDate() { return expiryDate; }

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
    private Map<String, Policy> hashMapPolicies = new HashMap<>();
    private TreeMap<LocalDate, Policy> treeMapPolicies = new TreeMap<>();

    public void addPolicy(Policy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        treeMapPolicies.put(policy.getExpiryDate(), policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }

    public void listPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        System.out.println("Policies Expiring Within 30 Days:");
        for (Map.Entry<LocalDate, Policy> entry : treeMapPolicies.subMap(today, threshold).entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void listPoliciesByHolder(String policyholderName) {
        System.out.println("Policies for Policyholder: " + policyholderName);
        for (Policy policy : hashMapPolicies.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                System.out.println(policy);
            }
        }
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        treeMapPolicies.headMap(today).clear();
        System.out.println("Expired policies removed.");
    }

    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(20), "Health", 1200.0));
        manager.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40), "Auto", 900.0));
        manager.addPolicy(new Policy("P1003", "Charlie", LocalDate.now().plusDays(10), "Home", 800.0));
        manager.addPolicy(new Policy("P1004", "Alice", LocalDate.now().minusDays(5), "Life", 1500.0)); // Expired

        System.out.println("Retrieve Policy by Number (P1001):");
        System.out.println(manager.getPolicyByNumber("P1001"));

        manager.listPoliciesExpiringSoon();
        manager.listPoliciesByHolder("Alice");
        manager.removeExpiredPolicies();
    }
}
