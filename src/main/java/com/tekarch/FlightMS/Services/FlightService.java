package com.tekarch.FlightMS.Services;

import com.tekarch.FlightMS.DTO.FlightDTO;
import java.util.List;

public interface FlightService {
    FlightDTO addFlight(FlightDTO flights);
    List<FlightDTO> getAllFlights();
    FlightDTO getFlightById(Long flightId);
    FlightDTO updateFlight(Long flights, FlightDTO updatedFlights);
    void deleteFlight(Long flightId);
}