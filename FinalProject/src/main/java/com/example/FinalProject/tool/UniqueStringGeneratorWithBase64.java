package com.example.FinalProject.tool;

import java.util.UUID;
import java.util.Base64;

public class UniqueStringGeneratorWithBase64 {
    public static String generateUniqueString() {
        UUID uuid = UUID.randomUUID();
        return Base64.getUrlEncoder().withoutPadding().encodeToString(uuid.toString().getBytes()).substring(0, 16);
    }

}
