package com.control.demo.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Passenger {
    @Id
    private UUID idPassanger;
    private UUID boardingPassId;
    private String passportControlCheck;
    private String customsControlCheck;
    private String preFlightCheck;

    public Passenger() {
    }

    public UUID getPassangerId() {
        return idPassanger;
    }


    public void setCustomsControlCheck(String customsControlCheck) {
        this.customsControlCheck = customsControlCheck;
    }

    public void setPassportControlCheck(String passportControlCheck) {
        this.passportControlCheck = passportControlCheck;
    }

    public void setPreFlightCheck(String preFlightCheck) {
        this.preFlightCheck = preFlightCheck;
    }
}
