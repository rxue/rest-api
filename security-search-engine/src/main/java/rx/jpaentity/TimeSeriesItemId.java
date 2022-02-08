package rx.jpaentity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
@Embeddable
public class TimeSeriesItemId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="equity_id")
	private Equity equity;
	private LocalDate date;
	@Override
	public boolean equals(Object obj) {
		//Implementation based on: https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/builder/EqualsBuilder.html
		if (obj == null) return false;
		if (obj == this) return true; 
		if (obj.getClass() != getClass())
		     return false;
		TimeSeriesItemId that = (TimeSeriesItemId) obj;
		return new EqualsBuilder()
					.append(equity, that.equity)
					.append(date, that.date)
					.build();
	}
	@Override
	public int hashCode() {
		//Implementation base on: https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/builder/HashCodeBuilder.html
		return new HashCodeBuilder(17,37)
				.append(equity)
				.append(date)
				.build();
	}
}
