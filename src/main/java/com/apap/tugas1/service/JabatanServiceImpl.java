package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.repository.JabatanDb;

/**
 * JabatanServiceImpl
 * @author Priscilla Tiffany
 *
 */
@Service
@Transactional
public class JabatanServiceImpl implements JabatanService{
	@Autowired
	private JabatanDb jabatanDb;

	@Override
	public void addJabatan(JabatanModel jabatan) {
		jabatanDb.save(jabatan);
	}

	@Override
	public List<JabatanModel> viewAll() {
		return jabatanDb.findAll();
	}

	@Override
	public Optional<JabatanModel> findJabatanById(BigInteger id) {
		return jabatanDb.findById(id);
	}

	@Override
	public void deleteJabatan(JabatanModel jabatan) {
		jabatanDb.delete(jabatan);		
	}
	

}
