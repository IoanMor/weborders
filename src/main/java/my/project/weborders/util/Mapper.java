package my.project.weborders.util;

import my.project.weborders.dto.RequestFormDTO;
import my.project.weborders.entity.RequestForm;

import static my.project.weborders.util.NormalizeData.normalizePhone;

public final class Mapper {
    public static RequestForm formDTOtoEntity (RequestFormDTO dto, boolean isNew){

        RequestForm requestForm = new RequestForm();
        requestForm.setName(dto.getName());
        requestForm.setTNumber(normalizePhone(dto.getTNumber()));
        requestForm.setDescription(dto.getDescription());
        requestForm.setStatus(isNew?StatusEnum.RECEIVED:dto.getStatus());

        return requestForm;
    }
}
