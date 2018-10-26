package com.apap.tugas1.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;

/**
 *  PegawaiDB
 *  @author Priscilla Tiffany
 */
@Repository
public interface PegawaiDb extends JpaRepository<PegawaiModel, BigInteger>{
	PegawaiModel findByNip(String NIP);
	List<PegawaiModel> findByInstansiAndTanggalLahirAndTahunMasuk(InstansiModel instansi, Date tanggalLahir, String tahunMasuk);
	List<PegawaiModel> findByInstansi(InstansiModel instansi);
}
