package com.apap.tugas1.controller;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;

/**
 *  JabatanController
 *  @author Priscilla Tiffany
 */
@Controller
public class JabatanController {
	@Autowired
	private JabatanService jabatanService;
	
	@Autowired
	private PegawaiService pegawaiService;
	
	@RequestMapping(value = "/jabatan/tambah", method = RequestMethod.GET)
	private String addJabatan(Model model) {
		model.addAttribute("jabatan", new JabatanModel());
		return "addJabatan";
	}
	
	@RequestMapping(value = "/jabatan/tambah", method = RequestMethod.POST)
	private String addJabatanSubmit(@ModelAttribute JabatanModel jabatan, Model model) {
		jabatanService.addJabatan(jabatan);
		model.addAttribute("jabatan", jabatan);
		return "addJabatanSukses";
	}
	
	@RequestMapping(value = "/jabatan/view", method = RequestMethod.GET)
	private String lihatJabatan(@RequestParam("idJabatan") BigInteger id, Model model) {
		JabatanModel jabatan = jabatanService.findJabatanById(id).get();
		List<PegawaiModel> allPegawai = pegawaiService.viewAll();
		int counter = 0;
		for(int i=0;i<allPegawai.size();i++) {
			for(int j=0;j<allPegawai.get(i).getDaftarJabatan().size();j++) {
				if(allPegawai.get(i).getDaftarJabatan().get(j)==jabatan)
					counter++;
			}
		}
		model.addAttribute("jabatan", jabatan);
		model.addAttribute("jumlahPegawai", counter);
		
		DecimalFormat df = new DecimalFormat("#,###");
		model.addAttribute("gaji", df.format(jabatan.getGaji_pokok()));
		model.addAttribute("message", "");
		return "lihatJabatan";
	}
	
	@RequestMapping(value = "/jabatan/hapus", method = RequestMethod.POST)
	private String delete(@ModelAttribute JabatanModel jabatan, Model model) throws Exception{
		String namaJabatan = jabatanService.findJabatanById(jabatan.getId()).get().getNama();
		try {
			jabatanService.deleteJabatan(jabatan);
	    }
		catch (Exception e) {
			model.addAttribute("message", "Maaf, jabatan tidak dapat dihapus");
			model.addAttribute("jabatan", jabatanService.findJabatanById(jabatan.getId()).get());
			return "lihatJabatan";
	    }
		
		model.addAttribute("namaJabatan", namaJabatan);
		return "hapusJabatanSukses";
	}
	
	@RequestMapping(value = "/jabatan/ubah", method = RequestMethod.GET)
	private String ubahJabatan(@RequestParam("idJabatan") BigInteger id, Model model) {
		model.addAttribute("jabatan", jabatanService.findJabatanById(id).get());
		model.addAttribute("message", "");
		return "ubahJabatan";
	}
	
	@RequestMapping(value = "/jabatan/ubah", method = RequestMethod.POST)
	private String ubahJabatanSubmit(@ModelAttribute JabatanModel jabatan, Model model) {
		JabatanModel jabatanLama = jabatanService.findJabatanById(jabatan.getId()).get();
		jabatanLama.setNama(jabatan.getNama());
		jabatanLama.setDeskripsi(jabatan.getDeskripsi());
		jabatanLama.setGaji_pokok(jabatan.getGaji_pokok());
		jabatanService.addJabatan(jabatanLama);
		
		model.addAttribute("jabatan", jabatan);
		model.addAttribute("message", "Data Jabatan Berhasil Diubah");
		return "ubahJabatan";
	}

	@RequestMapping(value = "/jabatan/viewall", method = RequestMethod.GET)
	private String lihatSemuaJabatan(Model model) {
		model.addAttribute("daftarJabatan", jabatanService.viewAll());
		return "lihatSemuaJabatan";
	}

}
