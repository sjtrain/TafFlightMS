package com.tekarch.FlightMS.Services.Impl;


import com.tekarch.FlightMS.DTO.FlightDTO;
import com.tekarch.FlightMS.Services.FlightService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {


    private final RestTemplate restTemplate;
    private final String datastoreServiceUrl;

    public FlightServiceImpl(RestTemplate restTemplate, @Value("${datastore.service.url}") String datastoreServiceUrl) {
        this.restTemplate = restTemplate;
        this.datastoreServiceUrl = datastoreServiceUrl;
    }

    @Override
    public FlightDTO addFlight(FlightDTO flights) {
        return restTemplate.postForObject(datastoreServiceUrl, flights, FlightDTO.class);
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        FlightDTO[] flightsArray = restTemplate.getForObject(datastoreServiceUrl, FlightDTO[].class);
        return Arrays.asList(flightsArray);
    }

    @Override
    public FlightDTO getFlightById(Long flightId) {
        return restTemplate.getForObject(datastoreServiceUrl + "/" + flightId, FlightDTO.class);
    }

    @Override
    public FlightDTO updateFlight(Long flights, FlightDTO updatedFlights) {
        restTemplate.put(datastoreServiceUrl + "/" + flights, updatedFlights);
        return updatedFlights;
    }

    @Override
    public void deleteFlight(Long flightId) {
        restTemplate.delete(datastoreServiceUrl + "/" + flightId);
    }
}
