package com.translate.FranceTranslate.confi;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.FileInputStream;
import java.io.IOException;


/*
    author: Nehal Ansari
*/

@Configuration
public class TranslationConfig {

    @Bean
    public Translate translate() throws IOException {
        // service account key file
        FileInputStream serviceAccountStream = new FileInputStream("Write file Name from google Cloud Api");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccountStream);

        // translation service with the loaded credentials
        TranslateOptions translateOptions = TranslateOptions.newBuilder().setCredentials(credentials).build();
        return translateOptions.getService();
    }
}
