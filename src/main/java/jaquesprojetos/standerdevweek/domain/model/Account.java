package jaquesprojetos.standerdevweek.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_account")
public class Account {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(unique = true)
		private String number;
		
		private String agency;
		
		@Column(precision = 2, scale = 13)
		private BigDecimal balance;
		
		@Column(name = "additional_Limit", precision = 2, scale = 13)
		private BigDecimal limit;
		
		public BigDecimal getLimit() {
				return limit;
		}
		
		public void setLimit(BigDecimal limit) {
				this.limit = limit;
		}
		
		public BigDecimal getBalance() {
				return balance;
		}
		
		public void setBalance(BigDecimal balance) {
				this.balance = balance;
		}
		
		public String getAgency() {
				return agency;
		}
		
		public void setAgency(String agency) {
				this.agency = agency;
		}
		
		public String getNumber() {
				return number;
		}
		
		public void setNumber(String number) {
				this.number = number;
		}
		
		public Long getId() {
				return id;
		}
		
		public void setId(Long id) {
				this.id = id;
		}
}