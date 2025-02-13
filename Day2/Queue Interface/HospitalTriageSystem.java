import java.util.PriorityQueue;
import java.util.Comparator;

class Patient {
    String name;
    int severity;

    // Constructor to initialize name and severity
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {
        // Create a priority queue with a custom comparator to order by severity (descending)
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                // Compare by severity in descending order
                return Integer.compare(p2.severity, p1.severity);
            }
        });

        // Add patients to the queue
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        // Process patients in order of severity (highest severity first)
        System.out.println("Patient treatment order based on severity:");
        while (!triageQueue.isEmpty()) {
            Patient nextPatient = triageQueue.remove();
            System.out.println(nextPatient);
        }
    }
}
