package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;

/**
 *  PegawaiService
 *  @author Priscilla Tiffany
 */
public interface PegawaiService {
	PegawaiModel getPegawaiByNip(String nip);
	Optional<PegawaiModel> getPegawaiById(BigInteger id);
	void addPegawai(PegawaiModel pegawai);
	String generateNIP(PegawaiModel pegawai);
	List<PegawaiModel> viewAll();
	List<PegawaiModel> findByInstansi(InstansiModel instansi);
	void updatePegawai(PegawaiModel pegawai);
}
