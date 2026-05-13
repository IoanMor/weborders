package my.project.weborders.util;

public enum StatusEnum {
    RECEIVED("ПОЛУЧЕНА"),
    ACCEPTED("ПРИНЯТА"),
    AT_WORK("В РАБОТЕ"),
    COMPLETED("ВЫПОЛНЕНА");

    private final String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "StatusEnum{" +
                "status='" + status + '\'' +
                '}';
    }
}
