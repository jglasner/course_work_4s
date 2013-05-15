package edu.cw.cbr.model.domain;

// Generated 27.04.2013 1:42:58 by Hibernate Tools 4.0.0

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * NetworkAdapter generated by hbm2java
 */
@Entity
@Table(name = "networkadapter", schema = "public")
public class NetworkAdapter extends HardwareComponent{

	public final static int HARDWARE_TYPE = 4;
	private float maxSpeed;
	
	public NetworkAdapter() {
		
	}
	/**
	 * Creates new instance of  {@code NetworkAdapter}.
	 * 
	 * @param hcFamilyId the hardware component family's id.
	 * @param hcName the hardware component's name.
	 * @param maxSpeed - maximum data transfer rate(GT/s).
	 * @throws IllegalArgumentException if maxSpeed is less than zero.
	 */
	public NetworkAdapter(int hcFamilyId, String hcName,
			float maxSpeed) throws IllegalArgumentException {
				super(hcFamilyId, hcName);
		if(maxSpeed < 0)
			throw new IllegalArgumentException();
		this.setMaxSpeed(maxSpeed);
	}

	@Column(name = "max_speed", nullable = false, precision = 8, scale = 8)
	public float getMaxSpeed() {
		return this.maxSpeed;
	}

	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	@Override
	public List<Object> toList() {
		List<Object> instDataList = super.toList();
		instDataList.add(this.getMaxSpeed());
		return instDataList;
	}

}
