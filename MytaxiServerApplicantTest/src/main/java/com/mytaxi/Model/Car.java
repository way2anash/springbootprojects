package com.mytaxi.Model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
    name = "car",
    uniqueConstraints = @UniqueConstraint(name = "uc_licenseplate", columnNames = {"licenseplate"})
)

public class Car {
	

    @Id
    @GeneratedValue
    @Column(name="car_id")
    private Long Id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    @NotNull(message = "License Plate can not be null!")
    @Size(min = 5, max = 15)
    private String licensePlate;

    @Column(nullable = false)
    @NotNull(message = "Seat-count can not be null!")
    @Min(2)
    private Integer seatCount;

    private Boolean convertible=false;
    
    @Column(nullable=true,scale=1)
    @Min(1) @Max(5)
    private BigDecimal rating=null;

    
    @Column(nullable = false)
    @NotNull(message="Engine type cannot be null!")
    private String engineType;

    @Column(nullable = false)
    @NotNull(message="Car manufacturer cannot be null!")
    private String manufacturer;

    @Column(nullable = false)
    private Boolean deleted = false;

    private Car()
    {
    }

	public Car(String licensePlate, int seatCount, String engineType, String manufacturer) {
		super();
		this.licensePlate = licensePlate;
		this.seatCount = seatCount;
		this.engineType = engineType;
		this.manufacturer = manufacturer;
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public int getSeatCount() {
		return seatCount;
	}

	

	public Boolean getConvertible() {
		return convertible;
	}

	public void setConvertible(Boolean convertible) {
		this.convertible = convertible;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

    public Boolean getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

}
