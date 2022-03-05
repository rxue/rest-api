package rx.jpaentity;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class TimeSeriesItem {
	@EmbeddedId
	private TimeSeriesItemId compositeId;
	private BigDecimal closePrice;
	public BigDecimal getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(BigDecimal closePrice) {
		this.closePrice = closePrice;
	}
	
}
