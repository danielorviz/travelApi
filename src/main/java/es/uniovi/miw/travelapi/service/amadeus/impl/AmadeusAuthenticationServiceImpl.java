package es.uniovi.miw.travelapi.service.amadeus.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.uniovi.miw.travelapi.service.amadeus.AmadeusAuthenticationService;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AmadeusAuthenticationServiceImpl implements AmadeusAuthenticationService {

    @Value("${amadeus.client.id}")
    private String clientId;

    @Value("${amadeus.client.secret}")
    private String clientSecret;

    @Value("${amadeus.api.url.authentication}")
    private String authenticationUrl;

    private String authToken;

    private long expirationTimeMillis;

    @Override
    public String refreshAccessToken(){
        if(this.expirationTimeMillis > 0 && this.authToken!= null && System.currentTimeMillis()>= this.expirationTimeMillis){
            return this.authToken;
        }
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .add("client_id", this.clientId)
                .add("client_secret", this.clientSecret)
                .build();

        Request request = new Request.Builder()
                .url(this.authenticationUrl)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonNode = mapper.readTree(responseBody);

            String token = jsonNode.get("access_token").asText();
            long expires_in = jsonNode.get("expires_in").asLong();
            this.authToken = token;

            this.expirationTimeMillis = System.currentTimeMillis()+(expires_in - 10);

            return token;
        }catch(IOException e ){
            e.printStackTrace();
        }
        return null;
    }
}
