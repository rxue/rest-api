package rx.jpaentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Equity {
	@Id
	private long id;
	@Column(name="ticker_symbol", unique = true)
	private String tickerSymbol;
	@ManyToOne
	private Company company;
	@ManyToOne
	private StockExchange stockExchange;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public StockExchange getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Equity) {
			return id == ((Equity) obj).id;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.build();
		
	}
}
