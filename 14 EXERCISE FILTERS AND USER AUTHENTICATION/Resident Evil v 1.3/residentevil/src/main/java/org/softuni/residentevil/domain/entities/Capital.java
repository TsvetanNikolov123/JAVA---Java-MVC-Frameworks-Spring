package org.softuni.residentevil.domain.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "capitals")
public class Capital extends BaseEntity {
    private String name;
    private Double latitude;
    private Double longitude;

    public Capital() {
    }

    @Column(name = "name", nullable = false, updatable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "latitude", nullable = false, updatable = false, columnDefinition = "Decimal(5,2)")
    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Column(name = "longitude", nullable = false, updatable = false, columnDefinition = "Decimal(5,2)")
    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
