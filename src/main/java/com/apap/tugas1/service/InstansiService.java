package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.ProvinsiModel;

/**
 *  InstansiService
 *  @author Priscilla Tiffany
 */
public interface InstansiService {
	List<InstansiModel> viewAll();
	Optional<InstansiModel> findInstansiById(BigInteger id);
	List<InstansiModel> viewByProvinsi(ProvinsiModel provinsi);
	List<InstansiModel> viewByNama(String nama);
}
