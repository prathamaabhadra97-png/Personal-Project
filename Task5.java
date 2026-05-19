public class Task5 {
    private static final Logger logger = LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {
        try {
            if (doc == null) {
                // FIX: Use proper exception type for expected validation failure
                throw new IllegalArgumentException("Document is null");
            }
            String content = doc.extractContent();
            if (content.isEmpty()) {
                // FIX: Expected validation failure, not RuntimeException
                throw new IllegalArgumentException("Empty content");
            }
            return runValidationRules(content);
        } catch (IllegalArgumentException e) {
            // FIX: Log expected validation failures at WARN level
            logger.warn("Validation failed: {}", e.getMessage());
            return new ValidationResult(false, e.getMessage());
        } catch (Exception e) {
            // FIX: Log unexpected errors properly
            logger.error("Unexpected error during validation", e);
            return new ValidationResult(false, "Unexpected error");
        }
    }

    public void validateBatch(List<Document> docs) {
        for (Document doc : docs) {
            try {
                ValidationResult r = validate(doc);
                if (r != null && r.isValid()) {
                    saveResult(r);
                }
            } catch (Exception e) {
                // FIX:  log exceptions
                logger.error("Error validating document in batch", e);
            }
        }
    }
}