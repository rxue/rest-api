package rx.equity;

public final class Equity {
	private final String tickerSymbol;
	private final String companyName;
	private final long price;
	private Equity(Builder builder) {
		this.tickerSymbol = builder.tickerSymbol;
		this.companyName = builder.companyName;
		this.price = builder.price;
	}
	
	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public String getCompanyName() {
		return companyName;
	}

	public long getPrice() {
		return price;
	}

	public static class Builder {
		private String tickerSymbol;
		private String companyName;
		private long price;
		public Builder setTickerSymbol(String tickerSymbol) {
			this.tickerSymbol = tickerSymbol;
			return this;
		}
		public Builder setCompanyName(String companyName) {
			this.companyName = companyName;
			return this;
		}
		public Builder setPrice(long price) {
			this.price = price;
			return this;
		}
		public Equity build() {
			return new Equity(this);
		}
	}
}
