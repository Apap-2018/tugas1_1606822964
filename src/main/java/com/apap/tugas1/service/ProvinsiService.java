package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;

import com.apap.tugas1.model.ProvinsiModel;

/**
 *  ProvinsiService
 *  @author Priscilla Tiffany
 */
public interface ProvinsiService {
	List<ProvinsiModel> viewAll();
	ProvinsiModel findProvinsiById(BigInteger id);
}
