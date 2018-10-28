/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.read.repository.strategy;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author kuuhaku
 */
public enum EventStrategy {

    ARRIVED("es.example.event.ArrivedShipEvent") {
        @Override
        public void apply(JsonObject shipJson, JsonObject event) {
            shipJson.addProperty("port", event.get("port").getAsString());
        }
    },
    DEPARTURED("es.example.event.DeparturedShipEvent") {
        @Override
        public void apply(JsonObject shipJson, JsonObject event) {
            shipJson.addProperty("port", event.get("port").getAsString());
        }
    },
    SHIPCREATED("es.example.event.ShipCreatedEvent") {
        @Override
        public void apply(JsonObject shipJson, JsonObject event) {
            shipJson.addProperty("shipId", event.get("shipId").getAsInt());
            shipJson.addProperty("name", event.get("name").getAsString());
            shipJson.addProperty("port", event.get("port").getAsString());
            shipJson.add("cargos", new JsonArray());
        }
    },
    CARGOLOADED("es.example.event.CargoLoadedEvent") {
        @Override
        public void apply(JsonObject shipJson, JsonObject event) {
            JsonArray cargos = shipJson.get("cargos").getAsJsonArray();
            cargos.add(event.get("cargo"));
            shipJson.add("cargos", cargos);
        }
    },
    CARGOUNLOADED("es.example.event.CargoUnloadedEvent") {
        @Override
        public void apply(JsonObject shipJson, JsonObject event) {
            shipJson.add("cargos", new JsonArray());
        }
    };

    private final String value;

    private EventStrategy(String value) {
        this.value = value;
    }

    public abstract void apply(JsonObject shipJson, JsonObject event);
}
