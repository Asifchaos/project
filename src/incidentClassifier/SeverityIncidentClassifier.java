package incidentClassifier;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeverityIncidentClassifier {
    private List<String> highSeverityIncidents = new ArrayList<>();
    private List<String> mediumSeverityIncidents = new ArrayList<>();
    private List<String> lowSeverityIncidents = new ArrayList<>();

    public void classifyIncident(String severity, String incident) {
        if (severity.equalsIgnoreCase("High")) {
            highSeverityIncidents.add(incident);
        } else if (severity.equalsIgnoreCase("Medium")) {
            mediumSeverityIncidents.add(incident);
        } else if (severity.equalsIgnoreCase("Low")) {
            // Perform the respective solution for Low severity incidents here
            // For this example, we will just add it to the list
            lowSeverityIncidents.add(incident);
        }
    }

    public void saveIncidentsToFile() throws IOException {
        saveToFile(highSeverityIncidents, "high_severity_incidents.csv");
        saveToFile(mediumSeverityIncidents, "medium_severity_incidents.csv");
        saveToFile(lowSeverityIncidents, "low_severity_incidents.csv");
    }

    private void saveToFile(List<String> incidents, String outputFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write("Severity,Description,Timestamp,Server Location");
        writer.newLine();

        for (String incident : incidents) {
            writer.write(incident);
            writer.newLine();
        }

        writer.close();
    }
}

