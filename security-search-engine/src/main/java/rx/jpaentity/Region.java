package rx.jpaentity;

public enum Region {
	AMERICA(Currency.USD), FINLAND(Currency.EURO), GERMANY(Currency.EURO), CHINA(Currency.CNY), HONG_KONG(Currency.HKD);
	private Currency currency;
	private Region(Currency currency) {
		this.currency = currency;
	}
	
}
