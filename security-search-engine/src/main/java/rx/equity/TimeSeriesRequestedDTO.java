package rx.equity;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

class TimeSeriesRequestedDTO<T extends Temporal> {
	private final Metadata metadata;
	private final List<Price<T>> priceSeries;
	private TimeSeriesRequestedDTO(Builder<T> builder) {
		this.metadata = new Metadata(builder.information, builder.symbol, builder.lastRefreshed, builder.timeZone);
		this.priceSeries = builder.priceSeries;
	}

	public class Metadata {
		private final String information;
		private final String symbol;
		private final T lastRefreshed;
		private final String timeZone;
		public Metadata(String information, String symbol, T lastRefreshed, String timeZone) {
			this.information = information;
			this.symbol = symbol;
			this.lastRefreshed = lastRefreshed;
			this.timeZone = timeZone;
		}
	}
	
	public static class Price<T extends Temporal> {
		private final T timeStamp;
		private final PriceQuarternity priveQuarternity;
		public Price(T timeStamp, PriceQuarternity priveQuarternity) {
			this.timeStamp = timeStamp;
			this.priveQuarternity = priveQuarternity;
		}
		public T getTimeStamp() {
			return timeStamp;
		}
		public PriceQuarternity getPriveQuarternity() {
			return priveQuarternity;
		}
		
	}
	
	public static class Builder<T extends Temporal> {
		private String information;
		private String symbol;
		private T lastRefreshed;
		private String timeZone;
		private List<Price<T>> priceSeries;
		public Builder() {
			priceSeries = new ArrayList<>();
		}
		public Builder<T> setInformation(String information) {
			this.information = information;
			return this; 
		}
		public Builder<T> setSymbol(String symbol) {
			this.symbol = symbol;
			return this;
		}
		public Builder<T> setLastRefreshed(T lastRefreshed) {
			this.lastRefreshed = lastRefreshed;
			return this;
		}
		public Builder<T> setTimeZone(String timeZone) {
			this.timeZone = timeZone;
			return this;
		}
		public Builder<T> appendPrice(T timeStamp, PriceQuarternity priceValues) {
			priceSeries.add(new Price<T>(timeStamp, priceValues));
			return this;
		}
		public TimeSeriesRequestedDTO<T> build() {
			return new TimeSeriesRequestedDTO<T>(this);
		}
	}
}
