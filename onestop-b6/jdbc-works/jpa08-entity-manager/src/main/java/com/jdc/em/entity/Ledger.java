package com.jdc.em.entity;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ledger")
public class Ledger implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true, length = 30)
	@Basic(optional = false, fetch = FetchType.LAZY)
	private String name;

	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private LedgerType type;
	
	@ElementCollection
	@CollectionTable(name = "tags", 
	joinColumns = @JoinColumn(name = "ledger_id"))
	@Column(name = "tag")
	private List<String> tags;
	
	@OneToMany(mappedBy = "ledger", 
			cascade = { PERSIST, MERGE}, orphanRemoval = true )
	private List<Transaction> transactions = new ArrayList<>();

	public Ledger() {
	}
	
	public Ledger(String name, LedgerType type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	// Helper Method 
	public void addTransaction(Transaction tran) {
		this.transactions.add(tran);
		tran.setLedger(this);
	}

	public enum LedgerType {
		Credit, Debit
	}

}
