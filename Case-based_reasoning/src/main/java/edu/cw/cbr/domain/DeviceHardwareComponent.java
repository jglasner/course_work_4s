package edu.cw.cbr.domain;

// Generated 27.04.2013 1:42:58 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DeviceHardwareComponent generated by hbm2java
 */
@Entity
@Table(name = "devicehardwarecomponent", schema = "public")
public class DeviceHardwareComponent{

	private int componentId;
	private Device device;
	private HardwareComponent hardwareComponent;

	public DeviceHardwareComponent() {
	}

	public DeviceHardwareComponent(int componentId, Device device,
			HardwareComponent hardwareComponent) {
		this.componentId = componentId;
		this.device = device;
		this.hardwareComponent = hardwareComponent;
	}

	@Id
	@Column(name = "component_id", unique = true, nullable = false)
	public int getComponentId() {
		return this.componentId;
	}

	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id", nullable = false)
	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hardware_component_id", nullable = false)
	public HardwareComponent getHardwarecomponent() {
		return this.hardwareComponent;
	}

	public void setHardwarecomponent(HardwareComponent hardwareComponent) {
		this.hardwareComponent = hardwareComponent;
	}

}