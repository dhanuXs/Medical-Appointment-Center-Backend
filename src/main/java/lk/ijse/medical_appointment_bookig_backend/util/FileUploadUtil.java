package lk.ijse.medical_appointment_bookig_backend.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Dhanujaya(Dhanu)
 * @TimeStamp 26/03/2025 16:10
 * @ProjectDetails Medical_Appoinment_System
 */
public class FileUploadUtil {
    public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get("C:\\Users\\Dhanujaya(Dhanu)\\Documents\\IJSE\\GDSE69\\ORM\\Medical_Appoinment_System\\src\\main\\resources\\static\\" + uploadDir);
        if (!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        try(InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioException){
            ioException.printStackTrace();


        }
    }
}
