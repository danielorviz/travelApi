package es.uniovi.miw.travelapi.service.amadeus.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.uniovi.miw.travelapi.service.amadeus.AmadeusAuthenticationService;
import es.uniovi.miw.travelapi.service.amadeus.AmadeusFlightsService;
import es.uniovi.miw.travelapi.service.amadeus.dto.airport.AFlightAirportDto;
import es.uniovi.miw.travelapi.service.amadeus.dto.fligthsearch.AFlightSearchDto;
import es.uniovi.miw.travelapi.service.flight.dto.SearchFlightDto;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AmadeusFlightsServiceImpl implements AmadeusFlightsService {

    @Value("${amadeus.api.url.airport.search}")
    private String searchAirportUrl;

    @Value("${amadeus.api.url.flight.search}")
    private String searchFlightsUrl;

    @Autowired
    private AmadeusAuthenticationService amadeusAuthenticationService;


    @Override
    public List<AFlightAirportDto> searchAirports(String countryCode, String searchKeyWord){
        String token = this.amadeusAuthenticationService.refreshAccessToken();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(this.searchAirportUrl).newBuilder();

        urlBuilder.addQueryParameter("subType", "AIRPORT");
        urlBuilder.addQueryParameter("keyword", searchKeyWord);
        urlBuilder.addQueryParameter("countryCode", countryCode);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .header("Authorization", "Bearer " + token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();

            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonNode = mapper.readTree(responseBody);
            String data = jsonNode.get("data").toString();
            List<AFlightAirportDto> locationList = mapper.readValue(data, new TypeReference<List<AFlightAirportDto>>() {});
            return new ArrayList<>(locationList);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AFlightSearchDto> searchFlights(SearchFlightDto searchFlightDto){
        String token = this.amadeusAuthenticationService.refreshAccessToken();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(this.searchFlightsUrl).newBuilder();

        urlBuilder.addQueryParameter("originLocationCode", searchFlightDto.getIataCodeOrigin());
        urlBuilder.addQueryParameter("destinationLocationCode", searchFlightDto.getIataCodeDestination());
        urlBuilder.addQueryParameter("departureDate", searchFlightDto.getDepartureDate());
        urlBuilder.addQueryParameter("returnDate", searchFlightDto.getReturnDate());
        urlBuilder.addQueryParameter("adults", String.valueOf(searchFlightDto.getAdults()));
        urlBuilder.addQueryParameter("max", String.valueOf(searchFlightDto.getMaxResults()));

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .header("Authorization", "Bearer " + token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();

            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonNode = mapper.readTree(responseBody);
            String data = jsonNode.get("data").toString();
            List<AFlightSearchDto> locationList = mapper.readValue(data, new TypeReference<List<AFlightSearchDto>>() {});
            return new ArrayList<>(locationList);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }


}
