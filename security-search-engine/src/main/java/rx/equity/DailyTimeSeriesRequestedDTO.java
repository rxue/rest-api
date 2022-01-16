package rx.equity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TimeSeriesRequestedDTO {
	private final String symbol;
	private final LocalDate lastRefreshed;
	private final String timeZone;
	private final List<DailyItem> dailyItems;
	private TimeSeriesRequestedDTO(Builder builder) {
		this.symbol = builder.symbol;
		this.lastRefreshed = builder.lastRefreshed;
		this.timeZone = builder.timeZone;
		this.dailyItems = builder.dailyItems;
	}
	public class Metadata {
		public String getSymbol() {
			return symbol;
		}
		public String getTimeZone() {
			return timeZone;
		}
		public LocalDate getLastRefreshed() {
			return lastRefreshed;
		}
		
	}
	public List<DailyItem> getDailyItems() {
		return dailyItems;
	}
	public static class Builder {
		private final String symbol;
		private final LocalDate lastRefreshed;
		private final String timeZone;
		private List<DailyItem> dailyItems;
		public Builder(String symbol, LocalDate lastRefreshed, String timeZone) {
			this.symbol = symbol;
			this.lastRefreshed = lastRefreshed;
			this.timeZone = timeZone;
			dailyItems = new ArrayList<>();
		}
		public Builder addDailyItem(LocalDate date, BigDecimal closePrice) {
			dailyItems.add(new DailyItem(date, closePrice));
			return this;
		}
		public TimeSeriesRequestedDTO build() {
			return new TimeSeriesRequestedDTO(this);
		}
	}

	public static class DailyItem {
		private final LocalDate date;
		private final BigDecimal closePrice;
		private DailyItem(LocalDate date, BigDecimal closePrice) {
			this.date = date;
			this.closePrice = closePrice;
		}
		public LocalDate getDate() {
			return date;
		}
		public BigDecimal getClosePrice() {
			return closePrice;
		}
	}

}
