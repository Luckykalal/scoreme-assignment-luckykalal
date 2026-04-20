import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Document {
    public String extractContent() { return ""; }
}

class ValidationResult {
    private boolean valid;
    private String message;

    public ValidationResult(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValid() { return valid; }
}

public class Task5 {

    private static final Logger logger = LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {
        try {
            if (doc == null) {
                return new ValidationResult(false, "Document is null");
            }

            String content = doc.extractContent();

            if (content == null || content.isEmpty()) {
                return new ValidationResult(false, "Empty content");
            }

            return new ValidationResult(true, "Valid");

        } catch (Exception e) {
            logger.error("Unexpected error during validation", e);
            throw e; // FIX
        }
    }

    public void validateBatch(List<Document> docs) {
        for (Document doc : docs) {
            try {
                ValidationResult r = validate(doc);

                if (r != null && r.isValid()) {
                    System.out.println("Valid document");
                }

            } catch (Exception e) {
                logger.error("Error processing document", e);
            }
        }
    }
}
