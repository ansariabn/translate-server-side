package com.translate.FranceTranslate.translateController;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.translate.FranceTranslate.model.FranceTranslateRequest;
import com.translate.FranceTranslate.response.FranceTranslateResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/*
    author: Nehal Ansari
*/

@CrossOrigin("http://localhost:3000")
@RestController
public class FranceController {

    private final Translate translate;

    public FranceController(Translate translate) {
        this.translate = translate;
    }

    @PostMapping("/translate")
        public FranceTranslateResponse translateText(@RequestBody FranceTranslateRequest request) {
            if (request == null || request.getText() == null || request.getText().isEmpty()) {
                throw new IllegalArgumentException("kindly provide proper text");
            }

            // make account in google cloud and take apikey from
        Translate tran = TranslateOptions.newBuilder().setApiKey("add key").build().getService();

            Translation translation = tran.translate(
                    request.getText(),
                    Translate.TranslateOption.targetLanguage("fr"));

            return new FranceTranslateResponse(translation.getTranslatedText());
        }

    }
