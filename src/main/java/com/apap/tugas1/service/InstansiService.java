package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;

import com.apap.tugas1.model.InstansiModel;

/**
 *  InstansiService
 *  @author Priscilla Tiffany
 */
public interface InstansiService {
	List<InstansiModel> viewAll();
	InstansiModel findInstansiById(BigInteger id);
}
