package org.softuni.residentevil.domain.models.binding;

import org.softuni.residentevil.domain.entities.Capital;
import org.softuni.residentevil.domain.entities.enums.Creator;
import org.softuni.residentevil.domain.entities.enums.Magnitude;
import org.softuni.residentevil.domain.entities.enums.Mutation;
import org.softuni.residentevil.validation.CapitalValidator;
import org.softuni.residentevil.validation.DateBeforeTodayValidator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class VirusAddBindingModel {

    private String name;
    private String description;
    private String sideEffects;
    private Creator creator;
    private boolean deadly;
    private boolean curable;
    private Mutation mutation;
    private Integer turnoverRate;
    private Integer hoursUntilTurn;
    private Magnitude magnitude;
    private LocalDate releasedOn;
    private List<Capital> capitals;

    public VirusAddBindingModel() {
    }

    @NotNull
    @Size(min = 3, max = 10, message = "Invalid name! Name must be between 3 and 10 symbols.")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(min = 5, max = 100, message = "Invalid description! Description must be between 5 and 100 symbols.")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @Size(max = 50, message = "Invalid side effects! Should have a maximum of 50 symbols.")
    public String getSideEffects() {
        return this.sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    @NotNull(message = "Invalid creator! Should be either \"Corp\" or \"corp\".")
    public Creator getCreator() {
        return this.creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public boolean isDeadly() {
        return this.deadly;
    }

    public void setDeadly(boolean deadly) {
        this.deadly = deadly;
    }

    public boolean isCurable() {
        return this.curable;
    }

    public void setCurable(boolean curable) {
        this.curable = curable;
    }

    @NotNull(message = "Mutation cannot be null! You must select one of the above fields.")
    public Mutation getMutation() {
        return this.mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    @NotNull(message = "Must be a number, between 0 and 100")
    @Min(value = 0)
    @Max(value = 100)
    public Integer getTurnoverRate() {
        return this.turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    @NotNull(message = "Must be a number, between 1 and 12")
    @Min(value = 1)
    @Max(value = 12)
    public Integer getHoursUntilTurn() {
        return this.hoursUntilTurn;
    }

    public void setHoursUntilTurn(Integer hoursUntilTurn) {
        this.hoursUntilTurn = hoursUntilTurn;
    }

    public Magnitude getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DateBeforeTodayValidator
    public LocalDate getReleasedOn() {
        return this.releasedOn;
    }

    public void setReleasedOn(LocalDate releasedOn) {
        this.releasedOn = releasedOn;
    }

    @CapitalValidator
    public List<Capital> getCapitals() {
        return this.capitals;
    }

    public void setCapitals(List<Capital> capitals) {
        this.capitals = capitals;
    }
}
