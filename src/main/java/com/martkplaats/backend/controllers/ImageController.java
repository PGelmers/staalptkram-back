package com.martkplaats.backend.controllers;

import com.martkplaats.backend.model.Image;
import com.martkplaats.backend.model.Product;
import com.martkplaats.backend.repositories.ImageRepository;
import com.martkplaats.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "image")
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/upload")
    public Integer uploadImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("productID") Integer productID) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        Image img = new Image(file.getOriginalFilename(), file.getContentType(),
                file.getBytes());
        Image returnImage = imageRepository.save(img);
        Optional<Product> optionalProductToUpdate = productRepository.findById(productID);
        if (optionalProductToUpdate.isPresent()) {
            Product productToUpdate = optionalProductToUpdate.get();
            productToUpdate.addImage(returnImage);
            productRepository.save(productToUpdate);
        } else {
            System.out.println("DIT IS NIET GOED!");
        }
        return productID;
    }

    @GetMapping(path = {"/get/{imageID}"})
    public Image getImage(@PathVariable("imageID") long imageID) throws IOException {
        final Optional<Image> retrievedImage = imageRepository.findById(imageID);
        Image img = new Image(retrievedImage.get().getName(), retrievedImage.get().getType(),
                retrievedImage.get().getPicByte());
        return img;
    }
//    public static byte[] compressBytes(byte[] data) {
//        Deflater deflater = new Deflater();
//        deflater.setInput(data);
//        deflater.finish();
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//        byte[] buffer = new byte[1024];
//        while (!deflater.finished()) {
//            int count = deflater.deflate(buffer);
//            outputStream.write(buffer, 0, count);
//        }
//        try {
//            outputStream.close();
//        } catch (IOException e) {
//        }
//        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
//        return outputStream.toByteArray();
//    }    // uncompress the image bytes before returning it to the angular application
//
//    public static byte[] decompressBytes(byte[] data) {
//        Inflater inflater = new Inflater();
//        inflater.setInput(data);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//        byte[] buffer = new byte[1024];
//        try {
//            while (!inflater.finished()) {
//                int count = inflater.inflate(buffer);
//                outputStream.write(buffer, 0, count);
//            }
//            outputStream.close();
//        } catch (IOException ioe) {
//        } catch (DataFormatException e) {
//        }
//        return outputStream.toByteArray();
//    }
}
