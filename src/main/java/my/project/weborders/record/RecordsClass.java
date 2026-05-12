package my.project.weborders.record;

import java.util.List;

public record RecordsClass() {
    public record ServiceItemRecord (String service, String price){};
}
