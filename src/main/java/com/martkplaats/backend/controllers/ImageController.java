package com.martkplaats.backend.controllers;

import com.martkplaats.backend.model.Image;
import com.martkplaats.backend.model.Product;
import com.martkplaats.backend.repositories.ImageRepository;
import com.martkplaats.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

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

}
