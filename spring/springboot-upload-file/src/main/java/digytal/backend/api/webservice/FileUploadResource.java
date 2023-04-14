package digytal.backend.api.webservice;

import digytal.backend.api.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/upload-file")
public class FileUploadResource {
    @Autowired
    private FileUploadService service;
    @PostMapping(path = "/save-on-disk", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String saveOnDisk(@RequestPart("file") MultipartFile uploadFile) {
        try {
            File newFile= service.saveOnDisk(uploadFile);
            return newFile.getAbsolutePath();
        } catch (Exception e) {
            //TODO: Refectory Exception Handler
            e.printStackTrace();
            return null;
        }
    }
}
