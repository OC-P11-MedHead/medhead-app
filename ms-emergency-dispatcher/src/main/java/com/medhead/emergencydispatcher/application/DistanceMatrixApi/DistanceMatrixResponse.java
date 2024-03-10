package com.medhead.emergencydispatcher.application.DistanceMatrixApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DistanceMatrixResponse {
    
    public Map<Integer, String> idCoordinateMap;

    @JsonProperty("destination_addresses")
    private List<String> destinationAddresses;

    @JsonProperty("status")
    private String status;

    @JsonProperty("rows")
    private List<Row> rows;

    // Classe interne représentant une "rangée" dans la matrice
    @Data
    public static class Row {

        @JsonProperty("elements")
        private List<Element> elements;

        // Classe interne représentant un "élément" dans la rangée
        @Data
        public static class Element {

            @JsonProperty("status")
            private String status;

            @JsonProperty("distance")
            private Distance distance;

            @JsonProperty("duration")
            private Duration duration;

            // Classe interne représentant la distance
            @Data
            public static class Distance {
                @JsonProperty("text")
                private String text;

                @JsonProperty("value")
                private long value;
            }

            // Classe interne représentant la durée
            @Data
            public static class Duration {
                @JsonProperty("text")
                private String text;

                @JsonProperty("value")
                private long value;
            }
        }
    }
}

