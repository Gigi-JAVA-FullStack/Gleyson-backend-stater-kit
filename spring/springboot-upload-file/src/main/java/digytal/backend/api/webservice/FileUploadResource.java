package digytal.backend.api.webservice;

import digytal.backend.api.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
    @GetMapping(path="/view",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]>  getImg() {
        try {
            byte[] image = Files.readAllBytes(Paths.get("C:\\digytal\\java-spring-framework.jpg"));

            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
