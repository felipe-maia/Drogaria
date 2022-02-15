package br.com.maia.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class ItemVenda extends GenericDomain {

	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal valorParcial;

	@Column(nullable = false)
	private Short quantidadeProduto;

	@OneToOne
	@JoinColumn(nullable = false)
	private Produto produto;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Venda venda;

}
