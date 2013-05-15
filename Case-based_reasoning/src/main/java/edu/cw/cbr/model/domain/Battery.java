package edu.cw.cbr.model.domain;

// Generated 27.04.2013 1:42:58 by Hibernate Tools 4.0.0

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * Battery generated by hbm2java
 */
@Entity
@Table(name = "battery", schema = "public")
public class Battery extends HardwareComponent{

	public Battery() {
	}

	public final static int HARDWARE_TYPE = 1;	
	private float capacity;
	/**
	 * Creates new instance of  {@code Battery}.
	 * @param hcFamilyId the hardware component family's id.
	 * @param hcName the hardware component's name.
	 * @param capacity - battery capacity(mAh).
	 * @throws IllegalArgumentException if instance of {@code HardwareComponentFamily}
	 * does not exists or hcName is empty, or capacity is less than zero.
	 */
	public Battery(int hcFamilyId, String hcName,
			 float capacity) throws IllegalArgumentException {
		super(hcFamilyId, hcName);
		if(capacity < 0)
			throw new IllegalArgumentException();
		this.setCapacity(capacity);
	}
	
	@Column(name = "capacity", nullable = false, precision = 17, scale = 17)
	public float getCapacity() {
		return this.capacity;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public List<Object> toList() {
		List<Object> instDataList = super.toList();
		instDataList.add(this.getCapacity());
		return instDataList;
	}
}
