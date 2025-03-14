package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.repository.*;

@RestController
@RequestMapping("/api/ad")
public class AdController {

    @Autowired
    private AdServices adServices;

    @Autowired
    private UserService userServices;

    @Autowired
    private AdRepository adRepository; // Assuming you have an AdRepository to save the Ad to the database

    @CrossOrigin(origins = {"https://productify.live", "https://www.productify.live"})
    @PostMapping("/postAd")
    public ResponseEntity<Map<String, String>> postAd(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("price") String price,
            @RequestParam("location") String location,
            @RequestParam("phoneNo") String phoneNo,
            @RequestParam("userId") Long userId,
            @RequestParam("isFeatured") boolean isFeatured,
            @RequestPart(required = false) MultipartFile image1,
            @RequestPart(required = false) MultipartFile image2,
            @RequestPart(required = false) MultipartFile image3,
            @RequestPart(required = false) MultipartFile image4) throws IOException {

        // Log details

        return adServices.postAd(isFeatured ,title, description, price, location, phoneNo, userId, image1, image2, image3, image4);

    }

    @CrossOrigin(origins = {"https://productify.live", "https://www.productify.live"})
    @GetMapping("/getAllAds")
    public List<Ad> getAllAds() {
        return adServices.getAllAds();
    }

    @CrossOrigin(origins = {"https://productify.live", "https://www.productify.live"})
    @GetMapping("/getAdsById")
    public List<Ad> getAdsById(@RequestParam Long user_id) {
        return adServices.getAdsByUserId(user_id);
    }

    @CrossOrigin(origins = {"https://productify.live", "https://www.productify.live"})
    @DeleteMapping("/deleteAd")
    public ResponseEntity<String> deleteAd(@RequestParam("userId") Long userId, @RequestParam("ad_id") Long adId) {
        try {
            String result = adServices.deleteAd(userId, adId); // Assuming this service returns a success message.
            return ResponseEntity.ok(result); // Return 200 OK with the success message.
        } catch (Exception e) {
            // Log the exception for debugging
            System.err.println("Error deleting ad: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete ad.");
        }
    }

    @CrossOrigin(origins = {"https://productify.live", "https://www.productify.live"})
    @PutMapping("/editAd")
    public ResponseEntity<Map<String, String>> editAd(
            @RequestParam("ad_id") Long ad_id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("price") String price,
            @RequestParam("location") String location,
            @RequestParam("phoneNo") String phoneNo,
            @RequestParam("userId") Long userId,
            @RequestPart(required = false) MultipartFile image1,
            @RequestPart(required = false) MultipartFile image2,
            @RequestPart(required = false) MultipartFile image3,
            @RequestPart(required = false) MultipartFile image4) throws IOException {

        // Log details

        return adServices.editAd(ad_id, title, description, price, location, phoneNo, userId, image1, image2, image3,
                image4);

    }
    @CrossOrigin(origins = {"https://productify.live", "https://www.productify.live"})
    @GetMapping("/checkFeatureAvailability")
    public boolean checkFeatureAvailability(@RequestParam Long userId) {
        return adServices.checkFeatureAvailability(userId);
    }
    
    

}
