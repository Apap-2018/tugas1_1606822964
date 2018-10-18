package com.apap.tugas1.controller;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.service.InstansiService;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;

/**
 *  PegawaiController
 *  @author Priscilla Tiffany
 */
@Controller
public class PegawaiController {
	@Autowired
	private PegawaiService pegawaiService;
	
	@Autowired
	private JabatanService jabatanService;
	
	@Autowired
	private InstansiService instansiService;
	
	@RequestMapping("/")
	private String home(Model model) {
		model.addAttribute("allJabatan", jabatanService.viewAll());
		model.addAttribute("allInstansi", instansiService.viewAll());
		return "home";
	}
	
	@RequestMapping(value = "/pegawai", method = RequestMethod.GET)
	private String lihatPegawai(@RequestParam("nip") String nip, Model model) {
		PegawaiModel pegawai = pegawaiService.getPegawaiByNip(nip);
		
		
		DecimalFormat df = new DecimalFormat("#");
		
		model.addAttribute("pegawai", pegawai);
		model.addAttribute("gaji", df.format(pegawai.getGaji()));
		return "lihatPegawai";
	}
	
	@RequestMapping(value = "/pegawai/termuda-tertua", method = RequestMethod.GET)
	private String lihatPegawaiTermudaTertua(@RequestParam("idInstansi") BigInteger idInstansi, Model model) {
		InstansiModel instansi = instansiService.findInstansiById(idInstansi);
		List<PegawaiModel> daftarPegawai = instansi.getPegawaiList();
		

		if(daftarPegawai.isEmpty()) {
			model.addAttribute("message", "Tidak ada pegawai yang terdaftar dalam instansi ini");
			model.addAttribute("pegawaiTermuda", new PegawaiModel());
			model.addAttribute("pegawaiTertua",  new PegawaiModel());
			return "lihatPegawaiTermudaTertua";
		}
		PegawaiModel pegawaiTermuda = daftarPegawai.get(0);
		PegawaiModel pegawaiTertua = daftarPegawai.get(0);
		if(daftarPegawai.size()==1) {
			model.addAttribute("message", "Hanya ada satu pegawai dalam intansi ini");
		}
		else {
			for(int i=0;i<daftarPegawai.size();i++) {
				if(daftarPegawai.get(i).getUmur()<pegawaiTermuda.getUmur()) {
					pegawaiTermuda = daftarPegawai.get(i);
				}
				else if (daftarPegawai.get(i).getUmur()>pegawaiTertua.getUmur()){
					pegawaiTertua = daftarPegawai.get(i);
				}
			}
			model.addAttribute("message", "");
		}	
		
		model.addAttribute("pegawaiTermuda", pegawaiTermuda);
		model.addAttribute("gajiPegawaiTermuda", pegawaiTermuda.getGaji());
		
		model.addAttribute("pegawaiTertua", pegawaiTertua);
		model.addAttribute("gajiPegawaiTertua", pegawaiTertua.getGaji());
		
		return "lihatPegawaiTermudaTertua";
	}

}
