package edu.cw.cbr.domain;

// Generated 27.04.2013 1:42:58 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * HardwareComponent generated by hbm2java
 */
@Entity
@Table(name = "hardwarecomponent", schema = "public")
public class HardwareComponent{

	private int hardwareComponentId;
	private HardwareComponentfamily hardwareComponentfamily;
	private String hardwareComponentName;
	private NetworkAdapter networkAdapter;
	private Battery battery;
	private Set<DeviceHardwareComponent> deviceHardwareComponents = new HashSet<DeviceHardwareComponent>(
			0);
	private MemoryModule memoryModule;
	private Processor processor;

	public HardwareComponent() {
	}

	public HardwareComponent(int hardwareComponentId,
			HardwareComponentfamily hardwareComponentfamily,
			String hardwareComponentName) {
		this.hardwareComponentId = hardwareComponentId;
		this.hardwareComponentfamily = hardwareComponentfamily;
		this.hardwareComponentName = hardwareComponentName;
	}

	public HardwareComponent(int hardwareComponentId,
			HardwareComponentfamily hardwareComponentfamily,
			String hardwareComponentName, NetworkAdapter networkAdapter,
			Battery battery,
			Set<DeviceHardwareComponent> deviceHardwareComponents,
			MemoryModule memoryModule, Processor processor) {
		this.hardwareComponentId = hardwareComponentId;
		this.hardwareComponentfamily = hardwareComponentfamily;
		this.hardwareComponentName = hardwareComponentName;
		this.networkAdapter = networkAdapter;
		this.battery = battery;
		this.deviceHardwareComponents = deviceHardwareComponents;
		this.memoryModule = memoryModule;
		this.processor = processor;
	}

	@Id
	@Column(name = "hardware_component_id", unique = true, nullable = false)
	public int getHardwareComponentId() {
		return this.hardwareComponentId;
	}

	public void setHardwareComponentId(int hardwareComponentId) {
		this.hardwareComponentId = hardwareComponentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hardware_component_family_id", nullable = false)
	public HardwareComponentfamily getHardwarecomponentfamily() {
		return this.hardwareComponentfamily;
	}

	public void setHardwarecomponentfamily(
			HardwareComponentfamily hardwareComponentfamily) {
		this.hardwareComponentfamily = hardwareComponentfamily;
	}

	@Column(name = "hardware_component_name", nullable = false, length = 256)
	public String getHardwareComponentName() {
		return this.hardwareComponentName;
	}

	public void setHardwareComponentName(String hardwareComponentName) {
		this.hardwareComponentName = hardwareComponentName;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "hardwarecomponent")
	public NetworkAdapter getNetworkadapter() {
		return this.networkAdapter;
	}

	public void setNetworkadapter(NetworkAdapter networkAdapter) {
		this.networkAdapter = networkAdapter;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "hardwarecomponent")
	public Battery getBattery() {
		return this.battery;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hardwarecomponent")
	public Set<DeviceHardwareComponent> getDevicehardwarecomponents() {
		return this.deviceHardwareComponents;
	}

	public void setDevicehardwarecomponents(
			Set<DeviceHardwareComponent> deviceHardwareComponents) {
		this.deviceHardwareComponents = deviceHardwareComponents;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "hardwarecomponent")
	public MemoryModule getMemorymodule() {
		return this.memoryModule;
	}

	public void setMemorymodule(MemoryModule memoryModule) {
		this.memoryModule = memoryModule;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "hardwarecomponent")
	public Processor getProcessor() {
		return this.processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

}