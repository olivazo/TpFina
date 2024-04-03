package fr.emse.test;
import java.util.Objects;

public class Money implements IMoney {
	private int fAmount;
	private String fCurrency;

	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}

    @Override
    public IMoney add(IMoney m) {
        return m.addMoney(this);
    }

    @Override
    public IMoney addMoney(Money m) {
        if (m.currency().equals(currency()))
            return new Money(amount() + m.amount(), currency());
        return new MoneyBag(this, m);
    }

    @Override
    public IMoney addMoneyBag(MoneyBag bag) {
        return bag.add(this);
    }

	public int amount() {
		return fAmount;
	}

	public String currency() {
		return fCurrency;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Money money = (Money) obj;
		return fAmount == money.fAmount && Objects.equals(fCurrency, money.fCurrency);
	}
}
