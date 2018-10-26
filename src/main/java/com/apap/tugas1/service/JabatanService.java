package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.apap.tugas1.model.JabatanModel;

/**
 *  JabatanService
 *  @author Priscilla Tiffany
 */
public interface JabatanService {
	void addJabatan(JabatanModel jabatan);
	List<JabatanModel> viewAll();
	Optional<JabatanModel> findJabatanById(BigInteger id);
	void deleteJabatan(JabatanModel jabatan);
}
