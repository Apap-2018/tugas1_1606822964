package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.repository.InstansiDb;

/**
 *  InstansiServiceImpl
 *  @author Priscilla Tiffany
 */
@Service
@Transactional
public class InstansiServiceImpl implements InstansiService{
	@Autowired
	private InstansiDb instansiDb;

	@Override
	public List<InstansiModel> viewAll() {
		return instansiDb.findAll();
	}

	@Override
	public Optional<InstansiModel> findInstansiById(BigInteger id) {
		return instansiDb.findById(id);
	}

	@Override
	public List<InstansiModel> viewByProvinsi(ProvinsiModel provinsi) {
		return instansiDb.findByProvinsi(provinsi);
	}

	@Override
	public List<InstansiModel> viewByNama(String nama) {
		return instansiDb.findByNama(nama);
	}
}
