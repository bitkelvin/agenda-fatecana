package com.fatecsp.agendafatecana.comparator;

import java.util.Comparator;

import com.fatecsp.agendafatecana.calendario.domain.Mes;

public class MesComparator implements Comparator<Mes>  {



	@Override
	public int compare(Mes a, Mes b) {
		return Integer.compare(a.getMes().ordinal(),b.getMes().ordinal());
	}
}
