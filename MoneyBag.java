package fr.emse.test;

import java.util.Objects;
import java.util.Vector;

class MoneyBag implements IMoney {
	private Vector<Money> fMonies = new Vector<Money>();

	MoneyBag(Money m1, Money m2) {
		appendMoney(m1);
		appendMoney(m2);
	}
	 @Override
	    public IMoney add(IMoney m) {
	        return m.addMoneyBag(this);
	    }

	    @Override
	    public IMoney addMoney(Money m) {
	        appendMoney(m);
	        return this;
	    }

	    @Override
	    public IMoney addMoneyBag(MoneyBag bag) {
	        for (Money m : bag.fMonies) {
	            appendMoney(m);
	        }
	        return this;
	    }
	@Override
	public boolean equals(Object obj) {
		if(this == obj) 
			return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		MoneyBag moneyBag = (MoneyBag) obj;
		return Objects.equals(fMonies, moneyBag.fMonies);
	}

	public MoneyBag(Money... m ) {
		for (Money money : m)
			appendMoney(money);
	}

	private void appendMoney(Money m) {
		if (fMonies.isEmpty()) {
			fMonies.add(m);
		} else {
			int i = 0;
			while ((i < fMonies.size()) && (!(fMonies.get(i).currency().equals(m.currency()))))
				i++;
			if (i >= fMonies.size()) {
				fMonies.add(m);
			} else {
				fMonies.set(i, new Money(fMonies.get(i).amount() + m.amount(), m.currency()));
			}
		}
	}
}