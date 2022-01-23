package rx.equity;

import java.math.BigDecimal;

final class PriceQuarternity {
	private final String open;
	private final String close;
	private final String high;
	private final String low;
	private PriceQuarternity(Builder builder) {
		this.open = builder.open;
		this.close = builder.close;
		this.high = builder.high;
		this.low = builder.low;
	}
	

	public String getOpen() {
		return open;
	}


	public String getClose() {
		return close;
	}


	public String getHigh() {
		return high;
	}


	public String getLow() {
		return low;
	}


	public static class Builder {
		private String open;
		private String close;
		private String high;
		private String low;
		public Builder setOpen(String open) {
			this.open = open;
			return this;
		}
		public Builder setClose(String close) {
			this.close = close;
			return this;
		}
		public Builder setHigh(String high) {
			this.high = high;
			return this;
		}
		public Builder setLow(String low) {
			this.low = low;
			return this;
		}
		public PriceQuarternity build() {
			return new PriceQuarternity(this);
		}
	}
}
