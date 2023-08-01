package processor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import classifier.LogDataClassifier;

public class LogDataProcessor {
    public static void main(String[] args) {
        String inputFile = "C:/Users/asisamda/Documents/log_data.csv";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            LogDataClassifier classifier = new LogDataClassifier();
            classifier.classifyLogData(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
