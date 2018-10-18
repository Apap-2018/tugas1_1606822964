package com.apap.tugas1.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Model untuk Provinsi
 * @author Priscilla Tiffany
 */
@Entity
@Table(name = "jabatan_pegawai")
public class JabatanPegawaiModel {
	@Id
	@Size(max = 20)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}
}
