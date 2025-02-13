import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCountMap = new HashMap<>();  // Stores votes for candidates
    private Map<String, Integer> voteOrderMap = new LinkedHashMap<>(); // Maintains order of voting
    private TreeMap<String, Integer> sortedVoteMap = new TreeMap<>(); // Displays results in sorted order

    // Method to cast a vote
    public void castVote(String candidate) {
        // HashMap for quick vote updates
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);

        // LinkedHashMap to maintain order of votes
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);

        // TreeMap to store votes in sorted order
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }

    // Display votes in the order they were cast
    public void displayVotesInOrder() {
        System.out.println("\nVotes in Order of Casting:");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display results sorted by candidate name
    public void displaySortedResults() {
        System.out.println("\nSorted Voting Results (Alphabetically):");
        for (Map.Entry<String, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display the winner(s)
    public void displayWinner() {
        int maxVotes = Collections.max(voteCountMap.values());
        System.out.println("\nWinner(s):");
        for (Map.Entry<String, Integer> entry : voteCountMap.entrySet()) {
            if (entry.getValue() == maxVotes) {
                System.out.println(entry.getKey() + " with " + entry.getValue() + " votes");
            }
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Casting votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        // Display results
        votingSystem.displayVotesInOrder();
        votingSystem.displaySortedResults();
        votingSystem.displayWinner();
    }
}
