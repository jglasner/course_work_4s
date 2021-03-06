package edu.cw.cbr.model.domain;

// Generated 27.04.2013 1:42:58 by Hibernate Tools 4.0.0

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

import edu.cw.cbr.model.HardwareComponentFamilyUtil;

/**
 * HardwareComponent generated by hbm2java
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "hardwarecomponent", schema = "public")
public class HardwareComponent extends ArrayAble{

	private int hardwareComponentId;
	private HardwareComponentFamily hardwareComponentFamily;
	private String hardwareComponentName;

	public HardwareComponent() {
	}

	/**
	 * Creates new instance of  {@code HardwareComponent}.
	 * @param hcFamilyId the hardware component family's id.
	 * @param hcName the hardware component's name.
	 * @throws IllegalArgumentException if instance of 
	 * {@code HardwareComponentFamily} with identifier equal to hcFamilyId
	 * does not exists or hcName is empty.
	 */
	public HardwareComponent(int hcFamilyId, String hcName) {
		HardwareComponentFamily hcFamily = null;
		try {
			hcFamily = new HardwareComponentFamilyUtil()
			.getHardwareComponentFamily(hcFamilyId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
		if(hcName.isEmpty() || hcFamily == null)
			throw new IllegalArgumentException();
		this.setHardwareComponentFamily(hcFamily);
		this.setHardwareComponentName(hcName);
	}

	public HardwareComponent(int hardwareComponentId,
			HardwareComponentFamily hardwareComponentFamily,
			String hardwareComponentName) {
		this.hardwareComponentId = hardwareComponentId;
		this.hardwareComponentFamily = hardwareComponentFamily;
		this.hardwareComponentName = hardwareComponentName;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "hardware_component_id", unique = true, nullable = false)
	public int getHardwareComponentId() {
		return this.hardwareComponentId;
	}

	public void setHardwareComponentId(int hardwareComponentId) {
		this.hardwareComponentId = hardwareComponentId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hardware_component_family_id", nullable = false)
	public HardwareComponentFamily getHardwareComponentFamily() {
		return this.hardwareComponentFamily;
	}

	public void setHardwareComponentFamily(
			HardwareComponentFamily hardwareComponentFamily) {
		this.hardwareComponentFamily = hardwareComponentFamily;
	}

	@Column(name = "hardware_component_name", nullable = false, length = 256)
	public String getHardwareComponentName() {
		return this.hardwareComponentName;
	}

	public void setHardwareComponentName(String hardwareComponentName) {
		this.hardwareComponentName = hardwareComponentName;
	}
	
	@Override
	public List<Object> toList() {
		List<Object> instDataList = new ArrayList<Object>();
		instDataList.add(this.getHardwareComponentId());
		instDataList.add(this.getHardwareComponentFamily()
				.getDeveloper().getDeveloperName());
		instDataList.add(this.getHardwareComponentFamily()
				.getHardwareComponentFamilyName());
		instDataList.add(this.getHardwareComponentName());
		return instDataList;
	}

}
