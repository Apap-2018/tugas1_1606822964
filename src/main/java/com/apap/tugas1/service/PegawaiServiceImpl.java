package com.apap.tugas1.service;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.PegawaiDb;

/**
 * PegawaiServiceImpl
 * @author Priscilla Tiffany
 *
 */
@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService{
	@Autowired
	private PegawaiDb pegawaiDb;

	@Override
	public PegawaiModel getPegawaiByNip(String nip) {
		return pegawaiDb.findByNip(nip);
	}

	@Override
	public void addPegawai(PegawaiModel pegawai) {
		pegawai.setNip(this.generateNIP(pegawai));
		pegawaiDb.save(pegawai);
	}

	@Override
	public String generateNIP(PegawaiModel pegawai) {	
		String nip = "";
		nip+=pegawai.getInstansi().getId();
        
		DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
        String strDate = dateFormat.format(pegawai.getTanggalLahir());
        nip+=strDate;
        
        nip+=pegawai.getTahunMasuk();
        
        int urutanPegawai = pegawaiDb.findByInstansiAndTanggalLahirAndTahunMasuk(pegawai.getInstansi(), pegawai.getTanggalLahir(), pegawai.getTahunMasuk()).size()+1;
        if(urutanPegawai<10) {
        	nip+="0";
        }
        nip+=urutanPegawai;
        
        return nip;
	}

	@Override
	public List<PegawaiModel> viewAll() {
		return pegawaiDb.findAll();
	}

	@Override
	public List<PegawaiModel> findByInstansi(InstansiModel instansi) {
		return pegawaiDb.findByInstansi(instansi);
	}

	@Override
	public Optional<PegawaiModel> getPegawaiById(BigInteger id) {
		return pegawaiDb.findById(id);
	}

	@Override
	public void updatePegawai(PegawaiModel pegawai) {
		PegawaiModel oldPegawai = pegawaiDb.findByNip(pegawai.getNip());
		oldPegawai.setNama(pegawai.getNama());
		oldPegawai.setTahunMasuk(pegawai.getTahunMasuk());
		oldPegawai.setInstansi(pegawai.getInstansi());
		oldPegawai.setTanggalLahir(pegawai.getTanggalLahir());
		oldPegawai.setTempatLahir(pegawai.getTempatLahir());
		oldPegawai.setDaftarJabatan(pegawai.getDaftarJabatan());
		
		oldPegawai.setNip(this.generateNIP(pegawai));
		pegawaiDb.save(oldPegawai);
		
	}
}
