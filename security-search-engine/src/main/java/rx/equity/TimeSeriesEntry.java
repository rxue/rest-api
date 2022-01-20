package rx.equity;

import java.math.BigDecimal;

public final class TimeSeriesEntry {
	private final String symbol;
	private final String lastRefreshed;
	private final String timeZone;
	private final BigDecimal closePrice;
	private TimeSeriesEntry(Builder builder) {
		this.symbol = builder.symbol;
		this.lastRefreshed = builder.lastRefreshed;
		this.timeZone = builder.timeZone;
		this.closePrice = builder.closePrice;
	}

	public String getSymbol() {
		return symbol;
	}



	public String getLastRefreshed() {
		return lastRefreshed;
	}



	public String getTimeZone() {
		return timeZone;
	}



	public BigDecimal getClosePrice() {
		return closePrice;
	}



	public static class Builder {
		private String symbol;
		private String lastRefreshed;
		private String timeZone;
		private BigDecimal closePrice;
		
		public Builder setSymbol(String symbol) {
			this.symbol = symbol;
			return this;
		}
		public Builder setLastRefreshed(String lastRefreshed) {
			this.lastRefreshed = lastRefreshed;
			return this;
		}
		public Builder setTimeZone(String timeZone) {
			this.timeZone = timeZone;
			return this;
		}
		public Builder setClosePrice(BigDecimal closePrice) {
			this.closePrice = closePrice;
			return this;
		}
		public TimeSeriesEntry build() {
			return new TimeSeriesEntry(this);
		}
		
	}
}
