package com.apap.tugas1.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;

/**
 *  JabatanPegawaiDB
 *  @author Priscilla Tiffany
 */
@Repository
public interface JabatanPegawaiDb extends JpaRepository<JabatanPegawaiModel, Long>{
	JabatanPegawaiModel findById(BigInteger id);
}
