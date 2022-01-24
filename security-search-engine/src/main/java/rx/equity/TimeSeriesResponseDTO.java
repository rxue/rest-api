package rx.equity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TimeSeriesResponseDTO {
	private final String symbol;
	private final String timeZone;
	private final List<ClosePrice> closePrices;
	private TimeSeriesResponseDTO(Builder builder) {
		this.symbol = builder.symbol;
		this.timeZone = builder.timeZone;
		this.closePrices = builder.prices;
	}
	
	public String getSymbol() {
		return symbol;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public List<ClosePrice> getClosePrices() {
		return closePrices;
	}

	public static class Builder {
		private String symbol;
		private String timeZone;
		private List<ClosePrice> prices;
		public Builder setSymbol(String symbol) {
			this.symbol = symbol;
			return this;
		}
		public Builder setTimeZone(String timeZone) {
			this.timeZone = timeZone;
			return this;
		}
		public Builder setPrices(List<ClosePrice> prices) {
			this.prices = prices;
			return this;
		}
		public TimeSeriesResponseDTO build() {
			return new TimeSeriesResponseDTO(this);
		}
	}
	public static class ClosePrice {
		private final LocalDate date;
		private final BigDecimal priceValue;
		public ClosePrice(LocalDate date, BigDecimal priceValue) {
			super();
			this.date = date;
			this.priceValue = priceValue;
		}
		public LocalDate getDate() {
			return date;
		}
		public BigDecimal getPriceValue() {
			return priceValue;
		}
		
	}
}
