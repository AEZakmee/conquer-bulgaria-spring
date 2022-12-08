package com.conquer.bulgaria.service;


import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseService {

    @PostConstruct
    public void initializeFirebaseApp() throws IOException {
        InputStream serviceAccount = this.getClass().getResourceAsStream("/firebase_config.json");

        assert serviceAccount != null;
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
    }

}
