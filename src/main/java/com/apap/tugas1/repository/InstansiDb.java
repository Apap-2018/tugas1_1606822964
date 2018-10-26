package com.apap.tugas1.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.ProvinsiModel;

/**
 *  InstansiDB
 *  @author Priscilla Tiffany
 */
@Repository
public interface InstansiDb extends JpaRepository<InstansiModel, BigInteger>{
	List<InstansiModel> findByProvinsi(ProvinsiModel provinsi);
	List<InstansiModel> findByNama(String nama);
}
