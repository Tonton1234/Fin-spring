package apii.apii.apii.Services;

import apii.apii.apii.dto.request.EtudiantRequestDto;
import org.springframework.web.multipart.MultipartFile;

public interface EtudiantRequestService extends serviceRest<EtudiantRequestDto,Long> {
     void importStudentsFromExcelFile(MultipartFile file);
}
