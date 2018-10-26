package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.apap.tugas1.model.ProvinsiModel;

/**
 *  ProvinsiService
 *  @author Priscilla Tiffany
 */
public interface ProvinsiService {
	List<ProvinsiModel> viewAll();
	Optional<ProvinsiModel> findProvinsiById(BigInteger id);
}
