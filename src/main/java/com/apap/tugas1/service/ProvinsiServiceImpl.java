package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.repository.ProvinsiDb;

/**
 * ProvinsiServiceImpl
 * @author Priscilla Tiffany
 *
 */
@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService{
	@Autowired
	private ProvinsiDb provinsiDb;

	@Override
	public List<ProvinsiModel> viewAll() {
		return provinsiDb.findAll();
	}

	@Override
	public Optional<ProvinsiModel> findProvinsiById(BigInteger id) {
		return provinsiDb.findById(id);
	}

}
