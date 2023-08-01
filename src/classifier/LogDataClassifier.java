package classifier;

import java.io.BufferedReader;
import java.io.IOException;

import incidentClassifier.SeverityIncidentClassifier;

public class LogDataClassifier {
    public void classifyLogData(BufferedReader reader) throws IOException {
        String line;
        SeverityIncidentClassifier incidentClassifier = new SeverityIncidentClassifier();

        while ((line = reader.readLine()) != null) {
            // Skip the header row
            if (line.startsWith("Severity")) {
                continue;
            }

            String[] fields = line.split(",");
            String severity = fields[0];

            incidentClassifier.classifyIncident(severity, line);
        }

        incidentClassifier.saveIncidentsToFile();
    }
}

