package br.com.cmdev.solidcomjava.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Reajuste {
	public BigDecimal valor();
	public LocalDate data();
}
