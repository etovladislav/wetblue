package ru.arhat.wetblue.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by etovladislav on 24.06.16.
 */
public class ImageUploadProvider {

    public String upload(MultipartFile file) {
        String newFileName = null;
        File dir = null;
        //Загрузка картинки
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                dir = new File(PropertyPath.getPath() + File.separator + "product_images");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                //генерируем имя картинке
                newFileName = UUID.randomUUID().toString() + "."
                        + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + newFileName);
                //сохраняем картинку
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                    stream.write(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "/images/product_images/" + newFileName;
    }
}
