package es.uniovi.miw.travelapi.model;

import lombok.Getter;
@Getter
public enum FareType implements IFareType {

    ECONOMY("The most basic fare option available"){
        public double priceWithFare(double price){
            double disccount = 0.5;
            return Math.round((price + (price * disccount))* 100.0) /100.0;
        }
    },
    FIRST_CLASS("The most luxurious and exclusive option available") {
        @Override
        public double priceWithFare(double price) {
            double increment = 0.10;
            return Math.round((price + (price * increment))* 100.0) /100.0;
        }
    },
    BUSINESS("Offers larger and more comfortable seats, with more legroom and recline options") {
        @Override
        public double priceWithFare(double price) {
            double increment = 0.20;
            return Math.round((price + (price * increment))* 100.0) /100.0;
        }
    };

    private final String description;

    FareType(String description){
        this.description = description;
    }
}
