package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;

/**
 *  PegawaiService
 *  @author Priscilla Tiffany
 */
public interface PegawaiService {
	PegawaiModel getPegawaiByNip(String nip);
	void addPegawai(PegawaiModel pegawai);
	String generateNIP(PegawaiModel pegawai);
	List<PegawaiModel> viewAll();
	List<PegawaiModel> findByInstansi(InstansiModel instansi);
}
