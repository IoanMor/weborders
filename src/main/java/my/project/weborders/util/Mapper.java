package my.project.weborders.util;

import my.project.weborders.dto.RequestFormDTO;
import my.project.weborders.entity.RequestForm;

import static my.project.weborders.util.NormalizeData.normalizePhone;

public final class Mapper {
    public static RequestForm formDTOtoEntity (RequestFormDTO dto){

        RequestForm requestForm = new RequestForm();
        requestForm.setName(dto.getName());
        requestForm.setTNumber(normalizePhone(dto.getTNumber()));
        requestForm.setDescription(dto.getDescription());

        return requestForm;
    }
}
