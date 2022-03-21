package ma.cu.lalewicz.examsystem.enums;

public enum Status {
    COMPLETED("Zakończony"),
    STARTED("Rozpoczęty"),
    IN_PREPARATION("W trakcie przygotowania");

    private final String statusDescription;

    Status(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getStatusDescription() {
        return statusDescription;
    }
}
